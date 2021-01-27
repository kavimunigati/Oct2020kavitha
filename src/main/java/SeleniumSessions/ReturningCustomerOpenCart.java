package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReturningCustomerOpenCart  {
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
		
		//performing action for the web element created
		//By class followed by Locator: adding input value 
		//Initializing the locator variables, using the By class followed by locators
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		By email = By.id("input-email");
		By password =By.id("input-password");
		By Login = By.xpath( "//*[@id=\"content\"]/div/div[2]/div/form/input");
		
		
		doSendKeys(email, "Kavi11@gmail.com");
		doSendKeys(password, "Kavi877");
		doClick(Login);
		

	}

}
