package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCardDemoRegisterPage {

	
	static WebDriver driver;// declaring Static WebDriver Ref
	
	/**we have replaced void with WebElement as the return type of find element is webelement.
   we have to provide the By locator to the  getElement, which in turn gives the web element.*/
//creating a web element
	//Using Generic functions
	
	public static WebElement getElement(By Locator) {
		 return driver.findElement(Locator);
	 }
	 public static void doClick(By Locator) {
		 getElement(Locator).click();
	 }
	 public static void doSendKeys(By Locator, String value) {
		 getElement(Locator).sendKeys(value);
	 }
	 
	 
	public static void main(String[] args ) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://demo.opencart.com/index.php?route=account/register");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	
	
	//performing action for the web element created
	//ByLocator: adding input value 
	By firstname = By.id("input-firstname");
	By lastname = By.id("input-lastname");
	By email = By.id("input-email");
	By telephone = By.id("input-telephone");
    By password =By.id("input-password");
    By confirm =By.id("input-confirm");
   
    		
    		
    
   /**  getElement(firstname).sendKeys("kavitha");
	 getElement(lastname).sendKeys("muni");
	 getElement(email).sendKeys("kavitha@yahoo.com");
	 getElement(telephone).sendKeys("1230987465");
	 getElement(password).sendKeys("pw111");
	 getElement(confirm).sendKeys("pw111");*/
		
	
		doSendKeys(firstname, "Kavi");
		doSendKeys(lastname, "Muni");
		doSendKeys(email, "Kavi@gmail.com");
		doSendKeys(telephone, "987543669");
		doSendKeys(password, "Kavi877");
		doSendKeys(confirm, "Kavi877");
		
		
		

	}

}
