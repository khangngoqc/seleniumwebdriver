package TipsAndTrick;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestUsingDataProvider {

	@Test(dataProvider = "loginData")
	void LoginTest(String email, String password) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/login");
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		boolean loginStatus;
		try {
			loginStatus = driver.findElement(By.xpath("//a[normalize-space()='Log out']")).isDisplayed();
			Assert.assertTrue(loginStatus);
		
		} catch (Exception e) {
			loginStatus =false;
			Assert.assertTrue(loginStatus);
			
		} finally {
			driver.quit();
		}
		
	}
	
	
	@DataProvider(parallel = true, indices = {0,1})
	public String[][] loginData(){
		
		String[][] data = {
				{"lubywu@mailinator.com", "123123Sd@"},
				{"jane,smith321@example.com", "test321"},
				{"laura.taylor1234@example.com", "test123"},
				{"john.doe1234@example.com", "test123"},
				{"lubywu@mailinator.com", "123123Sd@"},
				{"laura.taylor1234@example.com", "test123"}
		};
		
		return data;
	}
	
	
}
