package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	static WebDriver driver;


	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();

 driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
 String title =driver.getTitle();
 System.out.println("the title of the page:" + title);
 System.out.println(driver.getCurrentUrl());
 
 
 /** this is one of the method to create a drop down, 
  * the drawback of this method is we have to create the objects of multiple fields.
  * instead we can creat generic methods in class level or in the generic Element utilily package
  *   and call them according to our requirment. 
    */
 
//Create a By locator for assigning variables.
By NoOfEmployees = By.id("Form_submitForm_NoOfEmployees");
By Industry = By.id("Form_submitForm_Industry");
By Country = By.id("Form_submitForm_Country"); 

//Method 1
 /**
 //Create a By locator declaring the variables and  assigning values
 By NoOfEmployees = By.id("Form_submitForm_NoOfEmployees");
 By Industry = By.id("Form_submitForm_Industry");
 
 //now create the object of  Select class to select the attribute which is selenium defined
 //Select is a Tag<select> in HTML which holds all the dropdowns.
 //Select the constructer using "driver.findElement(NoOfEmployees)" or which ever attribute we want to pass.
 Select select_emp= new Select(driver.findElement(NoOfEmployees));
 select_emp.selectByValue("26 - 50");
 // OR
 //select_emp.selectByIndex(5); this will select the value of 5th item in  index.better to use when the value is fixed
 //select_emp.selectByVisibleText("26 - 50");to select a specific value from the list of inspect values.
	
 
 // we have to create the object of each dropdown
 Select select_ind = new Select(driver.findElement(Industry));
select_ind.selectByVisibleText("Business Services / Consultancy - Non IT");
//OR
//select_ind.selectByValue("Business Services/Consultancy");//Select the value from value field of the inspect dropdown
//select_ind.selectByIndex(4); index from the dropdown
	*/
 
 //Method 2
//instead of creating the object many times and calling it  we can create a generic method and call it.
 //here we care just calling the methods created in the class and executing them.
// we can use this methos only when the HTML has Select tag
ElementUtil eleutil =new ElementUtil(driver);
eleutil.doSelectByVisibleText(Country, "India");
eleutil.doSelectByIndex(NoOfEmployees, 5);
eleutil.doSelectByValue(Industry, "Aerospace");

/* for the Static functions created below we can call them directly
as the object is also created in the the function itself, by just clicking the 
.indent which would give the list of the methods or functions created*/
 doSelectByValue(Country, "United States");
 doSelectByVisibleText(Industry, "Aerospace");
 doSelectByIndex(NoOfEmployees, 6);
 
	}
	
	//instead of creating the object many times and calling it  we can create a generic method and call it.
	// but calling from ElementUtil class in method 2 above.
	// we are writing these functions out of main method.
	//the 1st Select is html tag and 2nd select is objreference for htmltag
	//html Select must be written in "S"
	
	public static  WebElement getElement(By Locator) {
		 return driver.findElement(Locator);
	}	
	public static  void doSelectByIndex(By Locator, int index) {// user defined method
		Select select=new Select(getElement(Locator));// select asks for webelement so we give it a get element which has webelements.
		select.selectByIndex(index);// we have to just give this last line to run in the class level
			}

public static  void doSelectByVisibleText(By Locator, String text) {	 
		 Select select=new Select(getElement(Locator));
		 select.selectByVisibleText(text);// we have to just give this last line to run in the class level
				 }	 

public static void  doSelectByValue(By locator, String value) {
			Select select = new Select(getElement(locator));
			select.selectByValue(value);// we have to just give this last line to run in the class level
		}	
	 
	

}


