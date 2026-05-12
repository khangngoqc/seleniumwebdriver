package Day33;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Assignment
----------------
1. https://testautomationpractice.blogspot.com/
	a. Read data, select all the checkboxes on all page 
	b. Get total number of page dynamically

2. https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers
	Read Username and User Role in one for loop
*/


public class Assignment {
	
	 static void Ass1(){

			WebDriver driver = new ChromeDriver();
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		
			int pagesT = driver.findElements(By.xpath("//ul[@id='pagination']//li//a")).size();
			
			int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
			
			int cols = driver.findElements(By.xpath("//table[@id='productTable']//thead//th")).size();
			
			
			System.out.println("a. Read all data and select checkboxes: ");
			for(int p = 1; p <= pagesT; p++) 
			{
				driver.findElement(By.xpath("//ul[@id='pagination']//li["+p+"]//a")).click();
				
				for(int r = 1; r <= rows; r++) 
				{
					for(int c = 1; c <= cols; c++) 
					{
						if(c < cols) 
						{					
							String data = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td["+c+"]")).getText();
							System.out.print(data + "\t");
						}
						else 
						{
							driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td["+c+"]//input")).click();	
							boolean status = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td["+c+"]//input")).isSelected();	
							System.out.print("Checkbox: " +  status);
						}
						
					}
					System.out.println(); //linebreak each rows in the table
						
				}
				
			}
			
			System.out.println("\nb. Total number of pages: " + pagesT);
			
	}
	
	 static void Ass2() {
		 
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 //login
		 driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		 driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		 
		 driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
		 
		 int rows = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']")).size();
		 
		 for(int r = 1; r <= rows; r++) {
			 
			String dtUsername = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+r+"]//div[@role='cell'][2]//div")).getText();
			String dtUserRole = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+r+"]//div[@role='cell'][3]//div")).getText();
			 
			System.out.println(dtUsername + "\t" + dtUserRole);
			
		 }
		 
	 }

	public static void main(String[] args) {

		//Ass1();
		Ass2();
		
	}

}
