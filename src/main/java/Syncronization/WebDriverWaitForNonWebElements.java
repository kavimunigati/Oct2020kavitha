package Syncronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumSessions.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitForNonWebElements {
	static WebDriver driver;
	
	// creating a generic method and copied the same to elementutil package.
	public static boolean waitForURLToBe(String urlValue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);	
		return wait.until(ExpectedConditions.urlContains(urlValue));
		
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get("https://www.dollartree.com/");
		By QuickOrder = By.xpath("//span[text()='Catalog Quick Order']");
		 ElementUtil eleutil= new ElementUtil(driver);
		 //eleutil.waitForElementPresent(locator, timeout)
		 eleutil.waitForElementPresent(QuickOrder, 20).click();
		 
		 // Checking the url has Catalog quick order in it.
		 // so, creating a wait to url
		 
	/*	 WebDriverWait wait = new WebDriverWait(driver,25);
		// wait.until(isTrue)
	//wait.until(ExpectedConditions.urlContains(fraction))
		 boolean flag = wait.until(ExpectedConditions.urlContains("catalog-quick-order"));
		 System.out.println(flag);*/
		 
		 // calling from the element util pckage
		// eleutil.waitForURLToBe(urlValue, timeout)
		 // we can call the same from local method or function  aswell.
		 
		 if (eleutil.waitForURLToBe("catalog-quick-order", 10)) {
			 System.out.println("Correct quick order  Url");
		 }
		 
		 eleutil.waitForTitletoBe("Rediff", 5);
	}

}
