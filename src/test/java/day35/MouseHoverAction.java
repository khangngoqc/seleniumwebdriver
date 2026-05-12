package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://valo-staging.netlify.app/");
		
		driver.manage().window().maximize();
		
		WebElement allCategoriesBtn = driver.findElement(By.xpath("//button[normalize-space()='All Categories']"));
		WebElement agrCateBtn = driver.findElement(By.xpath("//span[normalize-space()='Agriculture']"));
		WebElement conCateBtn = driver.findElement(By.xpath("//span[normalize-space()='Consumer goods']"));

		Actions act = new Actions(driver);
		//Mouse hover
		//act.moveToElement(allCategoriesBtn).moveToElement(conCateBtn).click().build().perform();
		act.moveToElement(allCategoriesBtn).moveToElement(conCateBtn).click().perform();
		
		
		
		
	}

}
