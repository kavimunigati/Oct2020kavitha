package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagNameConcept {
	static WebDriver driver;
	
public WebElement getElement(By locator ) {
	return driver.findElement(locator);
}
	public void doClick(By Locator) {
		getElement(Locator).click();
	}
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		
		////we give ".gettext" method to capture any text type.
		driver.get("https://www.freshworks.com/");
		String title =driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
	    //String header = driver.findElement(By.tagName("h1")).getText();
		//System.out.println(header);
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		//we give ".gettext" method to capture any text here i am using it for capturing the header.
		String h1 = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/h1[2]")).getText();
		System.out.println(h1);
		//String headerx = driver.findElement(By.xpath("/html/body")).getText();
		//System.out.println(headerx);
		
		String cust_text = driver.findElement(By.linkText("Customers")).getText();
		System.out.println(cust_text);
		
		// clicking the customr link and the link opens.
		TagNameConcept tag = new TagNameConcept();
		 By href = By.linkText(cust_text);
		  tag.doClick(href);
		
		  
		  
	
		
		
	
	}

}
