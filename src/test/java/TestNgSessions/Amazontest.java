package TestNgSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazontest {
	// We have to write the annotations
	//Annotaton is a key word starting with @
	//Every annotation should be associated with a method
	
@BeforeSuite
public void beforeSuite() {
	System.out.println("create DB connection");
}
@BeforeTest
public void beforeTest() {
	System.out.println("create a test user in DB");
}
@BeforeClass
public void beforeClass() {
	System.out.println("launch the browser");
}
@BeforeMethod
public void beforeMethod() {
	System.out.println("login to App");
}
// writing the test cases
//Test should always be started with @annotation

@Test(priority =1)
public void amazonTitleTest() {
	System.out.println("get the amazon title and verify");
}

@Test(priority =2)
public void amazonSearchTest() {
	System.out.println("amazon Search test");
}

@Test(priority =3)
public void amazonFilterTest() {
	System.out.println(" amazon Filter test");
}
//below are Post Conditions ----------> post steps are available when our test cases are done

@AfterMethod
public void afterMethod() {
	System.out.println("logout");
}
@AfterClass
public void afterClass() {
	System.out.println("Close the Browser");
}
@AfterTest
public void afterTest() {
	System.out.println("delete the Test user from DB");
}
@AfterSuite
public void afterSuite() {
	System.out.println("Disconnect with DB");
}
}
