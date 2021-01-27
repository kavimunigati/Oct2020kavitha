package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	//This is the 5th approach to create a web browser and web elements and
	// automate the web page
	// using functions created in one page and
	// call these functions into another pages like here we created a login page.
//creating a Utility class to maintain all the generic methods
// we are creating private web driver as we do not 
//want to give acces o the driver outside of the class

	private WebDriver driver;

//Creating a Constructor for the class
	/**
	 * we are giving WebDriver driver in arguments, as this driver is linked to the
	 * driver in the Class Driver. and when the object is created out side the
	 * class, this driver will be called.
	 */
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By Locator) {
		return driver.findElement(Locator);
	}
	// calling one method into another concept in java
	// here we are calling getelement method into doclick method and dosendkeys
	// methods.

	public void doClick(By Locator) {
		getElement(Locator).click();
	}

	public void doSendKeys(By Locator, String value) {
		getElement(Locator).sendKeys(value);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void clickElement(By locator, String value) {
		List<WebElement> eleList = getElements(locator);
		System.out.println(eleList.size());

		for (int i = 0; i < eleList.size(); i++) {
			String text = eleList.get(i).getText();
			System.out.println(text);
			if (text.equals(value)) {
				eleList.get(i).click();
				break;
			}
		}
	}

	/*********************** SELECT METHODS *****************/

	public void doSelectByIndex(By Locator, int index) {// user defined method
		Select selectobj = new Select(getElement(Locator));// select asks for webelement so we give it a get element
															// which has webelements.
		selectobj.selectByIndex(index);
	}

	public void doSelectByVisibleText(By Locator, String text) {
		Select selectobj = new Select(getElement(Locator));
		selectobj.selectByVisibleText(text);
	}

	public void doSelectByValue(By locator, String value) {
		Select selectobj = new Select(getElement(locator));
		selectobj.selectByValue(value);

	}

	public void selectDropDownValue(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}

		}
	}

	public List<String> getDropdownOptionsValues(By locator) {
		List<String> optionsValList = new ArrayList<>();// we are captuting the text in this array list

		Select select = new Select(getElement(locator));
		List<WebElement> indus_list = select.getOptions();// get options which is a webelement
		System.out.println("list of industry options:" + indus_list.size());// print the list of options
		for (WebElement e : indus_list) {// to get the text of the options we traverse wsing the for or forech loop
			String text = e.getText();
			optionsValList.add(text);//
		}
		return optionsValList;
	}

	public void selecttDropdownValue(By locator, String value) {
		List<WebElement> optionslist = getElements(locator);
		// System.out.println( optionslist.size());//optional
		for (WebElement e : optionslist) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	/****************** ACTIONS METHODS *****************************/

	public void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		//action.sendKeys(getElement(locator), value).perform();
	action.moveToElement(getElement(locator)).sendKeys(value).build().perform();
	/*The above line is to move element and give the value there instead of creating
	a do move element function separately.*/
	
	}

	public void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		//action.click(getElement(locator)).perform();  OR either this or the action in next line can be used.
		action.moveToElement(getElement(locator)).click().build().perform();
		/*The above line is to move element and click the element  instead of creating
		a do move element function separately.*/
	}
public void doMoveToElement(By locator) {
	Actions action = new Actions(driver);
	action.moveToElement(getElement(locator)).perform();
	
}


public void clickStreamElement(By locator, String value) {
	List<WebElement> indus_list = getElements(locator);
	System.out.println(indus_list.size()); 

	List<String> i_list =indus_list.stream()
			.filter(element ->element.getText().contains("Education"))
					 .map(element ->element.getText())
					 .collect(Collectors.toList());
	i_list.stream().forEach(ele -> System.out.println(ele));
}
 //*****************************Wait Utils*******************************************
/**An expectation for checking that all elements present on the web page 
 * that match the locator are visible.Visibility means that the elements are not only displayed
 *  but also have a height and width that is greater than 0.
 * @param locator used to find the element
 * @param TimeOut used to mention specific amount of wait time
 * @Returns:the list of WebElements once they are located
 * we are replacing void with List<WebElement> as wait.until has a return type
 This method works exactly as get the List<WebElement>, but it has wait applied to it, so it waits fo the 
elements to appear for given amount of time and then responds.
 */
public  List<WebElement> VisibilityOfAllElements(By locator, int TimeOut) {
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
}

public void getPageElementsText(By locator, int TimeOut) {
	VisibilityOfAllElements(locator, TimeOut).stream().forEach(ele -> System.out.println(ele.getText()));
}

/** Preseece of elementlocated
 * An expectation for checking that an element is present on the DOM of a page.
 *  This does not necessarily mean that the element is visible.
 * @param locator
 * @param timeout
 * @return
 */

public WebElement waitForElementPresent(By locator, int timeout) {
WebDriverWait wait = new WebDriverWait(driver,timeout);
return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}
/**
 * An expectation for checking that an element, known to be present on the DOM of a page, is visible.
 *  Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
 * @param locator
 * @param timeout
 * @return
 */
public  WebElement waitForElementVisible(By locator, int timeout) {
WebDriverWait wait = new WebDriverWait(driver,timeout);
return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
}


public  boolean waitForURLToBe(String urlValue, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver,timeout);	
	return wait.until(ExpectedConditions.urlContains(urlValue));
}

/***************************Wait Alert***************************************/


public  Alert waitforAlert(int timeout){
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	return  wait.until(ExpectedConditions.alertIsPresent());
}

public  void acceptJSAlert(int timeout){
	 waitforAlert(timeout).accept();
}

public  void dismissJSAlert(int timeout){
	 waitforAlert(timeout).dismiss();
}

public String getAlertText(int timeout){
	 return waitforAlert(timeout).getText();
}

public String waitForTitletoBe(String title, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	wait.until(ExpectedConditions.alertIsPresent());
	return driver.getTitle();
	
}

//******************************Wait Click************************

// we will have void as we are not expecting any return, but just click the element
/**An expectation for checking an element is visible and enabled such that you can click it.
Parameters:locator used to find the elementReturns:the WebElement once it is located and
 clickable (visible and enabled)*/

public  void clickwhenready(By locator, int timeout) {
	WebDriverWait  wait = new WebDriverWait(driver,10);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	element.click();

}
/****************************JavaScript Document complete**********************/
  public  void jsWaitForPageLoad(int timeOut) {
		JavascriptExecutor jse = ((JavascriptExecutor)driver);// here the code is to changethe javascript to vjava
		String jsCommand = "return document.readyState";
		if (jse.executeScript(jsCommand).toString().equals("completed")) {
			System.out.println("page is fully loaded");
			return; // here it returns null
		}
		
		// if the page is not loaded, it gets into below loop
		for(int i =0; i<timeOut; i++) {
			try {Thread.sleep(1000);
		
			if (jse.executeScript(jsCommand).toString().equals("completed")) {
				System.out.println("page is fully loaded");	
				break;
			}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
  }
/**************************************Fluent Wait********************************************/
  //creating generic method
//This method is checking the presence using the fluent wait
  
  public  void waitForElementWithFluentWait(By locator, int timeOut, int pollingTime ) {
		Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))//maximum time out
				.pollingEvery(Duration.ofSeconds(pollingTime))//sending time to check every 2 seconds i.e...,polling time
				.ignoring(NoSuchElementException.class)// while doing the other if there is any no element exception ignore it
				.ignoring(StaleElementReferenceException.class);// ignore stale exception
				
		WebElement ele =  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		ele.click();
	}
  
  //overlading the waitForElementWithFluentWait method just by removing the polling time
  
  public  void waitForElementWithFluentWait(By locator, int timeOut) {
		Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))//maximum time out
				.ignoring(NoSuchElementException.class)// while doing the other if there is any no element exception ignore it
				.ignoring(StaleElementReferenceException.class);// ignore stale exception
				
		WebElement ele =  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		ele.click();
	}

 /** public  void ClickElementWithFluentWait(By locator, int timeOut ) {
		Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))//maximum time out
				.ignoring(NoSuchElementException.class)// while doing the other if there is any no element exception ignore it
				.ignoring(StaleElementReferenceException.class);// ignore stale exception
				
		WebElement ele =  wait.until(ExpectedConditions.elementToBeClickable(locator));
		ele.click();
	}
  
  public  void ElementVisibleWithFluentWait(By locator, int timeOut, int pollingTime ) {
		Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))//maximum time out
				.pollingEvery(Duration.ofSeconds(pollingTime))//sending time to check every 2 seconds i.e...,polling time
				.ignoring(NoSuchElementException.class)// while doing the other if there is any no element exception ignore it
				.ignoring(StaleElementReferenceException.class);// ignore stale exception
				
		WebElement ele =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		ele.click();
	}**/
  
}