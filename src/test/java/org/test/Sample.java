package org.test;

import org.testng.annotations.*;

public class Sample {
	@BeforeClass
	private void beforeClass() {
		System.out.println("Before Class");

	}

	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Before Method");

	}

	@AfterClass
	private void afterClass() {
		System.out.println("After Class");

	}

	@AfterMethod
	private void afterMethod() {
		System.out.println("After Method");

	}

	@Test(priority=2, invocationCount=5, enabled=true, threadPoolSize=5)
	private void test1() {
		System.out.println("Test1");
	}
	@Test(enabled=false)
	private void test2() {
		System.out.println("Test2");
	}
	@Test(priority=-12)
	private void test3() {
		System.out.println("Test3");
		System.out.println("Test4");
	}

}
