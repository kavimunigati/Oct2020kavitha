package SeleniumSessions;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://google.com/");
		driver.findElement(By.name("q")).sendKeys("Naveen AutomationLabs");	
		Thread.sleep(3000);
		List<WebElement> suggestionslist =driver.findElements(By.xpath("//div[@class='sbl1']/span"));
		System.out.println(suggestionslist.size());
		
		for (WebElement e: suggestionslist) {
			String text =e.getText();
			System.out.println(text);
			
			if(text.equals("naveen automationlabs postman")) {
				e.click();
				break;
				
			}
			
		}
		

	}

}
