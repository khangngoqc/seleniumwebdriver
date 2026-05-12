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

/*
 Assignment
 ----------------------------
1) Auto suggestions & Date pickers
https://dummy-tickets.com/buyticket
 */
public class Assignment {

	static void selectDepartureLocation(WebDriver driver, String fromLocation) throws InterruptedException {
		// Select departure location
		WebElement fromInput = driver.findElement(By.xpath("//input[@name='source[]'][1]"));
		fromInput.sendKeys(fromLocation);

		Thread.sleep(3000);

		List<WebElement> fromOptions = driver
				.findElements(By.xpath("//ul[@class='suggestions-list']//li//div[@class='city']"));

		for (WebElement op : fromOptions) {
			System.out.println(op.getText());
			if (op.getText().equals(fromLocation)) {
				op.click();
			}
		}
	}

	static void selectDestinationLocation(WebDriver driver, String toLocation) throws InterruptedException {
		// Select destination location
		WebElement toInput = driver.findElement(By.xpath("//input[@name='destination[]'][1]"));
		toInput.sendKeys(toLocation);

		Thread.sleep(3000);

		List<WebElement> toOptions = driver
				.findElements(By.xpath("//ul[@class='suggestions-list']//li//div[@class='city']"));

		for (WebElement op : toOptions) {
			System.out.println(op.getText());
			if (op.getText().equals(toLocation)) {
				op.click();
			}
		}

	}

	static void selectDepartureDate(WebDriver driver, String date, String month, String year) {
		// Select Departure Date
		driver.findElement(By.xpath("//input[@placeholder='Departure Date']")).click();

		WebElement monthDrpEle = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select monthDrp = new Select(monthDrpEle);
		monthDrp.selectByContainsVisibleText(convertMonth(month));

		WebElement yearDrpEle = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select yearDrp = new Select(yearDrpEle);
		yearDrp.selectByContainsVisibleText(year);

		List<WebElement> dateList = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td/a"));

		for (WebElement d : dateList) {
			if (d.getText().equals(date)) {
				d.click();
			}
		}
	}

	static String convertMonth(String month) {
		HashMap<String, String> monthMap = new HashMap<String, String>();

		monthMap.put("January", "Jan");
		monthMap.put("February", "Feb");
		monthMap.put("March", "Mar");
		monthMap.put("April", "Apr");
		monthMap.put("May", "May");
		monthMap.put("June", "Jun");
		monthMap.put("July", "Jul");
		monthMap.put("August", "Aug");
		monthMap.put("September", "Sep");
		monthMap.put("October", "Oct");
		monthMap.put("November", "Nov");
		monthMap.put("December", "Dec");

		String vmonth = monthMap.get(month);

		if (vmonth == null) {
			System.out.println("Invalid month...");
		}

		return vmonth;

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://dummy-tickets.com/buyticket");

		String fromLocation = "Vietnam", toLocation = "Japan";
		String date = "27", month = "June", year = "2027";

		selectDepartureLocation(driver, fromLocation);
		selectDestinationLocation(driver, toLocation);
		selectDepartureDate(driver, date, month, year);
		
		driver.findElement(By.xpath("//input[@id='flight_oneway_btn']")).click();



	}

}
