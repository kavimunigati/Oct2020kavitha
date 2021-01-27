package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*public class SearchAssignment {
static WebDriver driver;
	public static void main(String[] args)  {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.findElement(By.name("q")).sendKeys("automationpractice");

List<WebElement> webpage = driver.findElements(By.xpath("//div[@class='sbl1']/span"));
System.out.println(webpage.size());
for(WebElement e: webpage) {
	String weblink=e.getText();
	System.out.println(weblink);
	
	 if(weblink.equals("automationpractice github")){
		 e.click();
		 break;
	 }*/
public class SearchAssignment {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://google.com/");
//System.out.println(driver.getCurrentUrl());
/*driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");
System.out.println(driver.getCurrentUrl());
String title = driver.getTitle();
System.out.println(title);
driver.findElement(By.name("search_query")).sendKeys("dresses");
List<WebElement> clothing_list = 
driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));
Thread.sleep(3000);
System.out.println(clothing_list.size());
for(WebElement e: clothing_list) {
	String dress =e.getText();
	System.out.println(dress);
	  if(dress.contains("Printed Summer Dress")){
		  e.click();
	  }
	driver.close();
	 }*/
driver.get("https://www.kohls.com/");
System.out.println(driver.getCurrentUrl());
driver.findElement(By.name("search")).sendKeys("apple");
Thread.sleep(3000);
List<WebElement> webpage = driver.findElements(By.xpath("//div[@class='ta-suggestion-box']//li"));
System.out.println(webpage.size());
for(WebElement e: webpage) {
	String weblink=e.getText();
	System.out.println(weblink);
	
	 if(weblink.equals("apple airpods")){
		 e.click();
		
		 break;
	 }
/*WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("http://automationpractice.com/index.php");
driver.findElement(By.id("search_query_top")).sendKeys("Dresses");
try {
Thread.sleep(3000);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

List<WebElement> suggestionList = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
System.out.println(suggestionList.size());

for (WebElement e : suggestionList) {
String suggestionsText = e.getText();
System.out.println(suggestionsText);
if (suggestionsText.equals("Evening Dresses > Printed Dress")) {
e.click();
break;
}*/
}



	}
	}


