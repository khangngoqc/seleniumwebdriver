package TipsAndTrick;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FindABookInAScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.booksbykilo.in/new-books");
		
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Anastasia
		String bookTitle = "My Happy Book";
		
		//Actions class - failed
		/*
		 *  act.scrollToElement(book);
		 */
		
		//JavaScriptExecutor - failed
		/*
		 * 
		 * js.executeScript("arguments[0].scrollIntoView", book);
		 */
		
		boolean found = false;
		
		while (!found) 
		{

			List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
			
			for(WebElement book : books) {
				if(book.getText().equals(bookTitle))
				{
					System.out.println("Book Found!");
					found = true;
					break;
				}
				
			}
			
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			//act.sendKeys(Keys.END).perform();
			Thread.sleep(2000);
			
		}
		
		driver.quit();
		
	}
}
