package day43;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
1) Login -- @BeforClass
2) Search -- @Test
3) Advanced Search -- @Test
4) Logout --@AfterClass
*/

public class AnnotattionsDemo2 {
	@BeforeClass
	void login() {
		System.out.println("This is login...");
	}
	

	@AfterClass
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
