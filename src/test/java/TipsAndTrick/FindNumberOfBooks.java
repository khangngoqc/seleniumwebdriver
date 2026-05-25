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

public class FindNumberOfBooks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.booksbykilo.in/new-books");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Actions act = new Actions(driver);

		/*
		 * Failed with dynamic content page
		 * 
		 * List<WebElement> books =
		 * driver.findElements(By.xpath("//div[@id=\"productsDiv\"]//h3"));
		 * System.out.println("Number of Books: " + books.size());
		 */

		/*
		 * Failed with constant loading elements
		 * 
		 * js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		 */

		int previousCount = 0;
		int currentCount = 0;

		while (true) {
			List<WebElement> books = driver.findElements(By.xpath("//div[@id=\"productsDiv\"]//h3"));
			currentCount = books.size();

			if (currentCount == previousCount) {
				break;
			}
			else 
			{
				
				previousCount = currentCount;
			}
			
			
			//js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			
			act.sendKeys(Keys.END).perform();
			
			Thread.sleep(2000);

		}

		System.out.println("Total number of books: " + previousCount);
		
		driver.quit();
		
	}

}
