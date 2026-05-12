package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/buttons/");
		
		WebElement rightClickBtn = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		
		Actions act = new Actions(driver);
		
		act.contextClick(rightClickBtn).perform();
		
		String message = driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText();
		
		System.out.println(message);
	}

}
