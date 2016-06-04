package schoolmate;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author AmitGupta
 *
 */
 public class Test_Manage_Assignments_207  extends Globals {
	
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

		String title = "<a href=\"#\">MAL CODE";				
		createHTMLinDB(title, "MAL CODE");		

		tester.assertButtonPresentWithText("Login");		
		tester.setTextField("username", "professor");	
		tester.setTextField("password", "professor");	
		tester.submit();
		
		tester.assertMatch("Steve Jobs's Classes");
		tester.clickLinkWithText("MAL CODE");
		tester.assertMatch("Class Settings");		

		tester.clickLinkWithExactText("Assignments");
		tester.assertMatch("Manage Assignments");		
		tester.assertMatch("MAL CODE");		

		tester.clickLinkWithText("Log Out");
		tester.assertButtonPresentWithText("Login");
		tester.assertMatch("Today's Message");			

	}

	@After
	 public void cleanUpMalValues(){

		String title = "Presentation Skills";
		createHTMLinDB(title, title);		 		
	 }

			
	private void createHTMLinDB(String title, String check) {

		tester.assertButtonPresentWithText("Login");		
		tester.setTextField("username", "test");	
		tester.setTextField("password", "test");	
		tester.submit();
		
		tester.assertMatch("Manage Classes");
		tester.setWorkingForm(form);
		tester.checkCheckbox(checkbox);
		tester.clickButtonWithText("Edit");

		tester.setWorkingForm("editclass");
		tester.setTextField("title", title);
		tester.clickButtonWithText("Edit Class");
		
		tester.assertMatch("Manage Classes");
		tester.assertMatch(check);

		tester.clickLinkWithText("Log Out");
		tester.assertButtonPresentWithText("Login");
		tester.assertMatch("Today's Message");			

	}
	
}