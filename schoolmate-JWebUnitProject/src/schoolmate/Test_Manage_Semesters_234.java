package schoolmate;

import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.htmlunit.HtmlUnitElementImpl;
import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.helpers.AttributesImpl;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.InputElementFactory;

/**
 * @author AmitGupta
 *
 */
 public class Test_Manage_Semesters_234  extends Globals {
	
	WebTester tester;
	
	public String form = "terms";	
	public String button = "Edit";	
	public String checkbox = "delete[]";	
	

	@Before
	public void prepare(){
		tester = new WebTester();
		tester.setBaseUrl(baseUrl);
	}
	
	@Test
	public void pageAndPage2(){

		tester.beginAt("/index.php");

		String title = "<a href=\"#\">MAL";

		createHTMLinDB(title, "MAL");		

		tester.clickLinkWithText("Semesters");
		tester.assertMatch("Manage Semesters");
		myAssertLink(tester, "MAL");

		tester.clickLinkWithText("Log Out");
		tester.assertButtonPresentWithText("Login");
		tester.assertMatch("Today's Message");			

	}

	@After
	 public void cleanUpMalValues(){

		String title = "Summer";
		createHTMLinDB(title, title);		 		
	 }

			
	private void createHTMLinDB(String title, String check) {

		tester.assertButtonPresentWithText("Login");		
		tester.setTextField("username", "test");	
		tester.setTextField("password", "test");	
		tester.submit();
		
		tester.assertMatch("Manage Classes");

		tester.clickLinkWithExactText("Terms");
	    tester.assertMatch("Manage Terms");		

	    tester.setWorkingForm(form);
		
	    tester.setTextField("page", "1");
	    tester.setTextField("page2", "12");
	    tester.setTextField("delete[]", "1");
		tester.checkCheckbox(checkbox);

	    addSubmitButton("//form[@name='"+form+"']");
	    tester.submit();		
		
		tester.assertMatch("Edit Term");

		tester.setWorkingForm("editterm");
		tester.setTextField("title", title);
		tester.clickButtonWithText("Edit Term");
		
		tester.assertMatch("Manage Terms");
		tester.assertMatch(check);

	}

	private void addSubmitButton(String fromXpath) {
		IElement element = tester.getElementByXPath(fromXpath);
		DomElement form = ((HtmlUnitElementImpl)element).getHtmlElement();
		InputElementFactory factory = InputElementFactory.instance;
		AttributesImpl attributes = new AttributesImpl();
		attributes.addAttribute("", "", "type", "", "submit");
		HtmlElement submit = factory.createElement(form.getPage(), "input", attributes);
		form.appendChild(submit);
	}	
}