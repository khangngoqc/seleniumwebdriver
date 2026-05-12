package day36;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenTheLinkInNewTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement link = driver.findElement(By.xpath("//a[normalize-space()='Online Trainings']"));
		
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).perform();
	
		List<String> ids = new ArrayList(driver.getWindowHandles());
		
		driver.switchTo().window(ids.get(1));
		System.out.println(driver.findElement(By.xpath("//span[normalize-space()='AI Powered DevOps with AWS Online Training']")).getText());
		
		driver.switchTo().window(ids.get(0));
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Back");
		
	}

}
