package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MethodOverLoadingWithActions {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException   {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://www.spicejet.com/");
System.out.println(driver.getCurrentUrl());
System.out.println(driver.getTitle());

By Login =By.id("ctl00_HyperLinkLogin");
By SpiceClubMembers =By.linkText("SpiceClub Members");
By Memberlogin = By.linkText("Member Login");
 
ElementUtil eleutil = new ElementUtil(driver);
eleutil.doMoveToElement(Login);
eleutil.doMoveToElement(SpiceClubMembers);
eleutil.doMoveToElement(Memberlogin);
eleutil.doActionsClick(Memberlogin);
System.out.println(driver.getCurrentUrl());
System.out.println(driver.getTitle());

driver.close();
	}
	public WebElement getWebelement(By locator) {
		return driver.findElement(locator);
	}
	public void doMoveElement(By locator) {// the function we want to create
		Actions action = new Actions(driver);//action object
		action.moveToElement(getWebelement(locator)).perform();//asking action object to perform an action
	}
public void doActionClick(By locator) {
	Actions action = new Actions(driver);
			action.click(getWebelement(locator)).perform();
}
}
