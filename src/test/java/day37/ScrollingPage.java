package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//scroll down page by pixel number
		/*
		 * js.executeScript("window.scrollBy(0,1000)","");
		 */
		
		
		//scroll the page till the element is visible
		//WebElement ele = driver.findElement(By.xpath("//img[@alt='Flag of Vietnam']"));
		/*
		 * js.executeScript("arguments[0].scrollIntoView()", ele);
		 * System.out.println(js.executeScript("return window.pageYOffset;"));
		 */
		
		//scroll page till  end of the page
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(3000);
		
		//scrolling up to initial position
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		
	
	}

}
