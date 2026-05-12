package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement drpCountryEle = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select drpCountry = new Select(drpCountryEle);
		
		//select option from the dropdown
		//drpCountry.selectByVisibleText("Canada");
		//drpCountry.selectByValue("canada");
		drpCountry.selectByIndex(1); //0 based from top to bottom of the list or <option> tag with index attribute
		
		
		//capture the options from the dropdown
		List<WebElement> options = drpCountry.getOptions();
		
		System.out.println("Total number of option in the Country dropdown: "+ options.size());
		
		//printing the options
		/*for(int i = 0; i < options.size(); i++) 
		{
			System.out.println(options.get(i).getText());
		}
		*/
		
		
		//printing the options (enhanced for loop)
		for(WebElement opt : options) {
			System.out.println(opt.getText());
		}
		
	}

}
