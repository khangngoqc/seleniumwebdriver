package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Handling alert without using switchTo().alert()


public class HandleAlertUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5)); //explicit wait declaration
		
		
		
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		
		Thread.sleep(3000);
		
		Alert myAlert = mywait.until(ExpectedConditions.alertIsPresent());	//capture alert
		
		
		System.out.println(myAlert.getText());
		
		myAlert.dismiss();	//close alert with Cancel button
	
	
	
	
	
	}

}
