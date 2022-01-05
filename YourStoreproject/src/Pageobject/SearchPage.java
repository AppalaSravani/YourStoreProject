package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage {

public WebDriver driver;
public SearchPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//*[@id='search']/input")
WebElement srh;

@FindBy(xpath="//*[@id=\"search\"]/span/button")
WebElement srhbtn;




public void enterProductName(String pname){
srh.clear();
srh.sendKeys(pname);
}

public void clicksrhbutton()
{
srhbtn.click();
}

}