package TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

public class TC_AddressBook {
	public ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
WebDriver driver;
@Test(priority=1)
 public void ADress() {
System.out.println("TestMethod");
test = report.createTest("AddressTest1");

driver.get("https://demo.opencart.com/index.php?route=account/login");
driver.findElement(By.name("email")).sendKeys("1239@gmail.com");
driver.findElement(By.name("password")).sendKeys("1234567");
driver.findElement(By.xpath("//input[@value='Login']")).click();
WebElement first=driver.findElement(By.xpath("//a[@href=\'https://demo.opencart.com/index.php?route=account/address']"));
first.click();
WebElement first2=driver.findElement(By.xpath("//a[@href=\'https://demo.opencart.com/index.php?route=account/address/add']"));
first2.click();
driver.findElement(By.name("firstname")).sendKeys("R");
driver.findElement(By.name("lastname")).sendKeys("Ku");
driver.findElement(By.name("company")).sendKeys("");
driver.findElement(By.name("address_1")).sendKeys("South");
driver.findElement(By.name("address_2")).sendKeys("Africa");
driver.findElement(By.name("city")).sendKeys("Belgium");
driver.findElement(By.name("postcode")).sendKeys("600");
driver.findElement(By.id("input-country")).click();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
driver.findElement(By.id("input-zone")).click();
Select se = new Select(driver.findElement(By.id("input-zone")));
se.selectByVisibleText("Berkshire");
driver.findElement(By.name("default")).click();
driver.findElement(By.xpath("//input[@value='Continue']")).click();

}

@Test(priority=2)
public void Mandatory() {
System.out.println("TestMethod - f1");
test = report.createTest("AddressTest1");


driver.get("https://demo.opencart.com/index.php?route=account/login");
assertEquals("https://demo.opencart.com/index.php?route=account/login",driver.getCurrentUrl());

driver.findElement(By.name("email")).sendKeys("1239@gmail.com");
driver.findElement(By.name("password")).sendKeys("1234567");
driver.findElement(By.xpath("//input[@value='Login']")).click();
WebElement first1=driver.findElement(By.xpath("//a[@href=\'https://demo.opencart.com/index.php?route=account/address']"));
first1.click();
WebElement first2=driver.findElement(By.xpath("//a[@href=\'https://demo.opencart.com/index.php?route=account/address/add']"));
first2.click();

driver.findElement(By.name("firstname")).sendKeys("jack");
driver.findElement(By.name("lastname")).sendKeys("King");
driver.findElement(By.name("company")).sendKeys("lux");
driver.findElement(By.name("address_1")).sendKeys("North");
driver.findElement(By.name("address_2")).sendKeys("Africa");
driver.findElement(By.name("city")).sendKeys("Bangalore");
driver.findElement(By.name("postcode")).sendKeys("6000");
driver.findElement(By.id("input-country")).click();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//driver.findElement(By.id("input-zone")).click();
Select se = new Select(driver.findElement(By.id("input-zone")));
se.selectByVisibleText("Berkshire");
driver.findElement(By.name("default")).click();
driver.findElement(By.xpath("//input[@value='Continue']")).click();
}


private void assertEquals(String string, String currentUrl) {
	// TODO Auto-generated method stub
	
}

@BeforeMethod
public void beforeMethod() {
System.out.println("BeforeMethod");
 //System.setProperty("webdriver.chrome.driver","C:\\Users\\GOOD.GOOD-PC\\Downloads\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
}

 @AfterMethod
public void afterMethod() {
System.out.println("After Method");
}

 
 @BeforeClass
 public void beforeClass() {
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\chromedriver\\chromedriver.exe");

 reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Report.html");
 reporter.config().setTheme(Theme.DARK);
 reporter.config().setDocumentTitle("RegisterReport");
 reporter.config().setReportName("FunctionalTest Report");
 report = new ExtentReports();
 report.attachReporter(reporter);
 }
 @AfterClass
public void afterClass() {
System.out.println("After Class");
driver.close();
}

 @BeforeTest
public void beforeTest() {
System.out.println("Before Test");
}

 @AfterTest
public void afterTest() {
System.out.println("After Test");
}
}
