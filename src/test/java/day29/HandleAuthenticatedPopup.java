package day29;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAuthenticatedPopup {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	}

}
