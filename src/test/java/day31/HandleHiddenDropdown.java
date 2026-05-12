package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleHiddenDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		
		
		//login
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']")).click();
		
		//click on PIM 
		driver.findElement(By.xpath("//a[normalize-space()='PIM']")).click();
		
		//open the dropdown
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[2]")).click();
		
		Thread.sleep(5000);
		
		//select single option
		//driver.findElement(By.xpath("//span[normalize-space()='Account Assistant']")).click();

		//count number of option
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']//span"));
		System.out.println("Total number of options: " + options.size());
		
		for(WebElement opt: options) {
			System.out.println(opt.getText());
		}
	
	
	
	
	}

}
