package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor
	LoginPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	//Locators
	By txt_username_loc = By.xpath("//input[@placeholder='Username']");
	By txt_password_loc = By.xpath("//input[@placeholder='Password']");
	By btn_login_loc = By.xpath("//button[normalize-space()='Login']");
	
	
	//Action methods
	public void setUsername(String username) {
		driver.findElement(txt_username_loc).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(txt_password_loc).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(btn_login_loc).click();	
	}

}
