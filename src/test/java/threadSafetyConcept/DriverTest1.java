package threadSafetyConcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DriverTest1 {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	 
	public WebDriver getDriver() {
		return driver.get();
	}
	
	@Test
	void mytest1() {
		driver.set(ThreadGuard.protect(new ChromeDriver()));
			
		getDriver().get("https://www.google.com/");
		System.out.println(getDriver().getTitle());
		
	}
	
	@Test
	void mytest2() {
		driver.set(ThreadGuard.protect(new EdgeDriver()));
	
		getDriver().get("https://www.bing.com/");
		System.out.println(getDriver().getTitle());
	}
	
	@AfterMethod
	void tearDown() {
		getDriver().quit();
		driver.remove();
	}
	
	
	
}
