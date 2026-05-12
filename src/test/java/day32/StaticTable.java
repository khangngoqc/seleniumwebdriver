package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//1) find total number of row in a table
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		//int rows = driver.findElements(By.tagName("tr")).size(); //only use if there is only 1 table in the page
	
		System.out.println("Total rows in the table:  "+rows);
	
		
		//2) find total number of columns
		System.out.println();
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Total columns in the table:  "+cols);
		
		
		//3) Read data from specific row and column 
		System.out.println();
		String data51 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("Book51 name: " + data51);
		
		String data73 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]//td[3]")).getText();
		System.out.println("Book73 subject: " + data73 + "\n");
		
	
		//4) Read data from all the rows and columns
		for(int r = 2; r <= rows; r++) 
		{
			for(int c = 1; c <= cols; c++) 
			{
				String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(data+ "\t"); //spacing between values
			}
				System.out.println(); //linebreak each rows in the table
		}
		
		//5)Print books name of specific author
		System.out.println();
		for(int r = 2 ; r <= rows; r++) {
			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();	
		
			if(authorName.equals("Mukesh")) 
			{
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName +" - "+ authorName ); 
			}
		}
		
		//6) Print each book price and total price of all the book
		System.out.println();
		int totalPrice = 0;
		for(int r = 2 ; r <= rows; r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();	
			System.out.println(price);
			totalPrice = totalPrice + Integer.parseInt(price);			
		}
		System.out.println("---------------------");
		System.out.println("Total price of all books: " + totalPrice);
		
		
	
	}

}
