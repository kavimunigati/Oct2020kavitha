package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCssSelector {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		// my reqid=s I want to check if the websites login form has all the elements displayed
		// weareusing a comma in cssselector to find the presenceof all the elements
		
		driver.get("https://login.salesforce.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
By loginFormLocators = By.cssSelector("input#username, input#password,"
		+ "   input#login,  input.r4 fl mr8,  a#forgot_password_link,  a#mydomainLink");
		 int loginFormelementsCount = driver.findElements(loginFormLocators).size();
		 
		 if(loginFormelementsCount ==4) {
			 System.out.println(" all the elements are present on the screen");
			 //its considering  un, pw, login and remember me only as WebElements
			 // and not the forgot password and usedomain custom links.
		 }
		
		 else {
			 System.out.println("Not all elements present");
		 }
	
 
		 
}
}
