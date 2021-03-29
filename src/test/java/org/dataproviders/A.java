package org.dataproviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A {
	@Test(dataProvider="login")
	private void testA1(String user, String pass) {
		System.out.println("TestA1");
		System.out.println(user);
		System.out.println(pass);

	}
	
	@DataProvider(name="login", indices= {0,2}, parallel=true)
	public static Object[][] getdata() {
		Object obj[][]=new Object[][] 
				{
			       {"manoj","23456"},
			       {"kumar","23456"},
			       {"raj","987654"}};
			       return obj;

	}
	

}
