package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Normal alert with OK button
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		Thread.sleep(3000);
		
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();
		*/
		
		
		//2) confirrmation Alert - OK & Cancel
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		
		Thread.sleep(3000);
		
		Alert myAlert = driver.switchTo().alert();
		//myAlert.accept();	//close alert with OK button
		myAlert.dismiss();	//close alert with Cancel button
		*/
		
		
		//3) Prompt alert - Input Box
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		Thread.sleep(3000);
		
		Alert myAlert = driver.switchTo().alert();
		myAlert.sendKeys("welcome");
		myAlert.accept();	//close alert with OK button
	}

}
