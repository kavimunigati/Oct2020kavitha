package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	
	//approach 4. ctreating a function.
	//Creating a web element with a function
	//getElement method is responsible for calling the webelement for any other methods created after wards.
	static WebDriver driver; //we are creating a  static webderiver so that we can use this any where inside the programme.
	private static By submitBtn;
	
	public static WebElement getElement(By Locator) {// we have replaced void with WebElement as the return type of find element is webelement.
		                                             // we have to provide the By locator to the  getelement, which in turn givesthe web element.
		
		return driver.findElement(Locator);
	}
	
	//Approach 5 using the do click and do send keys method.
	 public static void doClick(By Locator) {
		 getElement(Locator).click();
	 }
	 public static void doSendKeys(By Locator, String value) {
		 getElement(Locator).sendKeys(value);
	 }
	 
	
	
	
	
	public static void main(String[] args) {
		//We are importing the webdriver manager util from import io.github.bonigarcia.wdm.WebDriverManager;
		//which is not a selenium import from from git hub
		//ones we do this we do not have to deal with compatability issues pertaining to exe files and browsers
		//when we enter the WebDriverManager.chromedriver().setup();, the sepup is going to take care of the path 
		
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver = new EdgeDriver();
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
	//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
		//creating a webelment by using the selenium defined method called
		//driver.(FindElement)
		//" By" is a class to locate a web element
		// the standard rule is create a web element(by uning some locator) and perform action on it like click, sendkeys, gettext etc
		
		//there are multiple ways of creating a web element
		//Method ot type 1, by using the driver.(findElement) way.
		//driver.findElement(By.id("input-firstname")) hetre we are creating web element
		//.sendKeys("Kav"); this is performing action
	/**	driver.findElement(By.id("input-firstname")).sendKeys("Kav");
		driver.findElement(By.id("input-lastname")).sendKeys("Mun");
		driver.findElement(By.id("input-email")).sendKeys("kavi@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("130985643");
		driver.findElement(By.id("input-password")).sendKeys("pw111");
		driver.findElement(By.id("input-confirm")).sendKeys("pw111");
		*/
		
		//Type2 in this type , we can creating  a weblement only ones and can perform action any number of times. (resubality)
		
		//driver.findElement(By.id("input-firstname"));// when mouse over the findelement. we see it is returning webelementso we store in web element
		/**WebElement firstname = driver.findElement(By.id("input-firstname"));//Creating a web element
		   WebElement lastname = driver.findElement(By.id("input-lastname"));	
		
		firstname.sendKeys("kavi");// performing action
		lastname .sendKeys("muni");
		*/
		
		//approach 3, by using the "By" locator
		//the advantage of this method is just by maintaining the By loactor, we are not hitting the server  at all
		
		//By.id("input-firstname");// when we mouse over the id, it  is returning By class, we store the id  in by class reference object
		By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
	    By password =By.id("input-password");
	    By confirm =By.id("input-confirm");
	
	/**	driver.findElement(firstname).sendKeys("Kavi");
		driver.findElement(lastname).sendKeys("muni");
		driver.findElement(email).sendKeys("Kavi@gmail.com");
		driver.findElement(telephone).sendKeys("1230987465");
		driver.findElement(password).sendKeys("pw111");
		driver.findElement(confirm).sendKeys("pw111");
		*/
		
		//approach 4, using a Function.we have to create a function out side of the main method, as we cannot create a function in a function.
		// we will be using the By locator using in approach 3
		// we are performing the action for the getElement function created for creating web element
		
		 getElement(firstname).sendKeys("kavitha");
		 getElement(lastname).sendKeys("muni");
		 getElement(email).sendKeys("kavitha@yahoo.com");
		 getElement(telephone).sendKeys("1230987465");
		 getElement(password).sendKeys("pw111");
		 getElement(confirm).sendKeys("pw111");
			
		
		//Approach 5: performing action
		 doSendKeys(firstname, "Kavi");
			doSendKeys(lastname, "Muni");
			doSendKeys(email, "Kavi@gmail.com");
			doSendKeys(telephone, "987543669");
			doSendKeys(password, "Kavi877");
			doSendKeys(confirm, "Kavi877");
			doClick(submitBtn);
			
			
		
		
		
		
}
}	
	
