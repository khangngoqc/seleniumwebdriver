package day35;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
Assignments 
1)double click&Drag and drop https://testautomationpractice.blogspot.com/
2)drag and drop http://demo.guru99.com/test/drag_drop.html
*/

public class Assignment {

	static void Ass1(WebDriver driver) {

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement copyTextBtn = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));

		Actions act = new Actions(driver);
		act.doubleClick(copyTextBtn).perform();

		// check value
		if (field2.getAttribute("value").equals(field1.getAttribute("value"))) {
			System.out.println("Text copied successfully: " + "\n- F1: " + field1.getAttribute("value") + "\n - F2: "
					+ field2.getAttribute("value"));
		} else {
			System.out.println("Fail to copy text from Field1" + field1.getAttribute("value"));
		}

		System.out.println();

		WebElement dragItem = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropItem = driver.findElement(By.xpath("//div[@id='droppable']"));

		act.dragAndDrop(dragItem, dropItem).perform();

		String dropItemText = driver.findElement(By.xpath("//div[@id='droppable']//p")).getText();

		if (dropItemText.equals("Dropped!")) {
			System.out.println("Drag and drop item successfully!");
		} else {
			System.out.println("Fail to drag & drop item");
		}
	}

	static void Ass2(WebDriver driver) throws InterruptedException {
		driver.get("https://demo.guru99.com/test/drag_drop.html");

		Actions act = new Actions(driver);

		List<WebElement> products = driver.findElements(By.xpath("//div[@id='products']//ul//li"));
		WebElement warningStatus = driver.findElement(By.xpath("//div[@id='e1']"));

		List<WebElement> dragableProducts = driver.findElements(By.xpath("//li[contains(@class,'block')]"));

		/*
		 * for (WebElement p : products) { act.dragAndDrop(p,
		 * driver.findElement(By.xpath("//div[@id='products']"))).perform();
		 * 
		 * Thread.sleep(500);
		 * 
		 * 
		 * System.out.println(warningStatus.getDomAttribute("style"));
		 * 
		 * if (warningStatus.getDomAttribute("style").contains("display: none;")) {
		 * dragableProducts.add(p); } }
		 */

		System.out.println(dragableProducts.size());


		for (int i = 0; i < dragableProducts.size(); i++) {
			List<WebElement> placeholders = driver.findElements(By.xpath("//div//ol//li[@class='placeholder']"));

			for (int p = 0; p < placeholders.size(); p++) {
				act.dragAndDrop(dragableProducts.get(i), placeholders.get(p)).perform();
								
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Ass1(driver);

		Ass2(driver);

		/*
		 * driver.get("https://demo.guru99.com/test/drag_drop.html");
		 * 
		 * Actions act = new Actions(driver);
		 * 
		 * act.dragAndDrop(driver.findElement(By.xpath(
		 * "//div[@id='products']//ul//li[2]")),
		 * driver.findElement(By.xpath("//div//ol[@id='amt8']//li//br"))).perform();
		 */

	}

}
