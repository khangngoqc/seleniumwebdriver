package day46;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(day46.MyListener.class )
public class OrangeHRM {

	WebDriver driver;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}


	@Test(priority = 2)
	void testAppURL() {
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	
	
	@Test(priority = 3, dependsOnMethods = "testAppURL")
	void testLogo() throws InterruptedException {
		Thread.sleep(1000);
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.fail();
 
	}

	@Test(priority = 4, dependsOnMethods = "testLogo")
	void testHomePageTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
