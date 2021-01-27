package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class authenticationPopup {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
 /* 
  * Selenium cannot handle the file upload and authintication pop ups, so, 
  * in this type of pop up, we have to give the credentials of user name and password along with the url
  * say user name =admin, password=admin and @ is like adding to the url
  * url - the-internet.herokkuapp.com/basic_auth
  * now this will not give any pop ups and the page opens.
  */
driver.get("https://admin:admin@the-internet.herokkuapp.com/basic_auth");

	}

}
