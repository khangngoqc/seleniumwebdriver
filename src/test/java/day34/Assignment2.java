package day34;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Datepicker - Assignment 2:  2) https://www.dummyticket.com/dummy-ticket-for-visa-application/

public class Assignment2 {

	public static int generateRandomDayOfMonth(int year, int month) {
		// YearMonth class handles the number of days in a month, including leap years.
		YearMonth yearMonth = YearMonth.of(year, month);
		int daysInMonth = yearMonth.lengthOfMonth();

		// Generate a random number between 1 (inclusive) and daysInMonth (inclusive)
		// ThreadLocalRandom is an efficient way to get a random number in concurrent
		// environments.
		// nextInt(min, max) generates a number between min (inclusive) and max
		// (exclusive),
		// so we use (1, daysInMonth + 1).
		return ThreadLocalRandom.current().nextInt(1, daysInMonth + 1);
	}

	static void selectRandomDate(WebDriver driver, WebElement e) {
		e.click();

		Random rand = new Random();

		// Random DoB
		int randYear = rand.nextInt(1926, 2027);
		int randMonth = rand.nextInt(1, 13);
		int randDate = generateRandomDayOfMonth(randYear, randMonth);

		String randYearS = Integer.toString(randYear);
		String randMonthS = Integer.toString(randMonth);
		String randDateS = Integer.toString(randDate);

		Select monthSelect = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		monthSelect.selectByContainsVisibleText(convertMonth(randMonthS));

		Select yearSelect = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		yearSelect.selectByContainsVisibleText(randYearS);

		List<WebElement> datesCal = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));

		for (WebElement d : datesCal) {
			if (d.getText().equals(randDateS)) {
				d.click();
			}
		}

	}

	static String selectTripType(WebDriver driver) throws InterruptedException {
		List<WebElement> tripTypeRadios = driver.findElements(By.xpath("//input[@name='traveltype']"));
		try {
			selectRandomRadioButtons(driver, tripTypeRadios);
		} catch (ElementClickInterceptedException ex) {
			System.out.println("ElementClickInterceptedException catched. Try again...");
			Thread.sleep(5000);
			selectRandomRadioButtons(driver, tripTypeRadios);
		}

		if (tripTypeRadios.get(0).isSelected() == true) {
			return "One way";
		} else {
			return "Round trip";
		}
	}

	static String convertMonth(String month) {
		HashMap<String, String> monthMap = new HashMap<String, String>();

		monthMap.put("1", "Jan");
		monthMap.put("2", "Feb");
		monthMap.put("3", "Mar");
		monthMap.put("4", "Apr");
		monthMap.put("5", "May");
		monthMap.put("6", "Jun");
		monthMap.put("7", "Jul");
		monthMap.put("8", "Aug");
		monthMap.put("9", "Sep");
		monthMap.put("10", "Oct");
		monthMap.put("11", "Nov");
		monthMap.put("12", "Dec");

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

	static void selectDepartureDate(WebDriver driver) {

		driver.findElement(By.xpath("//input[@id='departon']")).click();

		int[] randomDate = generateRandomDate();

		String randYearS = Integer.toString(randomDate[2]);
		String randMonthS = Integer.toString(randomDate[1]);
		String randDateS = Integer.toString(randomDate[0]);

		System.out.println("Random departure date: " + randDateS + " " + randMonthS + " " + randYearS);

		Select yearSelect = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		yearSelect.selectByContainsVisibleText(randYearS);

		Select monthSelect = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		monthSelect.selectByContainsVisibleText(convertMonth(randMonthS));

		List<WebElement> datesCal = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));

		for (WebElement d : datesCal) {
			if (d.getText().equals(randDateS)) {
				d.click();
			}
		}

	}

	static void selectReturnDate(WebDriver driver) {

		driver.findElement(By.xpath("//input[@id='returndate']")).click();

		int[] randomDate = generateRandomDate();

		String randYearS = Integer.toString(randomDate[2]);
		String randMonthS = Integer.toString(randomDate[1]);
		String randDateS = Integer.toString(randomDate[0]);

		System.out.println("Random return date: " + randDateS + " " + randMonthS + " " + randYearS);

		Select yearSelect = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		yearSelect.selectByContainsVisibleText(randYearS);

		Select monthSelect = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		monthSelect.selectByContainsVisibleText(convertMonth(randMonthS));

		List<WebElement> datesCal = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));

		for (WebElement d : datesCal) {
			if (d.getText().equals(randDateS)) {
				d.click();
			}
		}

	}

	public static int[] generateRandomDate() {
		// Get today's date
		LocalDate today = LocalDate.now();
		// Define the end date, one year from today
		LocalDate endDate = today.plus(1, ChronoUnit.YEARS);

		// Generate a random date between today and one year from now
		Random random = new Random();
		long daysBetween = ChronoUnit.DAYS.between(today, endDate);
		long randomDays = random.nextInt((int) daysBetween + 1);
		LocalDate randomDate = today.plusDays(randomDays);

		// Get day, month, and year as integers
		int day = randomDate.getDayOfMonth();
		int month = randomDate.getMonthValue();
		int year = randomDate.getYear();

		// Return the date as an array: {day, month, year}
		return new int[] { day, month, year };
	}

	static String selectPurpose(WebDriver driver, WebElement e) {
		selectRandomOptionFromDropdown(driver, e);

		Select purpose = new Select(e);

		return purpose.getFirstSelectedOption().getText();
	}

	static void selectRandomRadioButtons(WebDriver driver, List<WebElement> radios) throws InterruptedException {
		System.out.println();
		Random rand = new Random();
		int randNum = 0;
		try {
			randNum = rand.nextInt(0, radios.size());
		} catch (IllegalArgumentException ex) {
			System.out.println("unable to find raido button elements");
  		} 

		///int randNum = rand.nextInt(0, radios.size());
		System.out.println("Number of " + radios.get(randNum).getAttribute("name") + " options: " + radios.size());
		System.out.println("randomRadioButtonNumber: " + randNum);
		
		try {
			radios.get(randNum).click();
		}catch (ElementClickInterceptedException ex) {
			System.out.println("ElementClickInterceptedException catched. Try again...");
			Thread.sleep(5000);
			
			selectRandomRadioButtons(driver, radios);
		}
	}

	static void selectRandomOptionFromDropdown(WebDriver driver, WebElement e) {
		System.out.println();
		Select dropDown = new Select(e);
		Random rand = new Random();
		int randNum = rand.nextInt(0, dropDown.getOptions().size());
		System.out.println("Random number for " + e.getAttribute("name") + " selection: " + randNum);
		try {
			dropDown.selectByIndex(randNum);
		} catch (IllegalArgumentException ex) {
			System.out.println("invalid" + e.getAttribute("name") + "selected");
			dropDown.selectByIndex(randNum + 1);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");

		//Select ticket option
		Thread.sleep(3000);
		List<WebElement> ticketOptionsEles = driver
				.findElements(By.xpath("//li//label[@class='opc-radio-list-label']//input"));
		selectRandomRadioButtons(driver, ticketOptionsEles);

		Thread.sleep(3000);

		// Passenger details
		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("First name");
		driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("Last name");

		// driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		// driver.findElement(By.xpath("//select[@aria-label='Select year']"));

		// String year = "2001", month = "June", date = "27";

		// Select Dob
		WebElement dobEle = driver.findElement(By.xpath("//input[@id='dob']"));
		selectRandomDate(driver, dobEle);

		List<WebElement> sexRadioEles = driver
				.findElements(By.xpath("//input[@class='input-radio thwcfe-input-field' and @name='sex']"));
		selectRandomRadioButtons(driver, sexRadioEles);

		System.out.println();

		Random rand = new Random();
		int randNum3 = rand.nextInt(0, 3);
		System.out.println("Random number for addtional passengers: " + randNum3);
		if (randNum3 > 0) {
			System.out.println("Random number: " + randNum3 + " > Add more passengers selected");
			driver.findElement(By.xpath("//input[@id='addmorepax']")).click();
			WebElement addPassengerDropdownEle = driver.findElement(By.xpath("//select[@id='addpaxno']"));
			Select addPassSelect = new Select(addPassengerDropdownEle);
			addPassSelect.selectByIndex(randNum3);

			for (int i = 1; i <= randNum3; i++) {
				System.out.println();

				int n = i + 1;
				driver.findElement(By.xpath("//input[contains(@id,'travname') and contains(@id,'" + n + "')]"))
						.sendKeys("First name " + n);
				driver.findElement(By.xpath("//input[contains(@id,'travlastname') and contains(@id,'" + n + "')]"))
						.sendKeys("Last name " + n);

				// Select additional passenger dob
				WebElement addPassengerDob = driver
						.findElement(By.xpath("//input[contains(@id,'dob') and contains(@id," + n + ")]"));
				selectRandomDate(driver, addPassengerDob);

				// Select additional passenger's sex
				List<WebElement> addPassengerSexRadiosEles = driver.findElements(By.xpath(
						"//input[@class='input-radio thwcfe-input-field' and contains(@name, 'sex') and contains(@name, "
								+ n + ")]"));
				selectRandomRadioButtons(driver, addPassengerSexRadiosEles);

				// Select additional Passenger type
				WebElement passengerTypeEle = driver
						.findElement(By.xpath("//select[contains(@id,'paxtype') and contains(@id, " + n + ")]"));
				selectRandomOptionFromDropdown(driver, passengerTypeEle);

			}
		} else {
			System.out.println("None additional passenger added");
		}

		// Travel Detail
		String selectedTripType = selectTripType(driver);

		// From/To City
		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Ho Chi Minh");
		driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys("Tokyo");

		// Departure date + return date
		if (selectedTripType.equals("Round trip")) {
			selectDepartureDate(driver);
			selectReturnDate(driver);

		} else {
			selectDepartureDate(driver);
		}
		
		
		//input Order Notes
		driver.findElement(By.xpath("//textarea[@id='notes']")).sendKeys("Additional information (optional)");

		// Purpose of dummy ticket (optional)
		System.out.println();
		WebElement purposeDropdownEle = driver.findElement(By.xpath("//select[@id='reasondummy']"));
		String purpose = selectPurpose(driver, purposeDropdownEle);
		System.out.println("Selected purpose: " + purpose);
		if (purpose.equals("Visa application")) {
			WebElement appDateEle = driver.findElement(By.xpath("//input[@id='appoinmentdate']"));
			selectRandomDate(driver, appDateEle);
		} else if (purpose.equals("Proof of return at the airport")) {
			WebElement proofDateEle = driver.findElement(By.xpath("//input[@id='proofdate']"));
			selectRandomDate(driver, proofDateEle);
			WebElement airlineEle = driver.findElement(By.xpath("//input[@id='airline']"));
			airlineEle.clear();
			airlineEle.sendKeys("Random Airline");
		}

		// receive ticket option (radio buttons)
		List<WebElement> deliveryMethodRadioEles = driver
				.findElements(By.xpath("//input[contains(@id,'deliverymethod')]"));
		selectRandomRadioButtons(driver, deliveryMethodRadioEles);

		// Billing Details
		driver.findElement(By.xpath("//input[@id='billname']")).sendKeys("Random billing name");
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("0123456789");
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("random@email.com");

		// Country dropdown select
		WebElement countryDropdownEle = driver.findElement(By.xpath("//select[@id='billing_country']"));
		selectRandomOptionFromDropdown(driver, countryDropdownEle);

		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("Random billing address 1");
		driver.findElement(By.xpath("//input[@id='billing_address_2']")).sendKeys("Random billing address 2");
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Random billing city");

		WebElement billingStateEle = driver.findElement(By.id("billing_state"));

		System.out.println("Billing state tagname: " + billingStateEle.getTagName());

		if (billingStateEle.getTagName().equals("input") && billingStateEle.isDisplayed() == true) {
			billingStateEle.sendKeys("Random billing state");
		} else if (billingStateEle.getTagName().equals("select") && billingStateEle.isDisplayed() == true) {
			selectRandomOptionFromDropdown(driver, billingStateEle);
		}

		WebElement postCodeEle = driver.findElement(By.id("billing_postcode"));
		if (postCodeEle.isDisplayed() == true) {
			postCodeEle.sendKeys("RANDOMPOSTCODE");
		}

		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//textarea[@id='order_comments']")).sendKeys("Random Order Notes");


		// Select payment method
		List<WebElement> paymentEles = driver.findElements(By.xpath("//input[@name='payment_method']"));
		selectRandomRadioButtons(driver, paymentEles);
		if(paymentEles.get(0).isSelected()) {
			//switch to the stripe payment iframe and input card information
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//input[@id='payment-numberInput']")).sendKeys("4242 4242 4242 4242");
			driver.findElement(By.xpath("//input[@id='payment-expiryInput']")).sendKeys("0727");
			driver.findElement(By.xpath("//input[@id='payment-cvcInput']")).sendKeys("223");

			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//button[@id='place_order']")).click();
		}
		else 
		{
			driver.findElement(By.xpath("//button[@id='place_order']")).click();
		}

		Thread.sleep(5000);

		//driver.close();

		// continue payment
	}

}
