package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunch {

	
	public static void main(String[] args) {
		
System.setProperty("webdriver.gecko.driver", "C:\\Users\\kavim\\Downloads\\geckodriver-v0.28.0-win64\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();

driver.get("https://www.google.com");//enter the url

String title= driver.getTitle();

System.out.println("page title is :" + title);//get the title of the page...page title is :Google

//verification point: (actual vs expected result) verifying the title from line 26 to 32
if (title.equals("Google")){
System.out.println("correct title");
}
else {
	System.out.println("In-correct title");
			}
System.out.println(driver.getCurrentUrl());// verifying the url//https://www.google.com/
//System.out.println(driver.getPageSource());// to get the page source if needed.

driver.quit();//close the browser
}

}
