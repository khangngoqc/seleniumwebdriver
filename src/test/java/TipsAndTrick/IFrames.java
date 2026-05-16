package TipsAndTrick;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrames {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		//1.
		/*WebElement frameElement = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Testing");
		*/
		
		
		//2. using explicit wait
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@src='frame_1.html']")));
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Testing");
		
	}

}
