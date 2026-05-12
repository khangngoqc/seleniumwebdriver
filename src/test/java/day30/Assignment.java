package day30;
/*
 Assignment
 ---------------------------------
https://ui.vision/demo/webtest/frames/
1) switch to 5th frame
2) click on link -opens new iframe
3) switch to inner frame
4) check logo presence in the inner frame.
 
*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		String url ="https://ui.vision/demo/webtest/frames/\r\n";
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		
		driver.findElement(By.cssSelector("a[href='https://a9t9.com']")).click();
		
		
		System.out.println(driver.getCurrentUrl());
		
		boolean logoSt = driver.findElement(By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation']")).isDisplayed();
		
		  if(logoSt = true) 
		  {	 
			  System.out.println("The logo is displayed"); 
		  }
		  else
		  {	
			  System.out.println(driver.getCurrentUrl()); 
		  }
		 
		
		Thread.sleep(5000);
		
		//driver.close();
		
		
	}

}
