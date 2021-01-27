package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class STHMoveToElement {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException   {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://www.softwaretestinghelp.com/");
System.out.println(driver.getCurrentUrl());
System.out.println(driver.getTitle());

By Courses =By.linkText("Courses");
By Selenium = By.xpath("//li[@id='mega-menu-item-23877']");
doMoveToElement(Courses);
Thread.sleep(10000);
doActionClick(Courses);
Thread.sleep(10000);
doMoveToElement(Selenium);
doActionClick(Selenium);

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
public static void doMoveToElement(By locator) {
	Actions action = new Actions(driver);
	List<WebElement> course_list = getElements(locator);
	action.moveToElement(getElement(locator)).perform();
	for(WebElement e : course_list) {
		System.out.println(e.getSize());
		
		
	}
}
public static void doActionClick(By locator) {
	Actions action = new Actions(driver);
	action.click(getElement(locator)).perform();
}
}
