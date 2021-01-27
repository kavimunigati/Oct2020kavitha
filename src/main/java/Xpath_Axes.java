

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
	import java.util.ArrayList;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Xpath_Axes {

		static WebDriver driver;
		public static void main(String[] args) {
			
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.espncricinfo.com/series/new-zealand-v-pakistan-2020-21-1233950/new-zealand-vs-pakistan-2nd-t20i-1233960/full-scorecard");
			
			
			//a[text()='Ali Baba']//parent::td//preceding-sibling::td/input[@type='checkbox']
			//a[text()='Anand Reddy']//parent::td//preceding-sibling::td/input[@type='checkbox']
			
//			System.out.println(getWicketTakerName("Haider Ali"));
//			System.out.println(getWicketTakerName("Faheem Ashraf"));
	}

}
