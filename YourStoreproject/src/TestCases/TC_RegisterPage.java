package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pageobject.RegisterPage;
import Pageobject.SuccessPage;
import Utilities.Constant;
import Utilities.Excelutils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TC_RegisterPage {
public WebDriver driver;
public RegisterPage rp;
public SuccessPage sp;

public ExtentHtmlReporter reporter;
public static ExtentReports report;
public static ExtentTest test;

@Test
public void textRegister_01() throws Exception {
//for(int i=1;i<Excelutils.getRowCount();i++)
//{
test = report.createTest("RegisterTest1");
rp.enterfirstname(Excelutils.getCellData(1, 0));
rp.enterlastname(Excelutils.getCellData(1, 1));
rp.enteremail(Excelutils.getCellData(1, 2));
rp.entertelephone(Excelutils.getCellData(1, 3));
rp.enterpassword(Excelutils.getCellData(1, 4));
rp.enterconfirmpassword(Excelutils.getCellData(1, 5));
rp.clickyesradio();
rp.clickcheckbox();
rp.clickconbutton();

String currURl= driver.getCurrentUrl();
if(currURl.equalsIgnoreCase("https://demo.opencart.com/index.php?route=account/success"))
{
	driver.get("https://demo.opencart.com/index.php?route=account/register");
	Excelutils.setCellData("Pass",1 ,6);
	test.log(Status.PASS, "Test Case Passed for Valid data");
	SoftAssert soft=new SoftAssert();
	Boolean msg=driver.getPageSource().contains("https://demo.opencart.com/index.php?route=account/success");
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
	
	//driver.get("https://demo.opencart.com/index.php?route=account/register");
}
else
{
	test.log(Status.PASS, "Test Case Pass for InValid data");
	Excelutils.setCellData("Fail",1 ,6 );
	//driver.get("https://demo.opencart.com/index.php?route=account/register");
	

}
}
//}
@Test
public void textRegister_02() throws Exception {
//for(int i=1;i<Excelutils.getRowCount();i++)
//{
test = report.createTest("RegisterTest2");
rp.enterfirstname(Excelutils.getCellData(2, 0));
rp.enterlastname(Excelutils.getCellData(2, 1));
rp.enteremail(Excelutils.getCellData(2, 2));
rp.entertelephone(Excelutils.getCellData(2, 3));
rp.enterpassword(Excelutils.getCellData(2, 4));
rp.enterconfirmpassword(Excelutils.getCellData(2, 5));
rp.clickyesradio();
rp.clickcheckbox();
rp.clickconbutton();

String currURl= driver.getCurrentUrl();
if(currURl.equalsIgnoreCase("https://demo.opencart.com/index.php?route=account/success"))
{
	driver.get("https://demo.opencart.com/index.php?route=account/register");
	Excelutils.setCellData("Pass",2 ,6);
	test.log(Status.PASS, "Test Case Passed for Valid data");
	//driver.get("https://demo.opencart.com/index.php?route=account/register");
}
else
{
	test.log(Status.PASS, "Test Case Pass for InValid data");
	Excelutils.setCellData("Fail",2 ,6 );
	SoftAssert soft=new SoftAssert();
	Boolean msg=driver.getPageSource().contains("https://demo.opencart.com/index.php?route=account/register");
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
	//driver.get("https://demo.opencart.com/index.php?route=account/register");
	

}
}
//}

@BeforeMethod
public void beforeMethod() throws Exception {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\chromedriver\\chromedriver.exe");
Excelutils.setExcelFile(Constant.filename, "Register");
driver = new ChromeDriver();
driver.get("https://demo.opencart.com/index.php?route=account/register");
rp=new RegisterPage(driver);


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
 reporter.config().setDocumentTitle("RegisterReport");
 reporter.config().setReportName("FunctionalTest Report");
 report = new ExtentReports();
 report.attachReporter(reporter);
 }
 


}