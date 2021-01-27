package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException   {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://www.spicejet.com/");
System.out.println(driver.getCurrentUrl());
System.out.println(driver.getTitle());
//find the driver element by locator
 //move the locator for sub menu
 
 /*WebElement menulist =driver.findElement(By.id("ctl00_HyperLinkLogin"));
 Actions act_obj = new Actions(driver);
 act_obj.moveToElement(menulist).perform();
 driver.findElement(By.linkText("SpiceClub Members")).click();
 WebElement submenulist = driver.findElement(By.linkText("SpiceClub Members"));
 System.out.println(driver.getCurrentUrl());
act_obj.moveToElement(submenulist).perform();
  driver.findElement(By.linkText("Sign up")).click();
  System.out.println(driver.getCurrentUrl());*/

By Login =By.id("ctl00_HyperLinkLogin");
By SpiceClub_Members = By.linkText("SpiceClub Members");
	By memberLogin = By.linkText("Member Login");
	
	ElementUtil eleutil = new ElementUtil(driver);
	eleutil.doMoveToElement(Login);
	Thread.sleep(2000);
	eleutil.doMoveToElement(SpiceClub_Members);
	Thread.sleep(2000);
	eleutil.doMoveToElement(memberLogin);
	eleutil.doActionsClick(memberLogin);
	
	 


	
}

	
}

