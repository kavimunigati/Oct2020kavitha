package TestNgSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTestWithBeforeMethod {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
	}

	@Test
	public void googleTitleTest() {//It is an ideal practice to write the word Test with each test case
		String title = driver.getTitle();
		System.out.println("page title is :" + title);
		Assert.assertEquals(title, "Google"); //Import assertion and assertion must be given to validat each step
	}

	@Test
	public void googleLogoTest() { //It is an ideal practice to write the word Test with each test case
		//boolean flag =driver.findElement(By.id("logo")).isDisplayed();
		//Assert.assertEquals(flag, true);
		//Assert.assertEquals(flag)
		// to minimizethe code we can just write in one single line
		
		Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed());}

	@Test
	public void googleSearchButtonTest() {
		Assert.assertTrue(driver.findElement(By.partialLinkText("Gmail")).isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}


