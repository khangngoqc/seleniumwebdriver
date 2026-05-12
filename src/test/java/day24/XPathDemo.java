package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	
		//Xpath with single attribute
		//driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("XPath with single attribute test");
		
		//Xpath with multiple attribute
		//driver.findElement(By.xpath("//*[@id=\"small-searchterms\"][@name='q']")).sendKeys("XPath with multiple attributes test");
		
		//Xpath with 'and' operators
		//driver.findElement(By.xpath("//*[@id=\"small-searchterms\" and @name='q']")).sendKeys("XPath with 'and' operator test");
		
		//Xpath with 'or' operators
		//driver.findElement(By.xpath("//*[@id='ThisIsAWrongID' or @name='q']")).sendKeys("XPath with 'or' operator test");
				
		//Xpath with inner text - text()
		//driver.findElement(By.xpath("//*[text() = 'Build your own computer']")).click();
		
		/*
		boolean displayStatus = driver.findElement(By.xpath("//h2[text() = 'Featured products']")).isDisplayed();
		System.out.println(displayStatus);
		
		String value =driver.findElement(By.xpath("//h2[text() = 'Featured products']")).getText();
		System.out.println(value);
		 */
		
		//Xpath with contain method
		//driver.findElement(By.xpath("//input[contains(@placeholder, 'earc')]")).sendKeys("Xpath with contains() methods test");
		
		//Xpath with starts-with() method
		//driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sear')]")).sendKeys("Xpath with starts-with() methods test");
			
		//chained xpath
		boolean imageStatus = driver.findElement(By.xpath("//div[@class = 'picture']/a/img")).isDisplayed();
		System.out.println(imageStatus);
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}

}

