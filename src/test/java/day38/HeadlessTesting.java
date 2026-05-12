package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class HeadlessTesting {

	public static void main(String[] args) {
		
		FirefoxOptions options =  new FirefoxOptions();
		options.addArguments("--headless=new"); //setting for headless mode of execution
		
		//WebDriver driver = new EdgeDriver();
		WebDriver driver = new FirefoxDriver(options);
	
		
		//2. Open URL: https://demo.opencart.com/
		driver.get("https://valo-staging.netlify.app/");
		
		//3. Validate title should be "VALO Vietnam | Verified Vietnam Suppliers & Sourcing Platform"
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals("VALO Vietnam | Verified Vietnam Suppliers & Sourcing Platform")) 
		{
			System.out.println("Test Passed");
		}else{
			System.out.println("Test Failed");
		}
		
		//4. Close browser
		driver.quit();
		
		
		
	}

}
