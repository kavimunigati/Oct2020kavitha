package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPopUp {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

//to enable the popup, we click login button
//now inspect the login button
driver.findElement(By.name("proceed")).click();
Thread.sleep(4000);// to check the pop up appear

// now we have to switch the JSpopup driver from the webpage to the popup or alert.
//we have to store the Alert to alert reference
// this. alert method works only for java script alert only.
Alert alert =driver.switchTo().alert();
String text = alert.getText();
System.out.println(text);

//alert.accept();// to accept the alert
alert.dismiss();// to dismiss the alert, so that we dont proceed further usually important for online shopping.

// now that we have switched the driver from webelement to alert, we have to switch back to the webelement to work on it further
driver.switchTo().defaultContent();
	}

}
