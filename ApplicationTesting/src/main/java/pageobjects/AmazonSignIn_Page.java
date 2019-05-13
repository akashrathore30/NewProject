package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonmethods.DataRead;
import commonmethods.Wait;

public class AmazonSignIn_Page {
	private WebDriver driver;

	
	private Logger loger;
	
	@FindBy(xpath="//h1[contains(text(), 'Sign in')]")
	private WebElement SigninPageText; 
	
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement UserNameField;
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement PasswordField;
	
	@FindBy(id="signInSubmit")
	private WebElement SignInButton;
	
	
	
	//call contructor
	public AmazonSignIn_Page(WebDriver driver, Logger loger){
	this.driver=driver;
	this.loger=loger;
	PageFactory.initElements(driver, this);
		
	}           
	
	public boolean Verify_SignIn_Page_Presence(){
		
		Wait.WaitForElement(driver, SigninPageText);
		
		 return SigninPageText.isDisplayed();
		
	}
	
	
	public void Enter_Username(String id,String TestCaseName){
		String userid=DataRead.ReadExcelData(id , TestCaseName);
		Wait.WaitForElement(driver, UserNameField);
		UserNameField.sendKeys(userid);
	}
	
	public void Enter_Password(String password, String TestCaseName){
		String UserPassword=DataRead.ReadExcelData(password , TestCaseName);
		System.out.println("value of password id =="+ UserPassword);
		Wait.WaitForElement(driver, PasswordField);
		
		PasswordField.sendKeys(UserPassword);
		
	}
	
	public AmazonHome_Page ClickSignInButton(){
		Wait.WaitForElement(driver, SignInButton);
		SignInButton.click();
		System.out.println(SignInButton.toString());
		
		return new AmazonHome_Page(this.driver, loger);
	}
}
