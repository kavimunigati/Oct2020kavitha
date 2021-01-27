package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreshWorksFooter {
	static WebDriver driver;
	
	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.freshworks.com/");
	System.out.println(driver.getTitle());
System.out.println(driver.getCurrentUrl());


//print the footer size and list of webelements in the footer
ElementUtil fw =new ElementUtil(driver);

List<WebElement> we= fw.getElements(By.xpath("//div[@class='col-sm-6']//a"));
System.out.println(we.size());
 for(int i=0; i<we.size();i++) {
	 //System.out.println(i);
	// System.out.println(i + "--->" + we.get(i));
	System.out.println(i + "--->" + we.get(i).getAttribute("href"));
	
 }
 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
 
 //Traverse until Fresh chat and then click the page, 
 //When page opens It has to print the page name and current url. 
 fw.clickElement(By.xpath("//div[@class='col-md-4 footer-left-section']//a"), "Freshchat");
String FWTitle = driver.getTitle();
System.out.println(FWTitle);
System.out.println(driver.getCurrentUrl());

driver.close();


	}

}
