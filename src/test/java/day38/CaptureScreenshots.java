package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration .ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		//1) full page screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		/*
		 * File sourceFile = ts.getScreenshotAs(OutputType.FILE); File targetFile = new
		 * File(System.getProperty("user.dir") + "\\screenshots\\fullpage.png");
		 * sourceFile.renameTo(targetFile); //copy sourceFile to targetFile
		 */
		
		
		//2) Specific area screenshot
		WebElement uploadSection = driver.findElement(By.xpath("//div[@id='HTML15']"));
		/*
		 * File sourceFile = uploadSection.getScreenshotAs(OutputType.FILE); File
		 * targetFile = new File(System.getProperty("user.dir") +
		 * "\\screenshots\\uploadSection.png"); sourceFile.renameTo(targetFile); //copy
		 * sourceFile to targetFile
		 */
		
		
		//3) capture the screenshot of webelement
		WebElement icon =  driver.findElement(By.xpath("//img[@class='wikipedia-icon']"));
		
		File sourceFile = icon.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "\\screenshots\\icon.png");
		sourceFile.renameTo(targetFile); //copy sourceFile to targetFile
		
		
		
		driver.quit();
		
	}

}
