package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		//1.open the browser
		//2.enter url:
		//3.get the title of the page
		//4. verify the title- check the title
		//5. close the browser
		
		//Top casting the web driver interface
		//importing the web driver and Chrome driver org.openqa.selenium.WebDriver;
		
		//Automation steps + verification point =automation testing 
		//Automation steps
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kavim\\Desktop\\chromedriver_win32\\chromedriver.exe ");
		WebDriver driver = new ChromeDriver();//open the browser: Chrome	
		
		//driver.manage().window().fullscreen(); //to get the full screen
		
		//driver.manage().window().maximize();//to get maximize the screen
		
		driver.get("https://www.google.com");//enter the url
		
		String title= driver.getTitle();
		System.out.println("page title is :" + title);//get the title of the page...page title is :Google
		
		
	/**	here I am giving another website to see if it navigates  or launches another 
	 * website and navigating back to google
	 * 
	 * driver.get("https://yahoo.com");
		String title1 = driver.getTitle();
		System.out.println("page title is :" + title1);
		
		driver.get("https://www.google.com");//enter the url
		
		*/
		
		//verification point: (actual vs expected result) verifying the title f
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
