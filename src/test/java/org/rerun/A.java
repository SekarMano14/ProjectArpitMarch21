package org.rerun;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class A {

	@Test
	private void testA1() {
		Assert.assertTrue(true);
		System.out.println("TestA1");
	}

	@Test
	private void testA2() {
		Assert.assertTrue(false);
		System.out.println("TestA2");
	}

	@Test
	private void testA3() {
		Assert.assertTrue(true);
		System.out.println("TestA3");
	}

}
