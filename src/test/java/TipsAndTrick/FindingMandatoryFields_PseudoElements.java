package TipsAndTrick;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingMandatoryFields_PseudoElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> elements = driver.findElements(By.xpath("//form//label"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement e : elements) {
			String script = "return window.getComputedStyle(arguments[0], '::before')";
			String content = js.executeScript(script, e).toString();

			if (content.contains("*")) {
				System.out.println(e.getText() + " Mandatory field");
			} else {
				System.out.println(e.getText() + " Not mandatory field");
			}
			//System.out.println(content);

		}
		
		driver.quit();

	}

}
