package day36;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//Selenium 4.x
		driver.switchTo().newWindow(WindowType.TAB); //opens in a new tab
		driver.switchTo().newWindow(WindowType.WINDOW); //opens in a new tab
		
		driver.get("https://www.jqueryscript.net/");
		
	}

}
