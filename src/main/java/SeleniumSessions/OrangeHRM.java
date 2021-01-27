package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		

		// step 3 get the url link
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		String title = driver.getTitle();
		System.out.println("the title of the page is:" + title);

		// Or
		// System.out.println("the title of the page is:" + driver.getTitle());
		// or simple
		// System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

	
		
		By url = By.id("Form_submitForm_subdomain");
		By firstname =By.name("FirstName");
		By lastname = By.name("LastName");
		By email = By.cssSelector("#Form_submitForm_Email");
		By jobtitle= By.xpath("//*[@id=\"Form_submitForm_JobTitle\"] ");
		By No_of_employees = By.id("Form_submitForm_NoOfEmployees");
		By company = By.name("CompanyName");
		By industry = By.id("Form_submitForm_Industry");
		By telephone = By.cssSelector("#Form_submitForm_Contact");
		By country = By.xpath("//*[@id=\"Form_submitForm_Country\"]");
		//By state = By.name("State");
		By populate =By.name("SetDummyData");
		//By robot =By.className("recaptcha");
		//By submit =By.cssSelector("body");
		
		ElementUtil eleutil = new ElementUtil(driver);
		
		eleutil.doSendKeys(url, "Sri");
		eleutil.doSendKeys(firstname, "K");
		eleutil.doSendKeys(lastname, "M");
		eleutil.doSendKeys(email, "sri1@email.com");
		eleutil.doSendKeys(jobtitle, "Automation_Engineer");
		eleutil.doSendKeys(No_of_employees, "30");
		eleutil.doSendKeys(company, "Sri Infotech");
		eleutil.doSendKeys(industry, "IT");//dropdown doesnt get populated by given data
		eleutil.doSendKeys(telephone, "87546788");
		eleutil.doSendKeys(country, "India");
		//eleutil.doSendKeys(state, "Hyderabad");// state field appears when the data is populated, but value is not filled
		eleutil.doClick(populate);
		//eleutil.doClick(robot);
		//eleutil.doClick(submit);
		
		
		
		//driver.close();

	}

}
