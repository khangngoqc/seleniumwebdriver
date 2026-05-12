package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://text-compare.com/");
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Selenium");
		
		Actions act = new Actions(driver);
		
		//Ctrl + A - Select the text
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		
		//Ctrl + C - copy the text into clipboard
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		
		//TAB - Shift to 2nd box
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		
		//CTRL+V - paste the text
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
	}
	
	

}
