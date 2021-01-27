
package Syncronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webDriverwait {
static WebDriver driver;


public static WebElement getElement(By locator) {
	return driver.findElement(locator);
}
/** Preseece of elementlocated
 * An expectation for checking that an element is present on the DOM of a page.
 *  This does not necessarily mean that the element is visible.
 * @param locator
 * @param timeout
 * @return
 */

public static WebElement waitForElementPresent(By locator, int timeout) {
WebDriverWait wait = new WebDriverWait(driver,timeout);
return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}
/**
 * An expectation for checking that an element, known to be present on the DOM of a page, is visible.
 *  Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
 * @param locator
 * @param timeout
 * @return
 */
public static WebElement waitForElementVisible(By locator, int timeout) {
WebDriverWait wait = new WebDriverWait(driver,timeout);
return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
}

	public static void main(String[] args) {
		
		//wait ----> is an interface
		//1. WebDriverWait (class)  ectends 2.FluentWait(Class)
		//these two put together is called Explicit wait
		//Wait is a functional Interface which means, which has only one method ___> SAM pattern
		//SingleAbstractMethod..
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
			
	driver.get("https://classic.crmpro.com/");
	By username = By.name("username");
		By password = By.name("password");
		By loginButton = By.xpath("//input[@value='Login']");
		
/*WebDriverWait wait = new WebDriverWait(driver,10); //import fromselenium 
//wait.until(ExpectedConditions.presenceOfElementLocated(username));// returns Webelement to adding Webelement in next tine
		WebElement username_ele =wait.until(ExpectedConditions.presenceOfElementLocated(username));
		username_ele.sendKeys("batchautomation");// we are applying the wait only on one element that is username
		driver.findElement(password).sendKeys("Test@12345");
		driver.findElement(loginButton).click();
		
In this WebDriverwait example, wait for the amount of time defined in the "WebDriverWait" class
or the "ExpectedConditions" to occur whichever occurs first.
The above Java code states that we are waiting for an element for the time frame 
of 10 seconds as defined in the "WebDriverWait" class on the webpage until the "ExpectedConditions" 
are met and the conditions are "presenceOfElementLocated" or "visibilityofElementLocated".

PresenceOfElement:
	An expectation for checking that an element is present on the DOM of a page. 
	This does not necessarily mean that the element is visible.
		*/
		
waitForElementPresent(username, 10).sendKeys("batchautomation");// creating the element with webDriverWait unlike driver.findelement
driver.findElement(password).sendKeys("Test@12345");
driver.findElement(loginButton).click();
		
		
		//OR
						
	/*	waitForElementVisible(username, 5).sendKeys("batchautomation");
		driver.findElement(password).sendKeys("Test@12345");
		driver.findElement(loginButton).click();*/
		
		
		
		
		
		
	}

}
