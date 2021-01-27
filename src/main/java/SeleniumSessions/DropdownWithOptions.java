package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownWithOptions {

	static WebDriver driver;
	


	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();

 driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
 String title =driver.getTitle();
 System.out.println("the title of the page:" + title);
 System.out.println(driver.getCurrentUrl());
 
 By NoOfEmployees = By.id("Form_submitForm_NoOfEmployees");
 By Industry = By.id("Form_submitForm_Industry");
 By Country = By.id("Form_submitForm_Country"); 

		// This Options method we use to validate the options from the Dropdown list.
//method 1	
/*Select select_ind = new Select(driver.findElement(Industry));
	List<WebElement> industry_list = select_ind.getOptions();//gives the list of options available in the webelements
	System.out.println("All the options of the industry list:" + industry_list.size());
	
	for(WebElement e : industry_list) {
		String text = e.getText();// to get the test of country list 
	System.out.println(text);
	**/
 
 //Method 2
  //the same process must be applied for any drop down, nstead we will create a generic function as in method 3.
 /*Select select_indus= new Select(driver.findElement(Industry));// create the object of select
   List<WebElement> indus_list = select_indus.getOptions();//get options which is a webelement
 System.out.println("list of industry options:" +indus_list.size());//print the list of options
 for (WebElement e: indus_list) {// to get the text of the options we traverse wsing the for or forech loop
	 String text = e.getText();
	 System.out.println(text);*/
 
 //method 3
 //getDropdownOptionsValues(Country);// prints all the list of countries.
List<String> country_list=getDropdownOptionsValues(Country);
System.out.println(country_list);

// out of the list of countries I want to check if India is present , so we useIfcondition
if(country_list.contains("India")) {
	System.out.println("country India is available in the list ");
}
else {
	System.out.println(" there is no such country");
}
 }
 
	
	public static WebElement getElement(By Locator) {
		 return driver.findElement(Locator);
	}
	public static List<String> getDropdownOptionsValues(By locator) {
	List<String> optionsValList = new ArrayList<>();// we are captuting the text in this array list
	
	Select select= new Select(getElement(locator));
		List<WebElement> indus_list = select.getOptions();//get options which is a webelement
		 System.out.println("list of industry options:" +indus_list.size());//print the list of options
		 for (WebElement e: indus_list) {// to get the text of the options we traverse wsing the for or forech loop
			 String text = e.getText();
			 optionsValList.add(text);//

		 }	 
	return optionsValList;
	}
}
	
	
	
	


