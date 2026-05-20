package TipsAndTrick;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateOptionsInListBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement listboxElement = driver.findElement(By.xpath("//select[@id='colors']"));

		Select listbox = new Select(listboxElement);

		Set<String> uniqueOptions = new HashSet<String>();

		boolean flag = false;

		for (WebElement options : listbox.getOptions()) {
			String optionText = options.getText();

			if (!uniqueOptions.add(optionText)) // add() method return boolean value
			{
				System.out.println("Duplicate option found! " + optionText);
				flag = true;
			}
		}

		if (!flag) {
			System.out.println("No duplicate found in the list box...");
		}

		driver.close();

	}

}
