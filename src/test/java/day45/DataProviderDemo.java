package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	WebDriver driver;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "dp")
	void testLogin(String email, String pwd) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(1000);

		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if (status == true) {
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}

	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "dp", indices= {3,4})
	Object[][] loginData() {

		Object data[][] = { { "abc@gmail.com", "test123" }, { "xya@gmail.com", "test123" },
				{ "john@gmail.com", "test@123" }, { "zoxakezu@mailinator.com", "test@123" },
				{ "johncanedy@gmail.com", "test" }, };

		return data;

	}

}
