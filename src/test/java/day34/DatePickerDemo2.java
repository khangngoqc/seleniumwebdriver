package day34;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {

	static Month convertMonth(String month) {
		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		monthMap.put("Jan", Month.JANUARY);
		monthMap.put("Feb", Month.FEBRUARY);
		monthMap.put("Mar", Month.MARCH);
		monthMap.put("Apr", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("Jun", Month.JUNE);
		monthMap.put("Jul", Month.JULY);
		monthMap.put("Aug", Month.AUGUST);
		monthMap.put("Sep", Month.SEPTEMBER);
		monthMap.put("Oct", Month.OCTOBER);
		monthMap.put("Nov", Month.NOVEMBER);
		monthMap.put("Dec", Month.DECEMBER);
		
		
		Month vmonth = monthMap.get(month);
		
		if(vmonth==null) {
			System.out.println("Invalid month...");
		}
		
		return vmonth;
		
	}
	
	
	
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		String requiredYear ="2022", requiredMonth = "Jun", requiredDate = "27";
		
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
		//select year
		WebElement yearDrpDown = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select selectYear = new Select(yearDrpDown);
		selectYear.selectByContainsVisibleText(requiredYear);
	
		//select month
		/*
		 * WebElement monthDrpDown =
		 * driver.findElement(By.xpath("//select[@aria-label='Select month']//"));
		 * Select selectMonth = new Select(monthDrpDown);
		 */
		
		/*String displayMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']//option[@selected = 'selected']")).getText();
		System.out.println(displayMonth);
		
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		displayMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']//option[@selected = 'selected']")).getText();
		System.out.println(displayMonth);*/
		
		
		  while(true) {
		  
		  String displayMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']//option[@selected = 'selected']")).getText();
		  System.out.println(displayMonth);
		  
		  //covert requiredMonth & displayMonth in to Month object 
		  Month expectedMonth = convertMonth(requiredMonth); 
		  Month currentMonth = convertMonth(displayMonth);
		  
		  //compare 
		  int result=expectedMonth.compareTo(currentMonth);
		  
		  //result 0 -> months equals //result >0 -> future month //result <0 -> past month
		  
		  if(result < 0) { //past month 
			  driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); } else
		  if(result > 0) { //future month 
			  driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); } else
		  { break; }

		  }
		  
		  List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		  
		  for(WebElement d : dates) {
			  if(d.getText().equals(requiredDate)) {
				  d.click();
			  }
		  }
		 
		
		
	}

}
