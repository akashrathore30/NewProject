package pageobjects;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonmethods.Wait;


public class Amazon_Page {
	private WebDriver driver;
	private WebElement loginbutton;
	
	private Logger loger;
	
	@FindBy(xpath="//span[contains(text(),'Amazon')]")
	private WebElement LoginPageAmazonText;
	
	@FindBy(id="nav-link-accountList")
	private WebElement AccountsAndListsButton;
	
	
	public Amazon_Page(WebDriver driver, Logger loger){
		this.driver=driver;
		this.loger=loger;
		loger.info("constructor called");
	  PageFactory.initElements(driver, this);
		
	}
public boolean CheckAmazonPageIsPresence(){
	Wait.WaitForElement(driver, LoginPageAmazonText);
	
	return LoginPageAmazonText.isDisplayed();
	
	}

public AmazonSignIn_Page ClickSignInButtonOnAmazonPage(){
	Wait.WaitForElement(driver, AccountsAndListsButton);
	AccountsAndListsButton.click();
	
	return new AmazonSignIn_Page(this.driver, loger);
	 
	
}


}
