package testclasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.AmazonHome_Page;

import browsers.DriverType;

public class Verify_Grid_On_Amazon_HomePage  {
	
public WebDriver driver;
public Logger loger;
public AmazonHome_Page amazonhomepage;
	
	
	
	@BeforeClass
	public void Current_Class_Setup(){
		//create driver instance and instantiate and inetialize the required page classes
		driver=DriverType.ReturnDriverObject();
		loger=Logger.getLogger(Verify_Grid_On_Amazon_HomePage.class);
		amazonhomepage=new AmazonHome_Page(driver,loger);
		
		
		
	}
	
	@Test(priority=0)
	public void Verify_LeftPan_Grids(){
		
		
		//verify presence of amazon dot com link
		//driver.get("www.gmail.com");
		System.out.println("*************************************************");
		System.out.println(amazonhomepage.Get_AmazonDotCom_Link_Presence());
	Assert.assertTrue(amazonhomepage.Get_AmazonDotCom_Link_Presence());
	
	
	
	//verify presence of todays deals link
	
	Assert.assertTrue(amazonhomepage.Get_TodaysDeals_Link_Presence());
	
	//verify gift card and registry link
	
	Assert.assertTrue(amazonhomepage.Get_GiftCardAndRegistry_Link_Presence());
	
	//verify sell link 
	Assert.assertTrue(amazonhomepage.Get_Sell_Link_Presence());
	
	//verify help link 
	
	Assert.assertTrue(amazonhomepage.Get_Help_Link_Presence());
	
	//verify browser history link
	Assert.assertTrue(amazonhomepage.Get_BrowserHistory_Link_Presence());
	}
	
}
