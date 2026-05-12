package day38;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {

	public static void main(String[] args) {

		ChromeOptions options= new ChromeOptions();
		options.setAcceptInsecureCerts(true); ///accept SSL certificates
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration .ofSeconds(10));
		driver.get("https://expired.badssl.com/");
		
		System.out.println("Page title: " +driver.getTitle()); 
		
	}

}
