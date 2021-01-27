package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropConcept {

	static WebDriver driver;
	public static void main(String[] args)   {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://jqueryui.com/droppable/");

/*Dragging one Web element to another web element
We use Actions Class to perform any actions like Drag and Drop
Actions:
1. Click on the web element and hold
2. drag the web element
3,. relese the web element on to onto another webelement
 create the object of the Action class ans it has to be written in Cap A
driver.findElement(By.id("draggable")); the element that is to be dragged  and dropped is created. and Find element is always looking for web element
action_obj.clickAndHold(target);// to find the target element
 when ever we are performing multiple actions, like drag, drop, release, etc.., 
  that should be followed by drop() and perform().
 */
Actions act_obj = new Actions(driver);// Create Action object
WebElement src_Element = driver.findElement(By.id("draggable"));// create action to be dragged
WebElement target_Element = driver.findElement(By.id("droppable"));// creating action to be dropped

/*when ever we are performing multiple actions, like drag, drop, release, etc.., 
that should be followed by drop() and perform().*/
act_obj.clickAndHold(src_Element).moveToElement(target_Element).release().build().perform();


// this is the second way to drag and drop in one step and has to be followed by .perform ()
act_obj.dragAndDrop(src_Element, target_Element).perform();




	}

}
