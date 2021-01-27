package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

// file upload popups are the operating system popups to upload a file
//type ='file" is the most important attribute in the html to automate this file upload popup. 
driver.findElement(By.name("upfile")).sendKeys("file:///C:/Users/kavim/Downloads/1%20-%20Workday%20HCM%20Main%20Book-1-81.pdf");
	//	driver.findElement(By.xpath("//input[@input='submit')")).click(); to uploada file

		

	}

}
