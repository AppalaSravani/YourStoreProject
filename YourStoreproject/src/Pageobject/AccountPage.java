package Pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
public WebDriver driver;
public AccountPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(linkText="Logout")
WebElement logout;
public void clickLogout(){
driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
logout.click();

}
}