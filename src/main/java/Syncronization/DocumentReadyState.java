package Syncronization;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DocumentReadyState {
// Generic method to check if the pageis completly loaded (document is in ready state)
	
	
	static WebDriver driver;
	
	public static void jsWaitForPageLoad(int timeOut) {
		JavascriptExecutor jse = ((JavascriptExecutor)driver);// here the code is to changethe javascript to vjava
		String jsCommand = "return document.readyState";
		if (jse.executeScript(jsCommand).toString().equals("completed")) {
			System.out.println("page is fully loaded");
			return; // here it returns null
		}
		
		// if the page is not loaded, it gets into below loop
		for(int i =0; i<timeOut; i++) {
			try {Thread.sleep(500);
		
			if (jse.executeScript(jsCommand).toString().equals("completed")) {
				System.out.println("page is fully loaded");	
				break;
			}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.get("https://www.hubspot.com/");
			//calling from Functions to check if the web page is fully loaded
			jsWaitForPageLoad(30);
			
			

	}

}
