package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//login page for the functions declared in WebUtils class.
// step 1 create login page
public class LoginPage {

	public static void main(String[] args) {
		// step 2, setup the driver

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		// step 3 get the url link
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		String title = driver.getTitle();
		System.out.println("the title of the page is:" + title);

		// Or
		// System.out.println("the title of the page is:" + driver.getTitle());
		// or simple
		// System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		// step 4, declare the variables and values using the By locators
		By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirm = By.id("input-confirm");
		By privacy = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
		By Continue = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		By Login = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");

		// Step 5 , initiate an object ref of the class, where the functions are
		// declared
		// here its ElementsUtil class

		ElementUtil eleutil = new ElementUtil(driver);

		// step 6, call the functions using the obj reference.
		eleutil.doSendKeys(firstname, "Sri");
		eleutil.doSendKeys(lastname, "M");
		eleutil.doSendKeys(email, "sri11@email.com");
		eleutil.doSendKeys(telephone, "87546788");
		eleutil.doSendKeys(password, "sri111");
		eleutil.doSendKeys(confirm, "sri111");
		eleutil.doClick(privacy);
		eleutil.doClick(Continue);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		/**
		 * i am also adding another webpage returning customer page here, to check if i
		 * can test multiple webpages on the same code.
		 */

	driver.get("https://demo.opencart.com/index.php?route=account/login");
		eleutil.doSendKeys(email, "sri1@email.com");
		eleutil.doSendKeys(password, "sri111");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		eleutil.doClick(Login);

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		// Step 7, close or quit the browser(optional)
		//driver.close();
		
		
	}

}
