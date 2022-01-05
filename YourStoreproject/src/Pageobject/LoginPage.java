package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
public LoginPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(id="input-email")
WebElement EMailAddress;
@FindBy(id="input-password")
WebElement pass;
@FindBy(xpath="//input[@value='Login']")
WebElement lgnBtn;
public void enterAddress(String Address){
	EMailAddress.clear();
	EMailAddress.sendKeys(Address);
}
public void enterPwd(String pwd){
pass.clear();
pass.sendKeys(pwd);
}
public void clickLogin()
{
lgnBtn.click();
}

}