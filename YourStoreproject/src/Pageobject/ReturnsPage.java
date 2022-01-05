package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnsPage {
	public WebDriver driver;
		public ReturnsPage(WebDriver driver) {
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
		@FindBy(id="input-order-id")
		WebElement orderid;
		@FindBy(id="input-product")
		WebElement product;
		@FindBy(id="input-model")
		WebElement input;
		
		@FindBy(xpath=("((//input[@name='return_reason_id'])[3])"))
		WebElement reason;
		@FindBy(xpath=("//input[@name='opened']"))
		WebElement name;
        @FindBy(id="input-comment")
        WebElement comment;
        @FindBy(xpath=("//input[@value='Submit']"))
        WebElement submit;
        public void enterFirstName(String fname) {
        	firstname.clear();
        	firstname.sendKeys(fname);
        }
        
        public void enterlastName(String lname) {
        	lastname.clear();
        	lastname.sendKeys(lname);
        }
        public void enterEmail(String mail) {
        	email.clear();
        	email.sendKeys(mail);
        }
        public void enterTelephone(String phonenumber) {
        	telephone.clear();
        	telephone.sendKeys(phonenumber);
        }
        public void enterID(String order) {
        	orderid.clear();
        	orderid.sendKeys(order);
        }
        public void enterProduct(String goods) {
        	product.clear();
        	product.sendKeys(goods);
        }
        public void enterReason(String explanation) {
        	reason.clear();
        	reason.sendKeys(explanation);
        	
        }
        public void enterCondition(String condition) {
        	name.clear();
        	name.sendKeys(condition);
        }
        
        public void enterComment(String detail) {
        	comment.clear();
        	comment.sendKeys(detail);
        }
        public void clickSubmit(String end) {
        	submit.clear();
        	submit.sendKeys(end);
        }
        
}