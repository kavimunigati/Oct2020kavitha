package JavaListwithStreams;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCheckBoxeswithStreams {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {
    WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

// we want to select all the check boxes
List<WebElement> checkBoxList = driver.findElements(By.cssSelector("td.select-checkbox"));
System.out.println( checkBoxList .size()); 

//Sequential Stream
checkBoxList.stream().forEach(element ->element.click());

//
checkBoxList.parallelStream().forEach(element ->element.click());
 

	}

}
