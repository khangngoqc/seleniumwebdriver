package day43;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {

	@BeforeSuite
	void bs() {
		System.out.println("This is BeforeSuite");
	}
	
	@AfterSuite
	void as() {
		System.out.println("This is AfterSuite");
	}
	
	@BeforeTest
	void bt() {
		System.out.println("This is BeforeTest");
	}
	@AfterTest
	void at() {
		System.out.println("This is AfterTest");
	}
	
	@BeforeClass
	void bc() {
		System.out.println("This is  BeforeClass");
	}
	@AfterClass
	void ac() {
		System.out.println("This is AfterClass");
	}
	
	@Test
	void test() {
		System.out.println("This is test");
	}
	
	
	
	
	
}
