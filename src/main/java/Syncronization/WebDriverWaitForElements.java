package Syncronization;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumSessions.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitForElements {
	// WebDriver wait for multiple webelements
	 static WebDriver driver;
	 
	//creating a generic method for visibility of all the elements
	 public static List<WebElement> VisibilityOfAllElements(By locator, int TimeOut) {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	 }
	
	 // we are replacing void with List<WebElement> as wait.until has a return type
	 // This method works exactly as get the List<WebElement>, but it has wait applied to it, so it waits fo the 
	 //elements to appear for given amount of time and then responds.
	 
	 
	public static void main(String[] args) {
	 WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("https://www.freshworks.com/");
	
	//creating By locator for the list of Webelements from the footer link
	 By footerlinks =By.cssSelector("ul.footer-nav li a");

	 /**Method 1
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	 List<WebElement> FooterList =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerlinks));
	 // now we want to print the list of elements present in footerlink
	 // using the streams we will iterate
	 
	 FooterList.stream().forEach(ele -> System.out.println(ele.getText()));
	 **/
	 
	 //Methos 2 by calling the functions
	 ElementUtil eleutil = new ElementUtil(driver);
	 eleutil.VisibilityOfAllElements(footerlinks, 10);
	 
	 // to print all the elements
	 eleutil.getPageElementsText(footerlinks, 10);
	 
	 
	 
		

	}

}
