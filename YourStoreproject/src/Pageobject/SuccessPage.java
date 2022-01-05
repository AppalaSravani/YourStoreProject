package Pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {
	public WebDriver driver;
	public SuccessPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public void clickcountinue()
	{
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		driver.get("https://demo.opencart.com/index.php?route=account/register");

	}
}
