package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickOrContextMenu {

	static WebDriver driver;
	public static void main(String[] args)   {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
System.out.println(driver.getCurrentUrl());
System.out.println(driver.getTitle());
WebElement rightclick_elment=driver.findElement(By.xpath("//span[text()='right click me']"));
Actions act_obj = new Actions(driver);//action object to be created to perform any action
act_obj.contextClick(rightclick_elment).perform();//we do only .perform() as contextclick is only one action
List <WebElement> menu_list = 
                   driver.findElements
                         (By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span"));
System.out.println(menu_list.size());//the xpath for the right click menu list, then get the size of list

for(WebElement e : menu_list) {//for printing the list of the menu list
String text =	e.getText();
System.out.println(text);

if(text.equals("Cut")) { //choose the element from the list and perform click function
e.click();
break;
		
}
 
}	
}
	}


