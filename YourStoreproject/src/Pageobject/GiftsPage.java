package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftsPage {
	public WebDriver driver;
	public GiftsPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(name="to_name")
	WebElement recipientname; 
	@FindBy(name="to_email")
	WebElement recipientmail;
	@FindBy(name="from_name")
	WebElement name;
	@FindBy(name="from_email")
	WebElement email;
	@FindBy(xpath="//input[@value='8']")
	WebElement theme;
	@FindBy(id="input-message")
	WebElement mess;
	
	@FindBy(id="input-amount")
	WebElement amou;
	
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkbox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement button;
     public void enterReceName(String recipiname  ) {	
    	 recipientname.clear();
    	 recipientname.sendKeys(recipiname );
     }
     public void enterReceEmail(String recipiemail  ) {	
    	 recipientmail.clear();
    	 recipientmail.sendKeys(recipiemail );
     }
     public void enterYourName(String urname   ) {	
    	 name.clear();
    	 name.sendKeys(urname );
     }
    
    	 public void enterYourMail(String uremail) {	
        	 email.clear();
        	 email.sendKeys(uremail );
     }
    	 public void giftCertificateTheme(String urtheme) {
			WebElement radioEle = driver.findElement(By.xpath("//input[@value='7']"));
			WebElement radioEle1 = driver.findElement(By.xpath("//input[@value='6']"));
			WebElement radioEle2 = driver.findElement(By.xpath("//input[@value='8']"));
			String b = "Birthday";
			String c="christmas";
			String g="General";
			if(b.equals(urtheme)) {
    			boolean select = radioEle.isSelected();
    			System.out.print(select);
    			// performing click operation if element is not already selected
    			if (select == false) {
    				radioEle.click();
    			}
			}
			else if(c.equals(urtheme)) {
    			boolean select = radioEle1.isSelected();
    			System.out.print(select);
    			// performing click operation if element is not already selected
    			if (select == false) {
    				radioEle1.click();
    			}
			}
			else if(g.equals(urtheme)){
    			boolean select = radioEle2.isSelected();
    			System.out.print(select);
    			// performing click operation if element is not already selected
    			if (select == false) {
    				radioEle2.click();
    			}
			}
			else {
				theme.clear();
			}
    	 }
    		

    	 public void enterUrMes(String urmessage) {	
        	 mess.clear();
    		 //JavascriptExecutor js = (JavascriptExecutor) driver;
    		 //js.executeScript("var x=document.getElementById('input-amount');x.value=56;");
        	 mess.sendKeys(urmessage );
    	 }
    	 public void enterAmou(String uramoun) {
    		amou.clear();
    		JavascriptExecutor js = (JavascriptExecutor) driver;
   		 js.executeScript("var x=document.getElementById('input-amount');x.value=200;");
    		//x=document.getElementById("input-amount");
    		//x.value=56;
    	amou.sendKeys(uramoun);
    	}
    	
    	 public void clickcheckbox() {
    		 checkbox.click();
    	
    	 }
    	 public void clickbutton() {
    		 button.click();
    	
    	 }
}