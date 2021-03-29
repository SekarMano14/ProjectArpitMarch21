package org.dataproviders;

import org.testng.annotations.*;

public class Sample {
	
	@Parameters({"Username","password"})
	@Test
	private void testA1(@Optional("kumar")String user,@Optional("00000")String pass) {
		System.out.println("TestA1");
		System.out.println(user);
		System.out.println(pass);
	}
	@Test
	private void testA2() {
		System.out.println("TestA2");
	}
	@Test
	private void testA3() {
		System.out.println("TestA3");
	}

}
