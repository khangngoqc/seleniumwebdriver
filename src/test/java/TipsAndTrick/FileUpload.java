package TipsAndTrick;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.foundit.in/upload");
		
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn secondaryBtn']")).click();
		
		String filePath = "D:\\TestFile.txt";
		
		Thread.sleep(2000);
		
		//1)using sendKeys() methods
		//driver.findElement(By.xpath("(//input[@id='file-upload'])[1]")).sendKeys("D:\\TestFile.txt");
		
		
		//2) using Robot class
		//driver.findElement(By.xpath("(//input[@id='file-upload'])[1]")).click();
		
		WebElement input =driver.findElement(By.xpath("(//input[@id='file-upload'])[1]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", input);
		
		//step1: copy(ctrl+C) the file path into the system clipboard
		StringSelection filePathSelction = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelction, null);
		
		//step2: paste(ctrl+V)
		Robot rb = new Robot();
		
		rb.keyPress(KeyEvent.VK_CONTROL);	//For MAC: rb.keyPress(KeyEvent.VK_META);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		//step3: click on return/enter key
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
		Thread.sleep(3000);
		
	}

}
