package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		//id
		//driver.findElement(By.id("name")).sendKeys("Mac");
		
		
		//className
		//boolean logoDisplayStatus = driver.findElement(By.className("wikipedia-icon")).isDisplayed();
		//System.out.println(logoDisplayStatus);
		
		//linkText & partialLinkText
		//driver.findElement(By.linkText("Udemy Courses")).click();
		//driver.findElement(By.partialLinkText("Udemy")).click();
		
		//className
		List <WebElement> sideLinks = driver.findElements(By.className("link"));
		System.out.println(sideLinks.size()); 
		
		//tagname
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total number of links: " + links.size());
		
		List <WebElement> imgs = driver.findElements(By.tagName("img"));
		System.out.println("total number of images: " + imgs.size());
		
	}

}
