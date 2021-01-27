package TestNgSessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KholsTest extends BaseTest {

	@Test
	public void KholsTitleTest() {
		driver.get("https://www.kohls.com/");
		String title = driver.getTitle();
		System.out.println("page title is :" + title);
		Assert.assertEquals(title, "Kohl's | Shop Clothing, Shoes, Home, Kitchen, Bedding, Toys & More");
	}
	
	@Test
	public void kholsSearchTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isDisplayed());
	}

	@Test
	public void kholsAccountTest(){
		Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Account']")).isDisplayed());
	}
}
