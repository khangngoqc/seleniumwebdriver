package day28;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Assignment
-----------------
https://testautomationpractice.blogspot.com/
1) provide some string search for it
2) count number of links
3) click on each link using for loop
4) get window ID's for every browser window
5) close specific browser window

*/

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//1) provide some string search for it

		String searchTerm ="Selenium";
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys(searchTerm);
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).submit();
		
		List<WebElement> searchResult = driver.findElements(By.xpath("//a[contains(@href,\"wikipedia\") and contains(@href,\"elenium\")]")); //get element with a tag and href attribute contains wikipedia and 'search term'
		
		//2) count number of links
		System.out.println("Total number of Links: " + searchResult.size());
		
		
		//3) click on each link using for loop
		for(WebElement a : searchResult) {
			//System.out.println(a.getAttribute("href").toString());
			a.click();
		}
		
		Set<String> winIDs = driver.getWindowHandles();
	
		//System.out.println(winIDs.toString());
		
		//5) close specific browser window
		for(String wID : winIDs) {
			
			String title = driver.switchTo().window(wID).getTitle();
			
			//close all the tabs which does not contains 'software' in the page title.
			if(!title.contains("software")) 
			{
				driver.close();	
			}
			
		}
		
		driver.quit();
		
	}

}
