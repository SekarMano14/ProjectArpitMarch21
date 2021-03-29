package org.rerun;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample {
	WebDriver driver;

	@Parameters({"browserName"})
	@BeforeClass
	private void beforeClass(String browser) {
		System.out.println("Before Class");
		if(browser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ManoKutty\\eclipse-workspace\\TestNG8.30AM_Jan\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();		}
		else if(browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ManoKutty\\eclipse-workspace\\TestNG8.30AM_Jan\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();	}
		else if(browser.equals("Ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\ManoKutty\\eclipse-workspace\\TestNG8.30AM_Jan\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();		}
		driver.manage().window().maximize();
	}

	@AfterClass
	private void afterClass() {
		System.out.println("After Class");
		driver.quit();
	}

	@BeforeMethod
	private void beforemethod() {
		System.out.println("Before Method");
		System.out.println("Test starts......" + new Date());
	}

	@AfterMethod
	private void afterMethod() {
		System.out.println("After method");
		System.out.println("Test Ends......" + new Date());
		
	}

	@Test
	private void test2() {
		System.out.println("Test2");
	}

	@Test
	private void test1() throws InterruptedException {
		System.out.println("Test1");
		driver.get("https://www.facebook.com/");
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys("mk");
		WebElement txtpassword = driver.findElement(By.id("pass"));
		txtpassword.sendKeys("5678");


	}

}
