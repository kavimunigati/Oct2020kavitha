package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablewithxpath {
	static WebDriver driver;

public static void main(String[] args)   {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		By username= By.cssSelector("input[name='username']");
		By password = By.cssSelector("input[name='password']");
		By login = By.cssSelector("input[type='submit']");
		By CONTACTS =By.xpath("//a[@title='Contacts']");//https:classic.freecrm.com/upgrade.cfm
			
			
			ElementUtil eleutil =new ElementUtil(driver);
			
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("batchautomation");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Test@12345");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.switchTo().frame(driver.findElement(By.name("mainpanel")));	
   		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
   		
   		By rows = By.xpath("//table[@class='datacard'])[3]//tr/td[2]");
   		List<WebElement> nameList = driver.findElements(rows);
   		for(int i=3;i<nameList.size();i++)
   		{
   			System.out.println(nameList.get(i).getText());
   		}
   		
}	
}
   		
   		/**List<WebElement> name_list =driver.findElements(By.xpath("//form[@id='vContactsForm']/table//tr//td[2]"));
   //	List<WebElement> name_list =	driver.findElements
   	//	(By.xpath("//form[@id='vContactsForm']/table//tr[4]//td[2] ---> //form[@id='vContactsForm']/table//tr[24]//td[2]"));
   		System.out.println(name_list.size());
   		for(WebElement e: name_list) {
   		 System.out.println(e.getText());
   		}
   		
   		System.out.println("&&&&&&&&&&&&&&");
   		for(int i=4; i<=24; i++){

   		 List<WebElement> name1_list =driver.findElements(By.xpath("(//table[@class='datacard'])[3]//tr/td[2]"));
   		name1_list.stream().forEach(ele ->System.out.println(ele.getText()));
   		**/


	// System.out.println(name_list.size());

	// for(WebElement e: name_list) {
	// System.out.println(e.getText());

/**
 * System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"); for (int i =0;
 * i<=0; i++) { List<WebElement> name1_list
 * =driver.findElements(By.xpath("//form[@id='vContactsForm']/table//tr//td[2]["+1+"]"));
 * name1_list.stream().forEach(ele ->System.out.println(ele.getText())); }
 * //eleutil.doSelectByIndex(pages, 10);
 */

