package JavaListwithStreams;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListwithStreams {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {
    WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://www.amazon.com");

		//Streams is introduced in java 8, which will be applied on list
		/* when we want to print a list of web elments from a url, we usually usearray concept 		
		List<WebElement> elements = driver.findElements(by(locator));
		and to print we use for loop or for each loop. here instead of loops we use foreach method to print the list.
		and there are different types of streams*/
// in this below example we are trying to print the links of all the list, and the links have the tagname "a"
//in this foreach() method, we have to give some variable. so I am giving as "ele" 
//and use lambda expression "->" which acts as supplier, supplies the list of find elements t print in system.print.ln
		
  List<WebElement> linklists =driver.findElements(By.tagName("a"));
  System.out.println(linklists.size());
  //sequential stream, provides the list in a sequence format
    // linklists.stream().forEach(ele -> System.out.println(ele.getText()));
    
    //parallel stream, in this method all the elements are printed ata time, but not in a sequence, it is the fastent methosd to obtain print.
  //  linklists.parallelStream().forEach(ele -> System.out.println(ele.getText())); 
    
   /*to find the time taken  to execute each method, lets calculate time, 
    this is optional only to get the track of time.*/
    
   long stTime =  System.currentTimeMillis();
  // linklists.stream().forEach(ele -> System.out.println(ele.getText()));
   linklists.parallelStream().forEach(ele -> System.out.println(ele.getText())); 
   long endTime = System.currentTimeMillis();
   System.out.println(" time taken to execute parallel stream is : " + ( endTime - stTime));
    //time taken to execute sequential stream is : 12285
    
	}

}
