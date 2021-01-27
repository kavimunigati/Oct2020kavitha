package JavaListwithStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamsWithListAndFilter {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {
    WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://www.amazon.com");

List<WebElement> linklists =driver.findElements(By.tagName("a"));
System.out.println(linklists.size());

/* in earlier ListwithStreams, we saw the example of Sequential and parallel list which prints
 *  the webElements with text and banks. 
 *  now, here we are applying the filters, which filters the balnks ang givesthe list of only texted elements
 *  
 */

List<String> collectionlist = linklists .stream() // create a stream
.filter(ele -> !ele.getText().equals(" "))// applying filters
.map(ele ->ele.getText())// captures all the elements with text and returns String type so add the list  string to links list
.collect(Collectors.toList()); // createa class of collectors to collect the list

collectionlist.stream().forEach( e ->System.out.println(e));
// "e" is a variable for the collections list stream, we can use any variable of ourwish.
// and we see all the elements printed without balnk values.






	}

}
