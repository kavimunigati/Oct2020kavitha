package SeleniumSessions;

import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllScriptsFooter {
 static WebDriver driver;
 
 public static WebElement getElement(By Locator) {
		return driver.findElement(Locator);
 }
 public static void doSendKeys(By locator, String value) {
	getElement(locator).sendKeys();
 }
 
 public static void doClick(By locator) {
	getElement(locator).click();
 }
	 
	 
 
	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();

 driver.get("http://www.allscripts.com/");
 String title =driver.getTitle();
 System.out.println("the title of the page:" + title);
 System.out.println(driver.getCurrentUrl());

 ElementUtil eleutil= new ElementUtil(driver);//1.create an object of the elementutil
 
 //2. extract the x path and  to get elementswhose return type is List<WebElements>
  List<WebElement> scripts= eleutil.getElements(By.xpath("//div[@class='menu-footer-2-product-column-container']//a"));
 
 System.out.println(scripts.size());// to print the no of elements in the list
 //iterate the webElements to print the list of the footer elements
 for(WebElement s : scripts) {
	System.out.println(s.getText()); 
 }
 
 
 
 

	}

}
