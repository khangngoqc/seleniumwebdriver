package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		/*
		 * driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(
		 * "D:\\Test1.png");
		 * 
		 * if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals(
		 * "Test1.png")) { System.out.println("File is successfully uploaded"); }else {
		 * System.out.println("Upload failed"); }
		 */
		
		//Multiple file upload
		String file1 = "D:\\Test1.png";
		String file2 = "D:\\Test2.png";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);
		
		int files = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		
		if(files == 2) {
			System.out.println("All files are uploaded");
		}else {
			System.out.println("File are not uploaded or incorrect files uploaded");
		}
		
		//validate file names
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("Test1.png") 
				&& driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("Test2.png")) {
			System.out.println("File names matchings..");
		}else {
			System.out.println("Incorrect file names");
		}
	}

}
