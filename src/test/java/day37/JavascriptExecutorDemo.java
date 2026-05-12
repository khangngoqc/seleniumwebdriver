package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
		
		
		//passing the text into inputbox - alternate of sendKeys(
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','John')", inputBox);
		
		//clicking on element - alternate of click()
		WebElement radio = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radio);
	}

}
