package TipsAndTrick;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAJAXCalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
		driver.findElement(By.xpath("(//button[normalize-space()='Load AJAX Content'])[1]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='AJAX Content Loaded']")));
		
		WebElement loadedElement =  driver.findElement(By.xpath("//h2[normalize-space()='AJAX Content Loaded']"));

		System.out.println(loadedElement.getText());
	}

}
