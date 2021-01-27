package SeleniumSessions;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	static WebDriver driver;
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 driver =new ChromeDriver();
		 
		 //Get total no of lists on the page
		 //print the text on each link
		 //print href values in the url
		 
		 driver.get("https://www.amazon.com/");
		 
		System.out.println(driver.getCurrentUrl()); 
		
		
		/**now we have the Url and we want to find elements,
		 * so we use the FinfElements() method to fetch the Webelements.
		 * FindElements returns WebElements		
		 * we are finding the elements with locator which is tagnmae and goes by <a>,  with By class
		 * List is a Arraylist of webelements<webelements>
		 * Links list is the reference name given tonarray list */
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		 System.out.println("total links:" + linkslist.size());// gives the no. of lists in the linkslist (webpage).
	// now we have to traverse or display  the list of links, so we use for loop 
		 for(int i=0; i<linkslist.size();i++){
			 String text = linkslist.get(i).getText();// this displays the text in the links
		//	String url = linkslist.get(i).getAttribute("href");// this displays the url which is href attribute.
		//	 System.out.println(text);// prints all the list with blank and text
		//	 System.out.println(i + "--->" + text );// printsthe list, with numbers and text
		//	System.out.println(url); prints the url
			
 // to ignore blank and print only the text and the url associated with it.
			 if(!text.isEmpty()){// !text == not text which means do not print blank
			 System.out.println(i + "--->" + text );
			 
			 String url = linkslist.get(i).getAttribute("href");
			System.out.println(url);// prints the url associated with the texts.
		 }
		 
		 
		 
		 
	
		 }
	}
}


