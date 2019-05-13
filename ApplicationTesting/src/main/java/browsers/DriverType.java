package browsers;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import commonmethods.PropertyFile;

public class DriverType {
//public static WebDriver driver;
	
		//public static WebDriver driver;
		public static Properties p;
		public static WebDriver driver;
		public static String BrowserName;
		

		public static WebDriver ReturnDriverObject(){
			
			p=PropertyFile.PropertFileObject();
			BrowserName=p.getProperty("Browser");
			
			if(BrowserName.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.driver","C:/eclipse/geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
			
			else if(BrowserName.equalsIgnoreCase("Chrome")){
				driver = new ChromeDriver();
			}
			
			else{
				driver = new InternetExplorerDriver();
			}
			
			
			
			
		
			
			return driver;
			
		}
		
}

