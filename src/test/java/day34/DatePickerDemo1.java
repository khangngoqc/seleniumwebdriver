package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	static void selectFutureDate(WebDriver driver, String month, String year, String date) {
		while(true) 
		{
			String monthEle = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yearEle = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			
			if(yearEle.equals(year) && monthEle.equals(month)) {
				System.out.println(yearEle + " " + monthEle);
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

		}
		
		//store all date element in a List
		List <WebElement>dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
		
		//loop through all the dateList and select expected date
		for(WebElement d : dateList) {
			
			if(d.getText().equals(date)) {
				d.click();
			}
		}

	}
	
	static void selectPastDate(WebDriver driver, String month, String year, String date) {
		
		while(true) 
		{
			String monthEle = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yearEle = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			
			if(yearEle.equals(year) && monthEle.equals(month)) {
				System.out.println(yearEle + " " + monthEle);
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

		}
		
		//store all date element in a List
		List <WebElement>dateList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
		
		//loop through all the dateList and select expected date
		for(WebElement d : dateList) {
			
			if(d.getText().equals(date)) {
				d.click();
			}
		}

	}

	
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
		driver.get("https://jqueryui.com/datepicker/");	
		
		driver.switchTo().frame(0);
		
		//Method1: using Sendkeys
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("02/25/2026");
		
		//Method2: using datepicker
		String yearEx ="2028", monthEx = "May", dateEx = "16";
		
		//selectFutureDate(driver, monthEx, yearEx, dateEx);
		selectPastDate(driver, "June", "2001","27");
		
	}

}
