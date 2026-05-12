package day39;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		
		//capture all the links from the webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());
		
		int noOfBrokenLink = 0;
		
		for(WebElement l : links) {
			
			String hrefAttrValue = l.getAttribute("href"); 
			
			if(hrefAttrValue==null|| hrefAttrValue.isEmpty()) {
				System.out.println(l.getText() + "href attribute value is empty => Impossible to check");
				continue;
			}
			
			
			//hit the URL to the server
			try {
				
				URL linkURL = new URL(hrefAttrValue); //converted href value from string to URL format
				HttpURLConnection conn = (HttpURLConnection)linkURL.openConnection(); //open connection to the server
				conn.connect(); //connect to server and send request to the server
			
				if(conn.getResponseCode()>= 400) {
					System.out.println(hrefAttrValue + " (Broken link)");
					noOfBrokenLink++;
				}else {
					System.out.println(hrefAttrValue+ " => Not a broken link");
				}
				
			} catch (Exception e) {}
	
		}
		
		System.out.println("Number of broken links: " + noOfBrokenLink);
		
		
		
		
		
		
	}

}
