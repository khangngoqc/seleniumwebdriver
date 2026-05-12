package day21;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

/*
 * test case
 * ---------
 * 1. Launch browser(Chrome)
 * 2. Open URL: https://valo-staging.netlify.app/
 * 3. Validate title should be "VALO Vietnam | Verified Vietnam Suppliers & Sourcing Platform"
 * 4. Close browser
 * */


public class FirstTestCase {

	public static void main(String[] args) {

		//1. Launch browser(chrome)
		//ChromeDriver driver = new ChromeDriver();
		//WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new EdgeDriver();
		WebDriver driver = new FirefoxDriver();
		
		
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
		//driver.close();
		driver.quit();
		
		
		
	}

}
