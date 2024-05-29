package test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class JunitSuiteLevel2 {
	@Test
	public void t1() {
		System.out.println("Test 1");
	}
	@Ignore
	@Test
	public void t2() {
		System.out.println("Test 2");
	}
	@Test
	public void t3() {
		Assert.assertTrue("verify",false);
		System.out.println("Test 3");
	}
	

}
