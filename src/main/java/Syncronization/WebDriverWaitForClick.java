package Syncronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumSessions.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitForClick {
static WebDriver driver;


//Creating a generic method for clicking the element 
// we will have void as we are not expecting any return, but just click the element

public static void clickwhenready(By locator, int timeout) {
	WebDriverWait  wait = new WebDriverWait(driver,10);// wait is the reference for WebDriverWait
	WebElement fgtpwd = wait.until(ExpectedConditions.elementToBeClickable(locator));// using ref to locate the element to be clicked
	fgtpwd.click();
	//fgtpwd is the reference using to click a web element 
}

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://classic.crmpro.com/");
	By Forgotpwd = By.linkText("Forgot Password?");
	
	/**Method 1
	 * 
	WebDriverWait  wait = new WebDriverWait(driver,10);
	WebElement fgtpwd = wait.until(ExpectedConditions.elementToBeClickable(Forgotpwd));
	fgtpwd.click();*/

	
	//method 2 by calling the function
	ElementUtil eleutil= new ElementUtil(driver);
	eleutil.clickwhenready(Forgotpwd, 5);
	
	
	}

}
