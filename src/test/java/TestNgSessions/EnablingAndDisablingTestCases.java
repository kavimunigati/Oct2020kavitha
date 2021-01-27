package TestNgSessions;

import org.testng.annotations.Test;

// In a suite of test cases if we do not want to execute few then
//we can enable or disable those test cases example, 
//in the below test i want few tests to be executed and disable one.
// when we want to execute we can either make the enabled ="true or just remove the eneabl part.
public class EnablingAndDisablingTestCases {
	@Test(priority =1)
	public void amazonTitleTest() {
		System.out.println("get the amazon title and verify");
	}

	@Test(priority =2, enabled =false)
	public void amazonSearchTest() {
		System.out.println("amazon Search test");
	}

	@Test(priority =3, enabled =true)
	public void amazonFilterTest() {
		System.out.println(" amazon Filter test");
	}
}
