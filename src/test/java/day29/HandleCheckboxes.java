package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//1)select specific checkbox
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		//2)select all the checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		 
		/*for(int i = 0; i<checkboxes.size();i++) 
		{
			checkboxes.get(i).click();
		}
		*/
		
		/*for(WebElement checkbox : checkboxes) {
			checkbox.click();
		}
		*/
		
		//3) Select last 3 checkboxes
		/*int nLast = 3;
		for(int i = checkboxes.size() - nLast;i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
			
		}
		*/
		
		//4) Select first 3 checkboxes
		/*int nFirst = 3;
		for(int i = 0;i < nFirst; i++) 
		{
			checkboxes.get(i).click();
			
		}
		*/
		
		//5)unselect checboxes if they are selected 
		for(int i = 0;i < 3; i++) 
		{
			checkboxes.get(i).click();
			
		}
		
		Thread.sleep(3000);
		
		for(int i = 0;i < checkboxes.size(); i++) 
		{
			if(checkboxes.get(i).isSelected()) 
			{
			checkboxes.get(i).click();
			}
		}
		
		
	}

}
