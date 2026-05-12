package day43;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
	
	@Test
	void test() {
		//Assert.assertEquals("xyz", "xyz1");
		//Assert.assertEquals(123 , 345);
		
		//Assert.assertEquals("abc", 123);
		//Assert.assertEquals("123", 123);
		
		//Assert.assertNotEquals(123, 123); //failed

		//Assert.assertNotEquals(123, 345); //passed
		
		//Assert.assertTrue(true); //passed
		//Assert.assertTrue(false); //failed
		
		//Assert.assertTrue(1==2); //failed
		//Assert.assertTrue(1==1); //passed
		
		//Assert.assertFalse(1==2); //passed
		//Assert.assertFalse(1==1); //failed
		
		Assert.fail();
	}



}
