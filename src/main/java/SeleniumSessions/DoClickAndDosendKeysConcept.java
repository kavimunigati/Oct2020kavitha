package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoClickAndDosendKeysConcept {
	static WebDriver driver;
	
	 public static WebElement getElement(By Locator) {
		 return driver.findElement(Locator);
	 }
	 //calling one method into another concept in java
	 // here we are calling getelement method into doclick method and dosendkeys methods.
	 public static void doClick(By Locator) {
		 getElement(Locator).click();
	 }
	 public static void doSendKeys(By Locator, String value) {
		 getElement(Locator).sendKeys(value);
	 }
			
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//performing action for the web element created
		
		//By class followed by Locator: adding input value 
		//Initializing the locator variables, using the By class followed by locators
		
		By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
	    By password =By.id("input-password");
	    By confirm =By.id("input-confirm");
	    By privacy = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
	    By Continue = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
	    
	    doSendKeys(firstname, "Kavi");
		doSendKeys(lastname, "Munigati");
		doSendKeys(email, "Kavi11@gmail.com");
		doSendKeys(telephone, "987543669");
		doSendKeys(password, "Kavi877");
		doSendKeys(confirm, "Kavi877");
		doClick(privacy);
		doClick(Continue);
		
	}

}
