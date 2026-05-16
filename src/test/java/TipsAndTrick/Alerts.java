package TipsAndTrick;

//How to handle Alerts without using switchTo().alert();

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		
		//1)
		/*Alert alert = driver.switchTo().alert();
		alert.accept();
		*/
		
		//2)
		/*WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		*/
		
		//3)
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.alert=function{};");	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
