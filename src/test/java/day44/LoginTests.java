package day44;

import org.testng.annotations.Test;

public class LoginTests {

	@Test(priority=1, groups={"sanity"})
	void loginByEmail() {
		System.out.println("This is loginByEmail...");
	}

	@Test(priority=2, groups={"sanity"})
	void loginByFaceBook() {
		System.out.println("This is loginByFaceBook...");
	}
	
	@Test(priority=3, groups={"sanity"})
	void loginByTwitter() {
		System.out.println("This is loginByTwitter...");
	}
	
	
}
