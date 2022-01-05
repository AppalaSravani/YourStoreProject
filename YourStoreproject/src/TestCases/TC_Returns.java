package TestCases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TC_Returns {
WebDriver driver;
@Test(priority=1)
 public void Email() {
System.out.println("TestMethod - f");
driver.get("https://demo.opencart.com/index.php?route=common/home");
WebElement first=driver.findElement(By.xpath("//a[@href=\'https://demo.opencart.com/index.php?route=account/return/add\']"));
first.click();
driver.findElement(By.id("input-firstname")).sendKeys("Raj");
driver.findElement(By.id("input-lastname")).sendKeys("Kumar");
driver.findElement(By.id("input-email")).sendKeys("lever.care@unilever.com");
driver.findElement(By.id("input-telephone")).sendKeys("6476545563");
driver.findElement(By.id("input-order-id")).sendKeys("45645647");
driver.findElement(By.id("input-product")).sendKeys("Canon EOS 5D Camera");
driver.findElement(By.id("input-model")).sendKeys("2");
WebElement trr=driver.findElement(By.xpath("((//input[@name='return_reason_id'])[3])"));
trr.click();
WebElement trr1=driver.findElement(By.xpath("//input[@name='opened']"));
trr1.click();
driver.findElement(By.id("input-comment")).sendKeys("Crack on glass ");
WebElement trr2=driver.findElement(By.xpath("//input[@value='Submit']"));
trr2.click();
String title=driver.getTitle();
Assert.assertEquals(title,"Product Returns");
}

@Test(priority=2)
public void Mandatory() {
System.out.println("TestMethod - f1");
driver.get("https://demo.opencart.com/index.php?route=common/home");
WebElement first1=driver.findElement(By.xpath("//a[@href=\'https://demo.opencart.com/index.php?route=account/return/add\']"));
first1.click();
driver.findElement(By.id("input-firstname")).sendKeys("Ravi");
driver.findElement(By.id("input-lastname")).sendKeys("Kumar");
driver.findElement(By.id("input-email")).sendKeys("lever.care@unilever.com");
driver.findElement(By.id("input-telephone")).sendKeys("6345678957");
driver.findElement(By.id("input-order-id")).sendKeys("4564567");
driver.findElement(By.id("input-product")).sendKeys("HPLP3065");
WebElement trr3=driver.findElement(By.xpath("((//input[@name='return_reason_id'])[4])"));
trr3.click();
WebElement trr4=driver.findElement(By.xpath("//input[@name='opened']"));
trr4.click();
WebElement trr5=driver.findElement(By.xpath("//input[@value='Submit']"));
trr5.click();
String url=driver.getCurrentUrl();
Assert.assertTrue(url.equalsIgnoreCase("https://demo.opencart.com/index.php?route=account/return/add"));
System.out.println("I am done");
}


@BeforeMethod
public void beforeMethod() {
System.out.println("BeforeMethod");
// System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}

 @AfterMethod
public void afterMethod() {
System.out.println("After Method");
driver.close();
}

 @BeforeClass
public void beforeClass() {
System.out.println("Before Class");
System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\chromedriver\\chromedriver.exe");
}

 @AfterClass
public void afterClass() {
System.out.println("After Class");
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