package schoolmate;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author AmitGupta
 *
 */
 public class Test_View_Students_164  extends Globals {
	
	WebTester tester;
	
	public String form = "classes";	
	public String button = "Edit Class";	
	public String checkbox = "delete[]";	
		
	
	@Before
	public void prepare(){
		tester = new WebTester();
		tester.setBaseUrl(baseUrl);
	}
	
	@Test
	public void pageAndPage2(){

		tester.beginAt("/index.php");

		String fname = "<a href=\"#\">fMC";				
		String lname = "<a href=\"#\">lMC";				
		createHTMLinDB(fname, lname, "fMC", "lMC");		

		tester.assertButtonPresentWithText("Login");		
		tester.setTextField("username", "professor");	
		tester.setTextField("password", "professor");	
		tester.submit();
		
		tester.assertMatch("Steve Jobs's Classes");
		tester.clickLinkWithText("Presentation Skills");

		tester.assertMatch("Class Settings");
		tester.clickLinkWithText("Students");
		
		tester.assertMatch("Students");
		tester.assertMatch("fMC lMC");

		tester.clickLinkWithText("Log Out");
		tester.assertButtonPresentWithText("Login");
		tester.assertMatch("Today's Message");			

	}

	@After
	 public void cleanUpMalValues(){

		String fname = "Alice";				
		String lname = "Gupta";				
		createHTMLinDB(fname, lname, fname, lname);		

	 }
			
	private void createHTMLinDB(String fname, String lname, String fcheck, String lcheck) {

		tester.assertButtonPresentWithText("Login");		
		tester.setTextField("username", "test");	
		tester.setTextField("password", "test");	
		tester.submit();
		
		tester.assertMatch("Manage Classes");

		tester.clickLinkWithExactText("Students");
		tester.assertMatch("Manage Students");

		tester.setWorkingForm("students");
		tester.checkCheckbox(checkbox);
		tester.clickButtonWithText("Edit");

		//assert edit student
		tester.assertMatch("Edit Student");		
		tester.setWorkingForm("editstudent");
		
		tester.setTextField("fname", fname);
		tester.setTextField("lname", lname);
		tester.clickButtonWithText("Edit Student");
		
		tester.assertMatch("Manage Students");
		tester.assertMatch(fcheck);
		tester.assertMatch(lcheck);

		tester.clickLinkWithText("Log Out");
		tester.assertButtonPresentWithText("Login");
		tester.assertMatch("Today's Message");			

	}
	
}