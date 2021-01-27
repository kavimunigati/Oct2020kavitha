package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	//1 create a web driver
	
	//this is a 7th approach tp ctrate web elements.
	WebDriver driver;
	
	//Give the browsername, which is a String in attribute
	//and we replace the void with webdriver as this is a finction with 
	//string parameter return type.
	public WebDriver intializedriver(String browserName) {
		
		if (browserName.equals("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Chrome");
			}
			else if (browserName.equals("Firefox")){
				WebDriverManager.firefoxdriver().setup();
				WebDriver driver = new ChromeDriver();
				System.out.println("Firefox");
			}
			else if (browserName.equals("Edge")){
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				System.out.println("Firefox");
			}
			else {
				System.out.println("Enter valid browser");
						}
		return driver;
	}
//creating more function, to launch url and get title
	//void does not return value
	public void launchurl(String url) {
		 driver.get(url);
	}
	public String gettitle() { return driver.getTitle(); } //
	 
}
