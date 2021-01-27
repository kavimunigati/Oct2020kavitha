package Syncronization;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import SeleniumSessions.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
static WebDriver driver;

// creating generic method
// This method is checking the presence using the fluent wait
public static void waitForElementWithFluentWait(By locator, int timeOut, int pollingTime ) {
	Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))//maximum time out
			.pollingEvery(Duration.ofSeconds(2))//sending time to check every 2 seconds i.e...,polling time
			.ignoring(NoSuchElementException.class)// while doing the other if there is any no element exception ignore it
			.ignoring(StaleElementReferenceException.class);// ignore stale exception
			
	WebElement ele =  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	ele.click();
}




	public static void main(String[] args) {
/* The Fluent Wait in Selenium is used to define maximum time for the web driver to wait for a condition,
 *  as well as the frequency with which we want to check the condition before throwing an 
 *  "ElementNotVisibleException" exception. It checks for the web element at regular intervals until the object
 *   is found or timeout happens.TODO Auto-generated method stub
*/
		 WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.get("https://classic.crmpro.com/");
			
			By forgotPwd = By.partialLinkText("Forgot Password");
			By username =By.cssSelector("input[name='username']");
			By password = By.cssSelector("input[name='password']");
			By login = By.cssSelector("input[type='select']");
					
			By button =By.partialLinkText("Write a reply");
 //Fluentwait is a class which implements wait Interface, so we are creating a Object of Fluent wait class
			//new FluentWait();
			//Wait is an interface, as acnnot createthe object of a Interface
			// we are topcasting the parent interface to create an objext of Wait and referring as wait
			//and Generic of <WebDriver> must be given on both the sides
			// and give driver reference as a constructor
			// the below is the fluent wait created with all the conditions
			
	/**Method 1
			Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(10))//maximum time out
		.pollingEvery(Duration.ofSeconds(2))//sending time to check every 2 seconds i.e...,polling time
		.ignoring(NoSuchElementException.class)// while doing the other if there is any no element exception ignore it
		.ignoring(StaleElementReferenceException.class);// ignore stale exception
			 
	
	WebElement ele =  wait.until(ExpectedConditions.presenceOfElementLocated(forgotPwd));
	ele.click();
	 **/
			
	//method2 by calling the function
			
			//waitForElementWithFluentWait(forgotPwd, 10, 2);
			
		
		ElementUtil eleutil = new ElementUtil(driver);
	
		//eleutil.doSendKeys(username, "batchautomation");
		//eleutil.doSendKeys(password, "test@12345");
		eleutil.waitForElementVisible(button, 10);
		
		
	}

}
