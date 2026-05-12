package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		
		
		//get(url) - opens the url on the browser  
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//getTitle() - returns the title of the web page
		System.out.println(driver.getTitle());
		
		//getCurrenUrl() - returns URL of the web page
		System.out.println(driver.getCurrentUrl());
		
		//getPageSource() - returns the source of the web page
		//System.out.println(driver.getPageSource());
		
		//getWindowHandle() - returns the ID of the single browser widow
		String windowID = driver.getWindowHandle();
		System.out.println("Window ID: " + windowID);
		
		//getWindowHandles() - returns the ID of the multiple browser widow
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // this will opens new browser window
		
		Set <String>windowIdSet = driver.getWindowHandles(); //window ID is unique -> use Set instead of List
		
		System.out.println(windowIdSet);
		
		driver.quit();
		
	}

}
