package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; //populate common info 
	public ExtentTest test; //creating test case entries in the report and update status of the test methods
	
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.clearProperty("user.dir")+"/reports/myReport.html");
		
		sparkReporter.config().setDocumentTitle("Automation Report"); //Title of the report
		sparkReporter.config().setReportName("Functional Testing"); //Title of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Khang");
		extent.setSystemInfo("os", "Windows 11");
		extent.setSystemInfo("Browser name", "Chrome");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.PASS, "Test case PASSED is: " + result.getName()); //update status p/f/s
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.FAIL, "Test case FAILED is: " + result.getName()); //update status p/f/s
		test.log(Status.FAIL, "Test case FAILED cause is: " + result.getThrowable()); //update status p/f/s
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName()); //update status p/f/s
		}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
	
}
