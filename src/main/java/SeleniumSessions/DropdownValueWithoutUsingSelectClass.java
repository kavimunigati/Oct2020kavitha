 package SeleniumSessions;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownValueWithoutUsingSelectClass {
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

		 driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		 String title =driver.getTitle();
		 System.out.println("the title of the page:" + title);
		 System.out.println(driver.getCurrentUrl());
		 
		 //By locator is created to define the variable and value
		 //step 1: createthe variable
		 By Industry =By.xpath("//select[@id='Form_submitForm_Industry']/option");
		By Country =By.xpath("//select[@id='Form_submitForm_Country']/option");
		 //Dont useSelect Class, insteadwe createa Xpath and use it
		 //but there is a select tab
		 // and select the value from the dropdown
		 //step2: find the element and the size of the element
		 //step 3: then print the list  traversing through the for or foreach loop
		 
		 //Method1
		/* List<WebElement>induslist= driver.findElements(Industry);
		System.out.println( induslist.size());
		for(WebElement e:induslist) {
		String text= e.getText();
				System.out.println(text);*/
				
				selecttDropdownValue(Industry, "Education");
				selecttDropdownValue(Country, "India");
		}
		
	
	// this method finds the element from the optons list and when found will click the particular element.
public static void selecttDropdownValue(By locator,String value) {
	List<WebElement>optionslist= driver.findElements(locator);
	System.out.println( optionslist.size());
	for(WebElement e:optionslist) {
		String text= e.getText();// this text if from dropdown at the run time
		if(text.equals(value)) {// the text in if condition should match the text in Webelement to make it true.
			e.click();
			break;
		}
	
	
}
}
}