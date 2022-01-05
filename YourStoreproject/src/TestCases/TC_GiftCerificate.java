package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pageobject.GiftsPage;
import Utilities.Excelutils;
import Pageobject.GiftsPage;
import Utilities.Constant;
import Utilities.Excelutils;

public class TC_GiftCerificate {
public WebDriver driver;
public GiftsPage pl;
public ExtentHtmlReporter reporter;
public static ExtentReports report;
public static ExtentTest test;
@Test(priority=1)
public void textPurchase() throws Exception {
    
	test = report.createTest("LoginTest__"+1);
	pl.enterReceName(Excelutils.getCellData( 1,0));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
	pl.enterReceEmail(Excelutils.getCellData(1,1));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
	pl.enterYourName(Excelutils.getCellData(1,2));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
	pl.enterYourMail(Excelutils.getCellData(1,3));
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
	pl.giftCertificateTheme(Excelutils.getCellData(1,4));
	driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	pl.enterUrMes(Excelutils.getCellData(1,5));
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	pl.enterAmou(Excelutils.getCellData(1,6));
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	pl.clickcheckbox();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	pl.clickbutton();
	String currURl= driver.getCurrentUrl();
	
		
		if(currURl.equalsIgnoreCase("https://demo.opencart.com/index.php?route=account/voucher/success"))
		{
			Excelutils.setCellData("pass",1,7);
		 SoftAssert soft=new SoftAssert();
		 Boolean msg=driver.getPageSource().contains("https://demo.opencart.com/index.php?route=account/voucher/success");
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
		test.log(Status.PASS, "Test Case Passed for Valid data");
	}
	else
	{
		Excelutils.setCellData("Fail",1 ,7);
	test.log(Status.PASS, "Test Case Pass for InValid data");
	}
	}
	

@Test(priority=2)
public void purchase() throws Exception{
	for(int i=2;i<Excelutils.getRowCount();i++)
	{     
		test = report.createTest("LoginTest__"+i);
		pl.enterReceName(Excelutils.getCellData( i,0));
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		pl.enterReceEmail(Excelutils.getCellData(i,1));
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		pl.enterYourName(Excelutils.getCellData(i,2));
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		pl.enterYourMail(Excelutils.getCellData(i,3));
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		pl.giftCertificateTheme(Excelutils.getCellData(i,4));
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		pl.enterUrMes(Excelutils.getCellData(i,5));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		pl.enterAmou(Excelutils.getCellData(i,6));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		pl.clickcheckbox();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		pl.clickbutton();
		String currURl= driver.getCurrentUrl();
		if(currURl.equalsIgnoreCase("https://demo.opencart.com/index.php?route=account/voucher/success"))
		{
	
			Excelutils.setCellData("Fail",i,7);
			 SoftAssert soft=new SoftAssert();
			 Boolean msg=driver.getPageSource().contains("https://demo.opencart.com/index.php?route=account/voucher");
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
			test.log(Status.PASS, "Test Case Passed for Valid data");
		}
		else
		{
		  Excelutils.setCellData("pass",i ,7);
		   test.log(Status.PASS, "Test Case Pass for InValid data");
		}
		
	}
}

	@BeforeMethod
	public void beforeMethod() throws Exception {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\chromedriver\\chromedriver.exe");
	Excelutils.setExcelFile(Constant.filename,"Gift");
	driver = new ChromeDriver();
	driver.get("https://demo.opencart.com/index.php?route=account/voucher");
	pl=new GiftsPage(driver);
	
	}

	 @AfterMethod
	public void afterMethod() {
	//driver.close();
		 //driver.close();
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
