package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().window().maximize();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

//		String fn = driver.findElement(By.id("Form_submitForm_FirstName")).getAttribute("name");
//		String privay_policy_url = driver.findElement(By.linkText("Privacy Policy")).getAttribute("href");
//
//		System.out.println(fn);
//		System.out.println(privay_policy_url);

		By firstName = By.id("Form_submitForm_FirstName");
		By privacyPolicyLink = By.linkText("Privacy Policy");

		String nameAttr = doGetAttribute(firstName, "name");
		String privacy_url = doGetAttribute(privacyPolicyLink, "href");

		System.out.println(nameAttr);
		System.out.println(privacy_url);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static String doGetAttribute(By locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);
	}

}
