package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CRMPROCompanyList {
static WebDriver driver;
public static void main(String[] args) {
		//launch the url
		//enter un,pw and login
		//Select contacts from the frame
		//print all the names
		//select the dropdown and select the index
		//print the index
		
WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();
driver.get("https://classic.crmpro.com/");

By usernameLocator = By.cssSelector("input[name='username']");
By passwordLocator = By.cssSelector("input[name='password']");
By loginBtn = By.cssSelector("input[type='submit']");
By contactsMenu = By.linkText("CONTACTS");	
By rowXpath = By.xpath("(//table[@class='datacard'])[3]//tr/td[2]");
By Company_row = By.xpath("//form[@id='vContactsForm']/table//tr//td[3]");
By selectPage = By.xpath("(//div[@class='pagination']/select[@class='select'])[1]");

ElementUtil eleUtil = new ElementUtil(driver);
eleUtil.doSendKeys(usernameLocator, "batchautomation");
eleUtil.doSendKeys(passwordLocator, "Test@12345");
eleUtil.doClick(loginBtn);

driver.switchTo().frame(driver.findElement(By.name("mainpanel")));
eleUtil.doActionsClick(contactsMenu);

for(int index=2; index<=10; index++) {// index is the page number, starts from page 2

	List<WebElement> colList =eleUtil. getElements(rowXpath);
	for(int i=3;i<colList.size();i++)
	{
		String text = colList.get(i).getText();
		System.out.println(text);
List<WebElement> companylist = eleUtil.getElements(Company_row);
System.out.println(companylist.size());

for(int i1=1; i1<companylist.size();i1++) {// prints all the company names in page 1
	
	String text1 = companylist.get(i1).getText();
	 if(!text1.isBlank()){// !text == not text which means do not print blank
		 System.out.println(index + "--->" + text1 );//prints the text along with page number
	
	}
}
eleUtil.doSelectByIndex(selectPage, index);
}
		
}
	}
}


		
		
		
		
		
		
		
		
		
	
