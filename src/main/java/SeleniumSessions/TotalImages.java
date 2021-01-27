package SeleniumSessions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// print total no. of images on the page
		//print the url of each image
		
			 WebDriverManager.chromedriver().setup();
			 driver =new ChromeDriver();
			 
			 driver.get("https://www.amazon.com/");
			 
			 List<WebElement> imagelist =  driver.findElements(By.tagName("img"));// img is the tag for image in html
			 System.out.println(imagelist.size());// printing the no. of images on the list
			 
			 
			// for printing the list of images we are using for each loop
			 
			/** for(int i=0; i<imagelist.size(); i++) {
				 String image = imagelist.get(i).getText();
				 System.out.println(image);
			 }*/
			 
			 
			 // or we can use the foreach loop
			 
			 /**syntax for each loop
			  * for (Object e :list);
			  * System.out.println(e);
			  * object = WebElement
			  * e = reference for webElement
			  * list = image list , in which we have to search
		    }*/			 
			 
			 for(WebElement e : imagelist) {
				String srcUrl = e.getAttribute("src");
			 System.out.println(srcUrl);
			 }
		
	/**	for (WebElement e: imagelist)
			 //e.getAttribute("src");// .getAttribute returns String so initiating String with srcUrl as reference.
		String srcUrl = e.getAttribute("src");//src is the property in html for image link.
	    System.out.println(srcUrl);// stcurl is the reference for the String
			*/		 
	    
	  	}
			 }
			
			 
			 
			 
			  
	


