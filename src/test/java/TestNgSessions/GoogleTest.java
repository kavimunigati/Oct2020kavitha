package TestNgSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is :" + title);
		Assert.assertEquals(title, ""); //Import assertion and assertion must be given to validat each step
	}

	@Test
	public void googleLogoTest() { //It is an ideal practice to write the word Test with each test case
		//boolean flag =driver.findElement(By.id("logo")).isDisplayed();
		//Assert.assertEquals(flag, true);
		//Assert.assertEquals(flag)
		// to minimizethe code we can just write in one single line
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div #hplogoo")).isDisplayed());}

	@Test
	public void googlAccountTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='gb_Tf gb_Sa gb_Fg gb_i']")).isDisplayed());
	}

}
