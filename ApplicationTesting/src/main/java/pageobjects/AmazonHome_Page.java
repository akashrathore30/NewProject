package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonmethods.Wait;

public class AmazonHome_Page {
	private WebDriver driver;
	private WebElement loginbutton;
	
	private Logger loger;
	
	@FindBy(xpath="//a[@id='nav-link-accountList']/span[1]")
	
	private WebElement HomePageLoggedInUserName;
	@FindBy(id="nav-recently-viewed")
	private WebElement BrowsingHistoryLink;
	
	@FindBy(xpath="//a[contains(text(),'Amazon.com')]")
	private WebElement AmazonDotcomLink;
	 
	@FindBy(xpath="//div[@id='nav-xshop']/a[3]")
	private WebElement TodaysDealsLink;
	
	@FindBy(xpath="//div[@id='nav-xshop']/a[4]")
	private WebElement GiftCardAndRergistryLink;
	
	@FindBy(xpath="//div[@id='nav-xshop']/a[5]")
	private WebElement SellLink;
	
	@FindBy(xpath="//div[@id='nav-xshop']/a[6]")
	private WebElement HelpLink;
	
	public AmazonHome_Page(WebDriver driver, Logger loger){
		this.driver=driver;
		this.loger=loger;
		loger.info("constructor called");
	  PageFactory.initElements(driver, this);
		
	}
	
	public String Get_Loggedin_UserName(){
		Wait.WaitForElement(driver, HomePageLoggedInUserName);
		
		//return the login username text 
		
		return HomePageLoggedInUserName.getText();
	}
	
	public boolean Get_BrowserHistory_Link_Presence(){
		Wait.WaitForElement(driver, BrowsingHistoryLink);
		
		return BrowsingHistoryLink.isDisplayed(); 
	}
	
	public boolean Get_AmazonDotCom_Link_Presence(){
		
        Wait.WaitForElement(driver, AmazonDotcomLink);
		
		return AmazonDotcomLink.isDisplayed();
	}
	
	public boolean Get_TodaysDeals_Link_Presence(){
        Wait.WaitForElement(driver, TodaysDealsLink);
		
		return TodaysDealsLink.isDisplayed();
	}
	
	public boolean Get_GiftCardAndRegistry_Link_Presence(){
        Wait.WaitForElement(driver, GiftCardAndRergistryLink);
		
		return GiftCardAndRergistryLink.isDisplayed();
	}
	public boolean Get_Sell_Link_Presence(){
        Wait.WaitForElement(driver, SellLink);
		
		return SellLink.isDisplayed();
	}
	public boolean Get_Help_Link_Presence(){
        Wait.WaitForElement(driver, HelpLink);
		
		return HelpLink.isDisplayed();
	}
}
