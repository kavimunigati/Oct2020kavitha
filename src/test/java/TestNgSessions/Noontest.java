package TestNgSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Noontest extends BaseTest{
// we are not writing the @BeforeTest setup  and @AfterTest here aswe ate calling the base method
	//following the inheritance concept
	// noontest is the child of Basetest(parent)
	
	@Test
	public void noonTitleTest() {
		driver.get("https://www.noon.com/uae-en");
		String title = driver.getTitle();
		System.out.println("page title is :" + title);
		Assert.assertEquals(title, "noon.com - Online Shopping in UAE | "
				+ "Fashion, electronics, beauty, baby products and more");
	}
	@Test
	public void noonsigninTest(){
		Assert.assertTrue(driver.findElement(By.cssSelector("span.userText")).isDisplayed());
	}
	
	
	
	
}
