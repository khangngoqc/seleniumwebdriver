package day22;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
Assignment
-------------------------------------
Open application "https://www.demoblaze.com/index.html"
1) Total number of links & print them
2) Total number of images
3) Click on Any product link using linkText /partialLink Text
*/

public class Assignment {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// 1
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();

		// Wait 3 seconds for the page to fully loaded 
		try {
		    Thread.sleep(3000); 
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links found: " + links.size());

		
		System.out.println("List of links: ");
		
		for(WebElement x : links) 
		{ 
			 System.out.println(x.getAttribute("href")); 
		}

		
		// 2
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("\nNumber of images found: " + images.size());

		System.out.println("List of image: ");

		for (WebElement img : images) {
			System.out.println(img.getAttribute("src"));
		}

		// 3
		driver.findElement(By.partialLinkText("Samsung")).click();

		
		driver.quit();

	}

}
