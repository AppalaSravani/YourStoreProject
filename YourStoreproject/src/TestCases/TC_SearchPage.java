package TestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pageobject.SearchPage;

import Utilities.Excelutils;
import Utilities.Constant;
public class TC_SearchPage {
public WebDriver driver;
public SearchPage srh;

public ExtentHtmlReporter reporter;
public  ExtentReports report;
public  ExtentTest test;
@Test(priority=1)
public void textSearch() throws Exception {


test = report.createTest("Search__"+1);
srh.enterProductName(Excelutils.getCellData(1, 0));
srh.clicksrhbutton();
String currURl= driver.getCurrentUrl();
if(currURl.equalsIgnoreCase("https://demo.opencart.com/index.php?route=product/category&path=20_27"))
{

Excelutils.setCellData("pass",1 ,1 );

test.log(Status.PASS, "Test Case Passed for Valid data");
}
else
{
Excelutils.setCellData("fail",1 ,1 );
SoftAssert soft=new SoftAssert();
Boolean msg=driver.getPageSource().contains("https://demo.opencart.com/index.php?route=product/category&path=20_27");
if(msg==true)
{
soft.assertTrue(true);
soft.assertAll();
}
else
{
soft.assertTrue(false);
soft.assertAll();
}
test.log(Status.FAIL, "Test Case Pass for InValid data");

}
}
@Test(priority=2)
public void Search1() throws Exception {


test= report.createTest("Search__"+2);
srh.enterProductName(Excelutils.getCellData(2, 0));
srh.clicksrhbutton();
String currURl= driver.getCurrentUrl();
if(currURl.equalsIgnoreCase("https://demo.opencart.com/index.php?route=product/search&search=iphone"))
{

Excelutils.setCellData("pass",2 ,1 );

test.log(Status.PASS, "Test Case Passed for Valid data");

}
else
{
Excelutils.setCellData("fail",2 ,1 );
SoftAssert soft=new SoftAssert();
Boolean msg=driver.getPageSource().contains("https://demo.opencart.com/index.php?route=product/search&search=iphone");
if(msg==true)
{
soft.assertTrue(true);
soft.assertAll();
}
else
{
soft.assertTrue(false);
soft.assertAll();
}
test.log(Status.FAIL, "Test Case Pass for InValid data");

}
}
@Test(priority=3)
public void Search2() throws Exception {


test = report.createTest("Search__"+3);
srh.enterProductName(Excelutils.getCellData(3, 0));
srh.clicksrhbutton();
String currURl= driver.getCurrentUrl();
if(currURl.equalsIgnoreCase("https://demo.opencart.com/index.php?route=product/search&search=RedmiNote6pro"))
{

Excelutils.setCellData("pass",3 ,1 );
test.log(Status.PASS, "Test Case Passed for Valid data");
}
else
{
Excelutils.setCellData("fail",3,1 );
SoftAssert soft=new SoftAssert();
Boolean msg=driver.getPageSource().contains("https://demo.opencart.com/index.php?route=product/search&search=RedmiNote6pro");
if(msg==true)
{
soft.assertTrue(true);
soft.assertAll();
}
else
{
soft.assertTrue(false);
soft.assertAll();
}
test.log(Status.FAIL, "Test Case Pass for InValid data");
}
}

@BeforeMethod
public void beforeMethod() throws Exception {
System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\chromedriver\\chromedriver.exe");
Excelutils.setExcelFile(Constant.filename, "search");
driver = new ChromeDriver();
driver.get("https://demo.opencart.com/");
srh=new SearchPage(driver);
reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Report.html");
reporter.config().setTheme(Theme.DARK);
reporter.config().setDocumentTitle("SampleReport");
reporter.config().setReportName("FunctionalTest Report");
reporter.setAppendExisting(true);
report = new ExtentReports();
report.attachReporter(reporter);
}
 
 @AfterMethod
public void afterMethod() {
driver.close();
report.flush();
}


}