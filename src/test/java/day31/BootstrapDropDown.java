package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://codepen.io/WebIntricate/pen/Pxzpro");
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//button[contains(@class,'btn')]")).click();
		
		//1)select single option
		driver.findElement(By.xpath("//input[@value ='Option 2 ']")).click();
		
		
		//2) capture all the options and find out size
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu')]//label"));
		System.out.println("Number of options: " + options.size());
		
		//3) printing options form dropdown
		for(WebElement opt : options) {
			System.out.println(opt.getText());
		}
		
		//3) printing options form dropdown
		for(WebElement opt : options) 
		{
			if(opt.getText().equals("Option 3")) 
			{
				opt.click();	
			}
		}
		
	}

}
