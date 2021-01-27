package TestNgSessions;

import org.testng.annotations.Test;



public class ExpectedExceptionsConcept {
	String name= "Tom";
	  
	@Test()
	public void divTest() {
		System.out.println("div test");
		int   i=5/1;
	}	
	
	//@Test
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
		public void divisionTest() {
			System.out.println("division Test");
             int j =7/0;
// this line will not be executed as the error is bypassed	
//Test fails as java.lang.ArithmeticException: / by zero, to ignore  this exception, 
//we have to give the  ArithmeticException.class; in the argumnet at the Test level, 
//now when we run, it will bypass this exception
	

ExpectedExceptionsConcept obj = new ExpectedExceptionsConcept();
obj = null; // creating the obj ref variable of ExpectedExceptionsConcept and assigning the value as null
System.out.println(obj.name); // throwws a null point eception , but when we add the exception as null point, it will be bypassed
System.out.println("divisible by 0 test");// this line will not be executed as the error is bypassed
			
		}
	}


