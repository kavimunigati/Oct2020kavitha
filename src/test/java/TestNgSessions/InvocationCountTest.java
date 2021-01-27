package TestNgSessions;

import org.testng.annotations.Test;

public class InvocationCountTest {
// this invocationCount key word is used to execute a particular test case given number of times
// in the below example, i want to execute the same test case 10 times, so it is considered as 10 test cases.
	// we usually usethis for API'S where we want to execute to find the load or hit the same API over and over.

	@Test(invocationCount =10)
	public void amazonTitleTest() {
		System.out.println("get the amazon title and verify");
	}
	
}
