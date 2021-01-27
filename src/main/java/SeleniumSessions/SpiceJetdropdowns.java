package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetdropdowns {
static WebDriver driver;


	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.getTitle());
		
		/*By From = By.id("ctl00_mainContent_ddl_originStation1");
		By Departure = By.cssSelector("a[value='IXU']");
		By To = By.id("ctl00_mainContent_ddl_destinationStation1");
		By Arrival= By.cssSelector("a[value='BLR']");*/
		driver.findElement (By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='IXU']")).click();
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		//OR other option to create a xpath without index is via parent child relationship
	driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
	
		
		
		
	}

}
