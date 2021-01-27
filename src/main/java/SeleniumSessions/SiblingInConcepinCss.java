package SeleniumSessions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SiblingInConcepinCss {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		//driver.get("https://classic.crmpro.com/");
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		//Requirement is to get the list of only the first column which is  company 
		
	//	List<WebElement> webtable_list =driver.findElements(By.xpath("//table[@id='customers']//tbody//tr//td[1]"));
		List<WebElement> webtable_list =driver.findElements(By.cssSelector("table#customers tr"));
				
		System.out.println(webtable_list.size());
		for(WebElement ele:  webtable_list) {
		System.out.println(ele.getText());
		}
		
		// If I want to get the list of all the webtable, i can use the below steps.
		/*for(int i=1;i<=1; i++) {
			List<WebElement>columndata=driver.findElements
					//(By.xpath("//table[@id='customers']//tbody//tr//td["+i+"]"));
					columndata.stream().forEach(ele ->System.out.println(ele.getText()));
			*/				
		}
		
		// while following the sibling concept in Css
		// following sibling can be achieved with a  "+" sign
		// in Css, we can have only following sibling and not preceding sibling unlike xpath..this is alimitation of Css
		// the syntax is Tagname[attribute='value] + Tagname ---------> of the sibling following.
		//input[name ='username'] + input
		
		//not operator in css
		/** when we have multiple web elements with same valueswe use not keyword to eleminate one of them.
		 in the below example, we have two siblings with as class name  " .form-control" for both 
		username and password and want use only the 2nd sibling which is the password
		 
		 
		
		**/
	}


