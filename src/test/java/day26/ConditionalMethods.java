package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//isDisplayed();
		
		//WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		//System.out.println("Logo's display status: " + logo.isDisplayed());
		
		boolean logoDisplayStatus= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("Logo's display status: " + logoDisplayStatus);
		
		//isEnabled();
		boolean firstNameStatus  = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("First name field enable status: "+ firstNameStatus);
		
		//idSelected();
		WebElement male_rd =  driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd =  driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before selected....");
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		System.out.println("After male selected....");
		male_rd.click();
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		System.out.println("After female selected....");
		female_rd.click();
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		boolean newsletterStatus = driver.findElement(By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive']")).isSelected();
		System.out.println("Newsletter status: " + newsletterStatus);
	
		
		
	}

}
