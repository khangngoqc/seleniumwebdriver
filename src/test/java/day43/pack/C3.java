package day43.pack;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {

	@Test
	void xyz() {
		System.out.println("This is pqr from C3");
	}

	@BeforeSuite
	void bs() {
		System.out.println("This is BeforeSuite form C3");

	}

	@AfterSuite
	void as() {
		System.out.println("This is AfterSuite form C3");

	}
}
