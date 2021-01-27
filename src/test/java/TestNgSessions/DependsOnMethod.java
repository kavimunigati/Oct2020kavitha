package TestNgSessions;

import org.testng.annotations.Test;
// The DependsOnMethod is applied when we w
//have a suite if test cases to run  and one of it fails and donot want the rest to run,
// example, if the amazon tille test fails, we do not want the search and filter to run.
// only of the title case passesthen the rest will be executed.
public class DependsOnMethod {
	@Test(priority =1)
	public void amazonTitleTest() {
		System.out.println("get the amazon title and verify");
	}

	@Test(priority =2, dependsOnMethods ="amazonTitleTest")
	public void amazonSearchTest() {
		System.out.println("amazon Search test");
	}

	@Test(priority =3,dependsOnMethods ="amazonTitleTest")
	public void amazonFilterTest() {
		System.out.println(" amazon Filter test");
	}
}
