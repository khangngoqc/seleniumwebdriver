package day44;

import org.testng.annotations.Test;

public class PaymentTests {

	@Test(priority=1, groups={"sanity", "regression","functional"})
	void paymentinRupees() {
		System.out.println("This is paymentinRupees...");
	}
	
	@Test(priority=2, groups={"sanity", "regression", "functional"})
	void paymentinDollars() {
		System.out.println("This is paymentinDollars...");
	}
	
}
