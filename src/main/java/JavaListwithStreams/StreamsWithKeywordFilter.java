package JavaListwithStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamsWithKeywordFilter {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {
    WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://www.amazon.com");

List<WebElement> linklists =driver.findElements(By.tagName("a"));
System.out.println(linklists.size());

//we want to filter the print with the list that contain keyworks, eg here "Amazon'
/**List<String> amazonLinkList =linklists.stream()// createa list ogf stream
.filter(element ->!element.getText().equals("") && element.getText().contains("Amazon"))
// filter the code based on no blank fields and keyword then 
        .map(element ->element.getText())// capture all the elements without blank and keyword only
        .collect(Collectors.toList()); 
/*collects all the list of items to print creating a collectoers classto the list, which gives the String so, 
we add List string  array to the linkedlists */


//OR modified code//
List<String> amazonLinkList =linklists.stream()
.filter(element ->!element.getText().isEmpty())
.filter(element ->!element.getText().contains("Amazon"))
		 .map(element ->element.getText())
		 .collect(Collectors.toList());

amazonLinkList.stream().forEach(element ->System.out.println(element));


	}

}
