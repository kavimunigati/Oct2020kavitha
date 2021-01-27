package Syncronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitEWaitconcept {
/* The Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount of time 
before it throws a "No Such Element Exception". The default setting is 0. 
Once we set the time, the web driver will wait for the element for that time before throwing an exception.
For implicit wait syntax
driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
In the below exapmleI am asing the selenium to wait for 10 seconds before it the the exception.*/
	
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
	// applyimg implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/");
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				
				driver.findElement( By.name("username")).sendKeys("batchautomation");
				driver.findElement(By.name("password")).sendKeys("Test@12345");
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				// nullifying implicit wait
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

}
