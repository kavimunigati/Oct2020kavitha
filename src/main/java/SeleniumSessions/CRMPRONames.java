package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CRMPRONames {
static WebDriver driver;
	public static void main(String[] args) {
		
		By usernameLocator = By.cssSelector("input[name='username']");
		By passwordLocator = By.cssSelector("input[name='password']");
		By loginBtn = By.cssSelector("input[type='submit']");
		By contactsMenu = By.linkText("CONTACTS");	
		By rowXpath = By.xpath("(//table[@class='datacard'])[3]//tr/td[2]");
		By selectPage = By.xpath("(//div[@class='pagination']/select[@class='select'])[1]");
		
		String userName = "batchautomation";
		String passWord = "Test@12345";
		String frameLocator = "mainpanel";
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(usernameLocator, userName);
		eleUtil.doSendKeys(passwordLocator, passWord);
		eleUtil.doClick(loginBtn);

		driver.switchTo().frame(frameLocator);
		
		eleUtil.doClick(contactsMenu);
		
		for(int index =2; index<=10; index++){
	
		List<WebElement> colList =eleUtil. getElements(rowXpath);
		for(int i=3;i<colList.size();i++)
		{
			String text = colList.get(i).getText();
			System.out.println(text);
		}
		
		eleUtil.doSelectByIndex(selectPage, index);
	}		

	}

}
