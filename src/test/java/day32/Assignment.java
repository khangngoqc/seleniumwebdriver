package day32;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * 
 Assignment
1) https://blazedemo.com/
 */

public class Assignment {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		WebDriver driver = new ChromeDriver();
		driver.get(" https://blazedemo.com/");
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		WebElement drpFromPortEle = driver.findElement(By.xpath("//select[@name='fromPort']"));
		WebElement drpToPortEle = driver.findElement(By.xpath("//select[@name='toPort']"));
		
		Select drpFromPort = new Select(drpFromPortEle);
		Select drpToPort = new Select(drpToPortEle);
		
		List<WebElement> optFromPort = drpFromPort.getOptions();
		List<WebElement> optToPort = drpToPort.getOptions();
		
		//random from and to port selection
		drpFromPort.selectByIndex(rand.nextInt(0,optFromPort.size()));
		drpToPort.selectByIndex(rand.nextInt(0,optToPort.size()));
		
		//click the Find Flights button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//find the total number of rows(with data) and columns
		int rows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		int cols = driver.findElements(By.xpath("//table[@class='table']//thead//th")).size();
		
		ArrayList priceList = new ArrayList();
		
		for(int c = 1 ; c <= cols; c++) 
		{
			
			String heading = driver.findElement(By.xpath("//table[@class='table']//th["+c+"]")).getText();  
			
			if(heading.equals("Price")) 
			{			
				for(int r = 1; r <= rows ; r++) 
				{
					String price = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td["+c+"]")).getText();
					priceList.add(price);
				
				}
			}
		}
		
		System.out.println(priceList.toString());
		priceList.sort(null);
		System.out.println(priceList.toString());
		
		//Select the lowest price
		String lowestPrice = (String) priceList.getFirst();	
		
		
		for(int c = 1 ; c <= cols; c++) 
		{
			
			String heading = driver.findElement(By.xpath("//table[@class='table']//th["+c+"]")).getText();  
			//find the Price column again
			if(heading.equals("Price")) 
			{			
				for(int r = 1; r <= rows ; r++) //go through all the price 
				{
					String price = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td["+c+"]")).getText();
					if(price.equals(lowestPrice)) //get the lowest price row
					{
						System.out.println("LowestPrice found: " + price);
						//find the button in the row of the lowest Price and click
						driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//input[@type='submit']")).click();
						break;
					}
					
				}
			}
		}
		
		
		//filling info form
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("John Doe"); //Name
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("12 Wall Street");	//Address
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Texas");	//City
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Random State");	//State
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("123-123-123");	//Card Typoe
		
		
		WebElement drpCardType = driver.findElement(By.xpath("//select[@id='cardType']"));
		Select cardType = new Select(drpCardType);
		List<WebElement> optCardType = cardType.getOptions();
		cardType.selectByIndex(rand.nextInt(0, rand.nextInt(0,optCardType.size()))); //select a random card type
		
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("456-456-456");	//Credit Card Number
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("2"); //Month
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2026");	//Year
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("John Doe");	//Name on card
		driver.findElement(By.xpath("//label[normalize-space()='Remember me']")).click(); //click the Remember me checkbox

		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click(); //click the Purchase Flight button
		
		boolean msgStatus = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).isDisplayed();
		if (msgStatus == true) {
			System.out.println("Test Case Passed");
		}
		
		
		
		
		
		 
		
		 
		

	}

}
