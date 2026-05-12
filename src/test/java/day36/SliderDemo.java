package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		 Thread.sleep(2000);
		Actions act = new Actions(driver);
		
		//Min slider
		WebElement min_slider = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
		
		System.out.println("Location of emin slider before moving: " + min_slider.getLocation()); //(59, 250) - x,y
		act.dragAndDropBy(min_slider, 100, 249).perform();
		System.out.println("Location of emin slider after moving: " + min_slider.getLocation()); //(159, 250) - x,y
		
		//Max slider
		WebElement max_slider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2] "));

		System.out.println("Location of emax slider before moving: " + max_slider.getLocation()); //(468, 29) - x,y
		act.dragAndDropBy(max_slider, -100 , 249).perform();
		System.out.println("Location of emax slider after moving: " + max_slider.getLocation()); //(59, 250) - x,y

	}

}
