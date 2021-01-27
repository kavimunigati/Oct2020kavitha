package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAndReturnCustomer {

	public static void main(String[] args, WebDriver driver) {
		/**instead of setting up the driver, we are just
		creating the object of driver created in 
		WebDriverFactory class*/
		
		WebDriverFactory wf =new WebDriverFactory();
		wf.intializedriver("edge");
		wf.launchurl("https://demo.opencart.com/index.php?route=account/register");
		wf.gettitle();
		wf.launchurl("https://demo.opencart.com/index.php?route=account/login");;
	    wf.gettitle();
	    
	    By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
	    By password =By.id("input-password");
	    By confirm =By.id("input-confirm");
	    By privacy = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
	    By Continue = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
	    By Login = By.xpath( "//*[@id=\"content\"]/div/div[2]/div/form/input");
		
	    ElementUtil eleutil = new ElementUtil(driver);
	    
	    eleutil.doSendKeys(firstname, "Sri");
		eleutil.doSendKeys(lastname, "M");
		eleutil.doSendKeys(email, "sri1@email.com");
		eleutil.doSendKeys(telephone, "87546788");
		eleutil.doSendKeys(password, "sri111");
		eleutil.doSendKeys(confirm, "sri111");
		eleutil.doClick(privacy);
		eleutil.doClick(Continue);
		
		
		
		eleutil.doSendKeys(email, "sri1@email.com");
		eleutil.doSendKeys(password, "sri111");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		eleutil.doClick(Login);
		
		
	    
	    
	    
	    
	}

}
