package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest {
//declaring web driver at class level, so that I can use itdirectlu
	static WebDriver driver;
	
	public static void main(String[] args) {
		/** we are top casting the interface reference driver here instead of class obj ref, as
		 * it can be  used as a generic reference, across its classes abd we dont have to change the 
		 * objects, for chrome or firefox or any drivers individually. 	 * 
		 * */
		 
String browser ="Chrome";
if (browser.equals("Chrome")){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\kavim\\Desktop\\chromedriver_win32\\chromedriver.exe ");
	driver =new ChromeDriver();
	
}
else if (browser.equals("Firefox"))	{
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\kavim\\Downloads\\geckodriver-v0.28.0-win64\\geckodriver.exe");
	 driver = new FirefoxDriver();
}
else {
	System.out.println(" please launch correct browser");
}

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

driver.get("https://yahoo.com");
}
	}


