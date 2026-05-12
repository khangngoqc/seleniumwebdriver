package day31;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*

Assignment
--------------------------
1) Handle country dropdown with/without using Select class:
https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/
a) count total number of options
b) print all the options
c) select one option

2) Hidden dropdown
Login to OrangeHRM--> pim--> employee status

3) https://testautomationpractice.blogspot.com/
colors mult select box
*/


public class Assignment {
	
	public static char getRandomVowel() {
        // Define an array of vowels
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        // Create a Random object
        Random random = new Random();

        // Generate a random index between 0 and the length of the vowels array minus 1
        int randomIndex = random.nextInt(vowels.length); // nextInt(5) generates 0-4

        // Return the character at the generated random index
        return vowels[randomIndex];
    }
	
	static void Ass1() {
		Random rand = new Random();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//1) with Select class
		WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id='country-list']"));
		
		/*
		Select drpCountry = new Select(drpCountryEle);
		
		List<WebElement> options = drpCountry.getOptions();
		
		System.out.println("Total number of options: " + options.size());
		
		System.out.println("\nList of options: ");
		
		for(WebElement opt :options) {
			System.out.println("- " + opt.getText());
		}
		
		drpCountry.selectByIndex(rand.nextInt(0,options.size()));
		*/
		
		//1) without Select class
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='country-list']//option"));
		System.out.println("Total number of options: " + options.size());
		
		System.out.println("\nList of options: ");
		
		for(WebElement opt :options) {
			System.out.println("- " + opt.getText());
		}
		
		options.get(rand.nextInt(0,options.size())).click();
		
		driver.close();
		
	}

	static void Ass2() {
		Random rand = new Random();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Orange HRM login
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']")).click();
		
		//navigate to PIM
		driver.findElement(By.xpath("//a[normalize-space()='PIM']")).click();
		
		//open Emplpoyee status list
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
		
		//find options element
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']//span"));
		
		//Total number of options
		System.out.println("Total of Employment status options: "+ options.size());
		
		
		//Detail of options
		System.out.println("\nList of options: ");
		for(WebElement opt:options) {
			System.out.println("- "+ opt.getText());
		}
		
		//Select a random option
		options.get(rand.nextInt(0, options.size())).click();
		
	}
	
	static void Ass3() {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement drpColorsEle = driver.findElement(By.xpath("//select[@id='colors']"));
		
		Select drpColors = new Select(drpColorsEle);
		
		List<WebElement> options = drpColors.getOptions();
		
		System.out.println("Total number of options: " + options.size());
		
		String randChar = String.valueOf(getRandomVowel());
			
		System.out.println("Random vowel: " + randChar);
				
		for(WebElement opt:options) {
			System.out.println("- " + opt.getText());
			
			if(opt.getText().contains(randChar) == true) 
			{
				opt.click();
			}
		
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		
		//Assignment 1
		//Ass1();
		
		//Assignment 2
		//Ass2();
		
		//Assignment 3
		Ass3();
		
		
		
				
			
		
	}

}
