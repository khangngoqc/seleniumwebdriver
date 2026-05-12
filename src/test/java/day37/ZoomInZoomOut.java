package day37;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		//driver.manage().window().minimize();
		//driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='50%'"); //set zoom level
		Thread.sleep(2000);
	
		js.executeScript("document.body.style.zoom='75%'"); //set zoom level
		Thread.sleep(2000);

		js.executeScript("document.body.style.zoom='100%'"); //set zoom level
		
	}

}
