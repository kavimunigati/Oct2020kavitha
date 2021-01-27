package TestNgSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	
	/**It is the industry standard that setup means all the pre-conditions and teardown 
	 means, ones the test is done what do you want to do with it. usually quit or close the browser.
	**/
    @Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) {
    	
    	switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Safari":
	    	driver = new SafariDriver();
			break;
		default:
			break;
		}
    			
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
	}
		
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}