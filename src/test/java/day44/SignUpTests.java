package day44;

import org.testng.annotations.Test;

public class SignUpTests {

	@Test(priority=1, groups={"regression"})
	void signupByEmail() {
		System.out.println("This is signupByEmail...");
	}
	
	@Test(priority=2, groups={"regression"})
	void sigupnByFacebook() {
		System.out.println("This is loginByFacebook...");
	}
	
	@Test(priority=3, groups={"regression"})
	void sigupnByTwitter() {
		System.out.println("This is loginByTwitter...");
	}
}
