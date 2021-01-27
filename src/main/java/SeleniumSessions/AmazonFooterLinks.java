package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooterLinks {
static WebDriver driver;

	public static void  main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 driver =new ChromeDriver();
		 
		driver.get("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl()); 
		 
		ElementUtil eleutil= new ElementUtil(driver);//1.create an object of the elementutil
		 
		 //2. extract the x path and  to get elements whose return type is List<WebElements>
		  List<WebElement> elements= eleutil.getElements(By.xpath("//div[@class='navFooterLinkCol navAccessibility']//a"));
		 
		 System.out.println(elements.size());// to print the no of elements in the list
		 //iterate the webElements to print the list of the footer elements
		 
		 for(WebElement list : elements) {
			System.out.println(list.getText()); 
		   String url= list.getAttribute("href");
		   System.out.println(url);
		 }
		
		 System.out.println("########################################");
			
			// Print the size and list of all the countries in the footer
			 
			driver.get("https://www.amazon.in/");
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl()); 
				
			 List<WebElement> country=  eleutil.getElements(By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine ']//a"));
			 System.out.println(country.size());
			 for(WebElement ctry :country) {
				 System.out.println(ctry.getText());
			 ctry.getAttribute("href");
			 }
			 driver.close();	
		
	}		 

		 

		 
		 
	
	
}
	

