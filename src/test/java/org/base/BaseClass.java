package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ManoKutty\\eclipse-workspace\\TestNGArpitWeekEnd\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	public static WebDriver launchFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\ManoKutty\\eclipse-workspace\\TestNGArpitWeekEnd\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	public static WebDriver launchIEBrowser() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\ManoKutty\\eclipse-workspace\\TestNGArpitWeekEnd\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	public static WebDriver launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ManoKutty\\eclipse-workspace\\TestNGArpitWeekEnd\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void filltextBox(WebElement e, String value) {
		e.sendKeys(value);
	}

	public static void btnclick(WebElement e) {
		e.click();
	}

	public static String getAttribute(WebElement e) {
		String at = e.getAttribute("value");
		return at;
	}

	public static String getText(WebElement e) {
		String at = e.getText();
		return at;
	}

	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	public static void dragAndDrop(WebElement src, WebElement des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}

	public static void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static WebElement findelementbyid(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public static void scrollUp(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public static void JsSendkeys(WebElement e, String input) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + input + "')", e);
	}

	public static void browserQuit() {
		driver.quit();
	}

	public static String getData(int rowNo, int cellNo) throws IOException {
		File f = new File(
				"C:\\Users\\ManoKutty\\eclipse-workspace\\MavenWeekEndFeb_21\\src\\test\\resources\\Excel\\Data.xlsx");

		FileInputStream st = new FileInputStream(f);

		// workbook
		Workbook w = new XSSFWorkbook(st);
		// sheet
		Sheet sheet = w.getSheet("Datas");
		// row
		Row row = sheet.getRow(rowNo);
		// cell
		Cell c = row.getCell(cellNo);
		int type = c.getCellType();
		String value = null;
		if (type == 1) {
			value = c.getStringCellValue();
		} else {
			if (DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
				value = sf.format(date);
			} else {
				double num = c.getNumericCellValue();
				long ln = (long) num;
				value = String.valueOf(ln);
			}
		}
		return value;

	}

	public static void main(String[] args) throws IOException {
		String data = getData(1, 2);
		System.out.println(data);
	}

}
