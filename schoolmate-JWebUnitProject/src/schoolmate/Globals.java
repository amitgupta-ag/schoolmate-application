package schoolmate;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 * @author AmitGupta
 * Notes:
 * This class provides the baseUrl on which schoolmate application is running.
 * if the vulnerabilities are fixed in the code then initialize the 'fixed' flag to be true, else false.
 */
 public class Globals {

	boolean fixed = true; //is true when you run the tests on fixed PHP code base
	String baseUrl = "http://192.168.2.13/"; //CHANGE THIS TO YOUR HOST URL
	
	//assertMatch string
	public void assertMatch (WebTester tester, String s) {
		if(fixed){
			tester.assertNoMatch(s);
		}
		else{
			tester.assertMatch(s);
		}		
	}

	//assert link present on a specific text
	public void myAssertLink (WebTester tester, String s) {
		if(fixed){
			tester.assertLinkNotPresentWithText(s);
		}
		else{
			tester.assertLinkPresentWithExactText(s);
		}		
	}

}
