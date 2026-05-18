package TipsAndTrick;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortedDropdownList {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//sorted List
		//Select animalsDrp = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		
		Select coloursDrp = new Select(driver.findElement(By.xpath("//select[@id='colors']")));
		
		ArrayList originalList =  new ArrayList();
		ArrayList tempList =  new ArrayList();
		
		List<WebElement> options = coloursDrp.getOptions();
	
		for(WebElement opt : options) {
			originalList.add(opt.getText());
			tempList.add(opt.getText());
			
		}
		
		System.out.println("Before sorting ...");
		System.out.println("Orginal List: " + originalList);
		System.out.println("Temp List: " + tempList);
		
		Collections.sort(tempList); //sorted tempList
		System.out.println("\nAfter sorting ...");
		System.out.println("Orginal List: " + originalList);
		System.out.println("Temp List: " + tempList);
		
		if(originalList.equals(tempList)){
			System.out.println("\nList box is sorted");
		}
		else
		{
			System.out.println("\nList box is not sorted");
		}
		
	}

}
