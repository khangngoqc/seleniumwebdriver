package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
https://cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator
*/
public class Assigment {

	public static void main(String[] args) throws IOException {

		// Green color code
		String green = "\u001B[32m";
		// Red color code
		String red = "\u001B[31m";
		// Reset color code
		String reset = "\u001B[0m";

		FileInputStream propsFile = new FileInputStream(
				System.getProperty("user.dir") + "\\testdata\\config.properties");
		String dataFilePath = System.getProperty("user.dir") + "\\testdata\\Book1.xlsx";

		Properties propsObj = new Properties();

		propsObj.load(propsFile);

		String url = propsObj.getProperty("assURL");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		int rows = ExcelUtils.getRowCount(dataFilePath, "Sheet1");

		WebElement rateEle = driver.findElement(By.xpath("(//input[@id='mat-input-2'])[1]"));

		//close cookie banner
		driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")).click();

		//String rate = driver.findElement(By.xpath("(//input[@id='mat-input-2'])[1]")).getAttribute("value");
		//System.out.println(rate);

		//driver.findElement(By.xpath("(//input[@id='mat-input-2'])[1]")).click();


		WebElement button = driver.findElement(By.xpath("//div//button[@type='submit']"));

		for (int i = 1; i <= rows; i++) { // clear previous input
			driver.findElement(By.xpath("(//input[@id='mat-input-0'])[1]")).clear();
			driver.findElement(By.xpath("(//input[@id='mat-input-1'])[1]")).clear();
			driver.findElement(By.xpath("(//input[@id='mat-input-2'])[1]")).clear();

			// get test value data
			String deposit = ExcelUtils.getCellData(dataFilePath, "Sheet1", i, 0);
			String length = ExcelUtils.getCellData(dataFilePath, "Sheet1", i, 1);
			String interest = ExcelUtils.getCellData(dataFilePath, "Sheet1", i, 2);
			String compounding = ExcelUtils.getCellData(dataFilePath, "Sheet1", i, 3);
			String total = ExcelUtils.getCellData(dataFilePath, "Sheet1", i, 4);

			// send test value to fields
			driver.findElement(By.xpath("(//input[@id='mat-input-0'])[1]")).sendKeys(deposit);
			driver.findElement(By.xpath("(//input[@id='mat-input-1'])[1]")).sendKeys(length);
			driver.findElement(By.xpath("(//input[@id='mat-input-2'])[1]")).clear();
			
			//handle no text value interest field
			js.executeScript("arguments[0].value='"+ interest +"';", rateEle);
			driver.findElement(By.xpath("(//input[@id='mat-input-2'])[1]")).sendKeys("a");

			// handle mat-select
			driver.findElement(By.xpath("//mat-form-field//mat-select")).click();
			List<WebElement> compoundOpts = driver.findElements(By.xpath("//mat-option"));
			for (WebElement e : compoundOpts) {
				if (e.getText().equals(compounding)) {
					System.out.println(e.getText());
					e.click();
				}

			}

			// get actual total result
			js.executeScript("arguments[0].click();", button);
			String act_total = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			System.out.println(act_total);

			// compare actual to expected total
			if (act_total.equals(total)) {
				System.out.println(green + "Case Passed" + reset);
				ExcelUtils.setCellData(dataFilePath, "Sheet1", i, 6, "Passed");
				ExcelUtils.fillGreenColor(dataFilePath, "Sheet1", i, 6);

			} else {
				System.out.println(red + "Case Failed!" + reset);
				ExcelUtils.setCellData(dataFilePath, "Sheet1", i, 6, "Failed");
				ExcelUtils.fillRedColor(dataFilePath, "Sheet1", i, 6);
			}
			System.out.println();

		}

		driver.quit();

	}

}
