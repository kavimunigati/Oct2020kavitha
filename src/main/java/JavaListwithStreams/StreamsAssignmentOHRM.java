package JavaListwithStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamsAssignmentOHRM {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {
    WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");

Thread.sleep(4000);
List<WebElement> indus_list = driver.findElements(By.xpath("//select[@id='Form_submitForm_Industry']/option"));
System.out.println(indus_list.size()); 

indus_list.stream().forEach(ele -> System.out.println(ele.getText()));

		 
	





	}

}
