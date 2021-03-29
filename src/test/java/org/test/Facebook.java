package org.test;
import java.util.Date;
import org.base.BaseClass;
import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
public class Facebook extends BaseClass {
	@BeforeClass
	private void beforeClass() {
		launchBrowser();
		System.out.println("Before Class");
	}
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Test Starts....."+new Date());
		System.out.println("Before Method");
	}
	@AfterClass
	private void afterClass() {
		browserQuit();
		System.out.println("After Class");
	}
	@AfterMethod
	private void afterMethod() {
		System.out.println("Test Ends....."+new Date());
		System.out.println("After Method");
	}
	@Test
	private void test1() {
		launchUrl("https://www.facebook.com/");
		SoftAssert s= new SoftAssert();
		s.assertTrue(driver.getCurrentUrl().contains("facebook"),"Verify url");
		LoginPage l= new LoginPage();
		filltextBox(l.getTxtUsername().get(0), "mano");
		s.assertEquals("manoj", l.getTxtUsername().get(0).getAttribute("value"),"Verify username");
		filltextBox(l.getTxtPassword(),"3456789");
		s.assertEquals("3456789", l.getTxtPassword().getAttribute("value"),"Verify password");
		btnclick(l.getBtnLogin());
		System.out.println("Test1");
		s.assertAll();	}
	@Test
	private void test2() {
		System.out.println("Test2");
	}
	

}
