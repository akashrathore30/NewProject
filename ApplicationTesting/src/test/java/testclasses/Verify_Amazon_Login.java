package testclasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonmethods.DataRead;

import browsers.DriverType;

import pageobjects.AmazonHome_Page;
import pageobjects.AmazonSignIn_Page;
import pageobjects.Amazon_Page;
import pageobjects.AmazonHome_Page;

public class Verify_Amazon_Login {
	public WebDriver driver;
	public Amazon_Page amazonpage;
	public Logger loger;
	public String TestCase="Verify_Amazon_Login";
	public AmazonHome_Page homepage;
	public AmazonSignIn_Page amazonsigninpage;
	public AmazonHome_Page amazonhomepage;



	/*public void setup(){
		System.out.println("inside setup");
		loger=Logger.getLogger(Verify_Amazon_Login.class);
		loger.info("before");
		driver=DriverType.ReturnDriverObject();
		
		amazonpage= new Amazon_Page(driver, loger);
		
		
	}*/

	@BeforeSuite
	public void Hit_Amazon(){
		loger=Logger.getLogger(Verify_Amazon_Login.class);
		loger.info("before");
		//inetiale the driver
		driver=DriverType.ReturnDriverObject();
		//invoke the url on browser returned
		
		driver.get(DataRead.ReadExcelData("Application URL", "Verify_Amazon_Login"));
		System.out.println("before opening");
		amazonpage= new Amazon_Page(driver, loger);	
	}

	@BeforeTest
	public void Verify_Login(){
		//verify presence of login page
		System.out.println("inside test");
		//boolean value= amazonpage.CheckAmazonPageIsPresence();
		if (amazonpage.CheckAmazonPageIsPresence()) {
			System.out.println("Amazon Page is opened successfully");
			loger.info("amazon page succesfffuly present");
		}
		else
		{
			Assert.assertTrue(amazonpage.CheckAmazonPageIsPresence());
		}
		
		// click on sign in button
		
		amazonsigninpage=amazonpage.ClickSignInButtonOnAmazonPage();
		//verify presence of sign in page
		
		if(amazonsigninpage.Verify_SignIn_Page_Presence()){
			loger.info("sign in page is displayed successfully");
			//enter username and password
			
			amazonsigninpage.Enter_Username("UserName", "Verify_Amazon_Login");
			amazonsigninpage.Enter_Password("Password", "Verify_Amazon_Login");
			
			//click on sign in button
			amazonhomepage=amazonsigninpage.ClickSignInButton();
			
			//verify username on amazon home page
			String loginusername=amazonhomepage.Get_Loggedin_UserName();
			
			//verify presence of username on home page 
			Assert.assertEquals(loginusername.trim(), DataRead.ReadExcelData("UserName On HomePage", "Verify_Amazon_Login"));
			amazonhomepage.Get_AmazonDotCom_Link_Presence();
			System.out.println(amazonhomepage.Get_AmazonDotCom_Link_Presence());
		}
		
		else
		{
			Assert.assertTrue(amazonsigninpage.Verify_SignIn_Page_Presence());
			loger.info("sign in page is not displayed successfully");
		}
		
	}
	/*public void setup(){
		System.out.println("inside setup");
		loger=Logger.getLogger(Verify_Amazon_Login.class);
		loger.info("before");
		driver=DriverType.ReturnDriverObject();
		
		amazonpage= new Amazon_Page(driver, loger);
		
	}*/

	}
