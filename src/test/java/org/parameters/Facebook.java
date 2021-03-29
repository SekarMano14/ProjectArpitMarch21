package org.parameters;
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
	@Parameters({"username","password"})
	@Test
	private void test1(String user,String pass) {
		launchUrl("https://www.facebook.com/");
		LoginPage l= new LoginPage();
		filltextBox(l.getTxtUsername().get(0), user);
		filltextBox(l.getTxtPassword(),pass);
		btnclick(l.getBtnLogin());
		System.out.println("Test1");
			}
	@Test
	private void test2() {
		System.out.println("Test2");
	}
	

}
