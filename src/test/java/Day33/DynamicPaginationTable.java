package Day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo3x.opencartreports.com/admin/");
		
		//Thread.sleep(10000);
		
		WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse4']//a[contains(text(),'Orders')]")).click();
		
		//Showing 21 to 25 of 25 (2 Pages)
		String pageText = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		int totalPage = Integer.parseInt(pageText.substring(pageText.indexOf("(")+1, pageText.indexOf("Pages")-1));
		System.out.println(totalPage);
		
		//repeating pages
		for(int p = 1; p <= totalPage; p++) 
		{
			if(p > 1)
			{
				WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//a[contains(text(),'"+p+"')]"));
				activePage.click();	
			}
			
			//reading data from each page
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			
			for(int r = 1; r<= rows; r++) {
				String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
				String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();
				String orderPrice = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();			

				System.out.println(customerName + "\t" + status + "\t" + orderPrice);

			}
		}
		
	}

}
