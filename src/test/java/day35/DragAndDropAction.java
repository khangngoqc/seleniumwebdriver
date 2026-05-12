package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/dragdrop/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement dragEle = driver.findElement(By.xpath("//a[@id='two']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='bin']"));
		
		act.dragAndDrop(dragEle, targetElement).perform();
		
		
		
	}

}
