package Syncronization;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumSessions.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitConceptForAlerts {
	static WebDriver driver;
	
	//creating Generic method and moving to elementutil
	public static Alert waitforAlert(int timeout){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return  wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi/");
		 By signinButton = By.name("proceed");
		 ElementUtil eleutil = new ElementUtil(driver);
		 eleutil.waitForElementPresent(signinButton, 10).click();
	
		/* WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert =   wait.until(ExpectedConditions.alertIsPresent());
		 System.out.println(alert.getText());// Please enter a valid username is printed
		 alert.accept();*/
		
		 //callig the JS alert from elementutil and executing
		 eleutil.acceptJSAlert(5);
		 
		
	}

}
