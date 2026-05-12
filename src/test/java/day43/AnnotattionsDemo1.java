package day43;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
1) Login -- @BeforMethod
2) Search -- @Test
3) Logout --@AfterMetod
4) Login
5) Advanced Search -- @Test
6) Logout
*/

public class AnnotattionsDemo1 {
	@BeforeMethod
	void login() {
		System.out.println("This is login...");
	}
	

	@AfterMethod
	void logout() {
		System.out.println("This is logout...");		
	}

	
	@Test(priority=1)
	void search() {
		System.out.println("This is search...");
	}
	
	@Test(priority=2)
	void advancedsearch() {
		System.out.println("This is advanced search...");
	}
	
	
}
