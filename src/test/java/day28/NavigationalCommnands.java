package day28;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommnands {

	public static void main(String[] args) throws MalformedURLException {
		
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	//accept URL only in the string format

		
		//URL myUrl = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.navigate().to(myUrl);
		
		driver.navigate().to("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl()); //https://money.rediff.com/gainers/bse/daily/groupa
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl()); //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		
		driver.navigate().refresh();
		
		
	}

}
