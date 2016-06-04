package schoolmate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;



/**
 * @author AmitGupta
 *
 */
 public class Test_Manage_School_Info_92  extends Globals {
	
	WebTester tester;
	
	
	public String user = "test";  
	public String pass = "test";
	public String landingPageAssert = "Manage Classes";
	public String page = "1";  
	public String page2 = "1";  
	public String form = "info";    
	public String pageName = "Manage School Information";  
	public String malLink = "malAddress malPhone";


	
	
	@Before
	public void prepare(){
		tester = new WebTester();
		tester.setBaseUrl(baseUrl);
	}
	
	@Test
	public void pageAndPage2(){

		String address = "\\'><a href=\"hack.it\">malAddress malPhone</a><!--";
		String phone = "--><input \\'";
		
		tester.beginAt("/index.php");
				
		tester.assertButtonPresentWithText("Login");		
		tester.setTextField("username", user);	
		tester.setTextField("password", pass);	
		tester.submit();
		
		tester.assertMatch(landingPageAssert);
		tester.clickLinkWithText("School");
		tester.assertMatch(pageName);
		
		tester.setWorkingForm(form);

	    tester.setHiddenField("page", page + " '> <a href=\"hacker.it\">malicious link page</a><br '");
	    tester.setHiddenField("page2", page2 + " '> <a href=\"hacker.it\">malicious link page2</a><br '");
		tester.setTextField("schooladdress", address);
		tester.setTextField("schoolphone", phone);

	    tester.clickButtonWithText(" Update ");

		tester.assertMatch(pageName);
	    assertMatch(tester, "malicious link page");
	    assertMatch(tester, "malicious link page2");
		myAssertLink(tester, malLink);
		
		// To cleanup the HTML form and getting all the structure back (uncomented)
	    tester.clickButtonWithText(" Update ");

	}
	
	@After
	 public void cleanUpMalValues(){
		String address = "1,Street";
		String phone = "52365895";

		tester.assertMatch(pageName);

		tester.setWorkingForm(form);

		tester.setHiddenField("page", page);
	    tester.setHiddenField("page2", page2);
		tester.setTextField("schooladdress", address);
		tester.setTextField("schoolphone", phone);

	    tester.clickButtonWithText(" Update ");

		tester.assertMatch(address);
	    tester.assertMatch(phone);
		tester.assertLinkNotPresentWithExactText(malLink);
		tester.assertMatch(pageName);

	 }
		
	
}