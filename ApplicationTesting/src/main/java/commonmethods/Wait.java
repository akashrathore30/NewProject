package commonmethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void WaitForElement(WebDriver driver,WebElement element){
		
		WebDriverWait wait= new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
