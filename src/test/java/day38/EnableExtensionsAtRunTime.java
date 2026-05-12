package day38;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionsAtRunTime {

	public static void main(String[] args) {
		
		ChromeOptions options =  new ChromeOptions();
				
		options.addExtensions(new File("C:\\Users\\ADMIN\\myworkspace\\seleniumwebdriver\\seleniumwebdriver\\Extensions\\SelectorsHub-Cửa-hàng-Chrome-trực-tuyến.crx"));
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		
	
		
		
	}
}

