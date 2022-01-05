package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-firstname")
	WebElement firstname;
	@FindBy(id="input-lastname")
	WebElement lastname;
	@FindBy(id="input-email")
	WebElement email;
	@FindBy(id="input-telephone")
	WebElement telephone;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(id="input-confirm")
	WebElement confirmpassword;
	@FindBy(xpath="//label[@class='radio-inline']")
	WebElement yesradio;
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkbox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement conbut;
	
	public void enterfirstname(String fname){
		firstname.clear();
		firstname.sendKeys(fname);
	}
	public void enterlastname(String lname){
		lastname.clear();
		lastname.sendKeys(lname);
	}
	public void enteremail(String mail){
		email.clear();
		email.sendKeys(mail);
	}
	public void entertelephone(String tel){
		telephone.clear();
		telephone.sendKeys(tel);
	}
	public void enterpassword(String pwd){
		password.clear();
		password.sendKeys(pwd);
	}
	public void enterconfirmpassword(String conpwd){
		confirmpassword.clear();
		confirmpassword.sendKeys(conpwd);
	}
	public void clickyesradio(){
		
		
			yesradio.click();
			
	}
	public void clickcheckbox(){
		
			checkbox.click();
		
			

		}
	public void clickconbutton(){
		conbut.click();

	}
	
}
