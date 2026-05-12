package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://testautomationpractice.blogspot.com/";
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		System.out.println("Window ID on first page: "+	driver.getWindowHandle());	
		
		Thread.sleep(3000);
		
		
		//Elements
		WebElement guiTitle = driver.findElement(By.xpath("//a[normalize-space()='GUI Elements']")); 
		
		//click on title -> get current url
		guiTitle.click();// direct to another form
		System.out.println(driver.getCurrentUrl());
		System.out.println("Window ID on second page: "+	driver.getWindowHandle());	
		
		
		//Elements on new form
		WebElement name_input = driver.findElement(By.xpath("//input[@id='name']"));
		WebElement email_input = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement phone_input = driver.findElement(By.xpath("//input[@id='phone']"));
		WebElement Add_input = driver.findElement(By.xpath("//textarea[@id='textarea']"));
		
		
		System.out.println("Check for fields enable status:  ");
		
		if(name_input.isEnabled() == true) 
		{
			name_input.sendKeys("NameInputCheck");
		}
		else 
		{
			System.out.println("Name field is disabled!");
		}
		
		if(email_input.isEnabled() == true) 
		{
			email_input.sendKeys("EmailInputCheck");
		}
		else 
		{
			System.out.println("Email field is disabled!");
		}
		
		if(phone_input.isEnabled() == true) 
		{
			phone_input.sendKeys("0123-456-789");
		}
		else 
		{
			System.out.println("Phone field is disabled!");
		}
		
		if(Add_input.isEnabled() == true) 
		{
			Add_input.sendKeys("AddressInputCheck");
		}
		else 
		{
			System.out.println("Address field is disabled!");
		}
		
		
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
