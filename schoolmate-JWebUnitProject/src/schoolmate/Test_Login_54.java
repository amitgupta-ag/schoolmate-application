package schoolmate;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author AmitGupta
 *
 */
 public class Test_Login_54  extends Globals {
	
	WebTester tester;
	
	public String user = "test";	
	public String pass = "test";	
	public String form = "info";	
	public String button = " Update ";	
	
	
	
	@Before
	public void prepare(){
		tester = new WebTester();
		tester.setBaseUrl(baseUrl);
	}
	
	@Test
	public void pageAndPage2(){

		String sitetext = "Welcome to UNITN <a href=\"hacker.it\">malicious link sitetext</a><br>";

		tester.beginAt("/index.php");
				
		createMalHTMLinDB(sitetext);

		myAssertLink(tester, "malicious link sitetext");

	}
	
	@After
	 public void cleanUpMalValues(){

		String sitetext = "Welcome to UNITN";

		createMalHTMLinDB(sitetext);
		 
		tester.assertNoMatch("malicious link sitetext");
		
	 }
	

	private void createMalHTMLinDB(String sitetext) {

		tester.assertButtonPresentWithText("Login");		
		tester.setTextField("username", user);	
		tester.setTextField("password", pass);	
		tester.submit();
		
		tester.assertMatch("Manage Classes");
		tester.clickLinkWithText("School");
		tester.assertMatch("Manage School Information");
		
		tester.setWorkingForm(form);
		tester.setTextField("sitetext", sitetext);

		tester.clickButtonWithText(button);

		tester.clickLinkWithText("Log Out");
		tester.assertButtonPresentWithText("Login");
		tester.assertMatch("Today's Message");			

	}
	
}