package TipsAndTrick;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_DynamicTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/dynamic-table");

		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));
		//System.out.println("Number of rows: " + rows.size());

		for (int r = 1; r <= rows.size(); r++) {
			String name = driver.findElement(By.xpath("//table//tbody//tr[" + r + "]//td[1]")).getText();
			//System.out.println(name);

			if (name.equals("Chrome")) {

				String cpuLoad = driver
						.findElement(By
								.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'%')]"))
						.getText();

				WebElement pText = driver.findElement(By.xpath("//p[@id='chrome-cpu']"));
				
				WebElement divText = driver.findElement(By.xpath("//p[@id='chrome-cpu']/div"));

				String value = textReplace(pText, divText);

				if (value.contains(cpuLoad)) {
					System.out.println("CPU Load is equal " + cpuLoad + " " + value);
					
				} else {
					System.out.println("CPU Load is not equal " + cpuLoad + " " + value);
				}
				break;

			}

		}
		
		driver.quit();
		

	}
	
	//trim text of the inside div element method
	public static String textReplace(WebElement pElement, WebElement divElement) {
		
		String fullText = pElement.getText();
		String childText = divElement.getText();
		
		String resultText = fullText.replace(childText, "").trim();
		
		return resultText;

	}

}
