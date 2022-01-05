package TestCases;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pageobject.AccountPage;
import Pageobject.LoginPage;
import Utilities.Constant;
import Utilities.Excelutils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TC_LoginPage {
public WebDriver driver;
public LoginPage lp;
public AccountPage ap;
public ExtentHtmlReporter reporter;
public static ExtentReports report;
public static ExtentTest test;

@Test()
public void textLogin_01() throws Exception {
//for(int i=1;i<Excelutils.getRowCount();i++)
//{
	test = report.createTest("LoginTest_1");
lp.enterAddress(Excelutils.getCellData(1, 0));
lp.enterPwd(Excelutils.getCellData(1, 1));
lp.clickLogin();
String currURl= driver.getCurrentUrl();
if(currURl.equalsIgnoreCase("https://demo.opencart.com/index.php?route=account/account"))
{
ap.clickLogout();
driver.get("https://demo.opencart.com/index.php?route=account/login");
Excelutils.setCellData("Pass",1 ,2 );
test.log(Status.PASS, "Test Case Passed for Valid data");
SoftAssert soft=new SoftAssert();
Boolean msg=driver.getPageSource().contains("https://demo.opencart.com/index.php?route=account/account");
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

}
else
{
	test.log(Status.PASS, "Test Case Pass for InValid data");
Excelutils.setCellData("Fail",1 ,2 );
}
}
//}

@Test()
public void textLogin_02() throws Exception {
//for(int i=1;i<Excelutils.getRowCount();i++)
//{
	test = report.createTest("LoginTest_2");
lp.enterAddress(Excelutils.getCellData(2, 0));
lp.enterPwd(Excelutils.getCellData(2, 1));
lp.clickLogin();

String currURl= driver.getCurrentUrl();
if(currURl.equalsIgnoreCase("https://demo.opencart.com/index.php?route=account/account"))
{
ap.clickLogout();
driver.get("https://demo.opencart.com/index.php?route=account/login");
Excelutils.setCellData("Pass",2 ,2 );
test.log(Status.PASS, "Test Case Passed for Valid data");
}
else
{
test.log(Status.PASS, "Test Case Pass for InValid data");
Excelutils.setCellData("Fail",2 ,2 );
SoftAssert soft=new SoftAssert();
Boolean msg=driver.getPageSource().contains("account page");
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
}
}
//}
@BeforeMethod
public void beforeMethod() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\chromedriver\\chromedriver.exe");
Excelutils.setExcelFile(Constant.filename, "Login");
driver = new ChromeDriver();
driver.get("https://demo.opencart.com/index.php?route=account/login");
lp=new LoginPage(driver);
ap=new AccountPage(driver);

}

 @AfterMethod
public void afterMethod() {
driver.close();
report.flush();
}
 @BeforeClass
 public void beforeClass() {
 reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Report.html");
 reporter.config().setTheme(Theme.DARK);
 reporter.config().setDocumentTitle("SampleReport");
 reporter.config().setReportName("FunctionalTest Report");
 report = new ExtentReports();
 report.attachReporter(reporter);
 }


}
