package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DisableAutomatedMessageOnScreen {

	public static void main(String[] args) {
		
		ChromeOptions options =  new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		//WebDriver driver = new EdgeDriver();
		WebDriver driver = new ChromeDriver(options);
	
		
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
