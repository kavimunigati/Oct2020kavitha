package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePopupHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
 driver.get("http://www.londonfreelance.org/courses/frames/");
 
 // switch the driver  to frame
 //when we enter. we see thet frames are overloader, meaning frames with different attributes
 // we can select any of those depending on the html tag list
 
 //driver.switchTo().frame(2);// index of the frame when we count from the html frames
 //driver.switchTo().frame("main");// ideal to choose name or id
 driver.switchTo().frame(driver.findElement(By.name("main")));
 
 driver.findElement(By.xpath("/html/body/h2"));// here in this xpath we areusing all tags as there is no other option. 
 		
 driver.switchTo().defaultContent();
 

	}

}
