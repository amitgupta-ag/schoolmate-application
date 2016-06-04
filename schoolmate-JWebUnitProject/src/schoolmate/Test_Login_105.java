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
 public class Test_Login_105  extends Globals {
	
	WebTester tester;
	
	public String user = "test";	
	public String pass = "test";	
	public String form = "info";	
	public String button = " Update ";	
	
	public String page = "0";  
	public String login = "0";

	
	
	@Before
	public void prepare(){
		tester = new WebTester();
		tester.setBaseUrl(baseUrl);
	}
	
	@Test
	public void pageAndPage2(){

		String sitemessage = "This is the Message of the day:- We think our fathers fools, so wise do we grow, no doubt our wisest sons would think us so. <a href=\"hacker.it\">malicious link sitemessage</a><br>";

		tester.beginAt("/index.php");
				
		createMalHTMLinDB(sitemessage);
		myAssertLink(tester, "malicious link sitemessage");

		tester.assertButtonPresentWithText("Login");		

		tester.setWorkingForm("login");	
		tester.setTextField("username", user);	
		tester.setTextField("password", pass);
		tester.setTextField("login", "0");
		tester.setHiddenField("page", "0 '> <a href=\"hacker.it\">malicious link dinky</a><br '");

		addSubmitButton("//form[@name='login']");
		tester.clickButtonWithText("Submit");
		
		tester.assertButtonPresentWithText("Login");				
		tester.assertMatch("Today's Message");			
		myAssertLink(tester, "malicious link dinky");
			
	}
	
	@After
	 public void cleanUpMalValues(){

		String sitemessage = "This is the Message of the day:- We think our fathers fools, so wise do we grow, no doubt our wisest sons would think us so.";

		createMalHTMLinDB(sitemessage);
		 
		tester.assertNoMatch("malicious link sitemessage");
		
	 }
	

	private void createMalHTMLinDB(String sitemessage) {

		tester.assertButtonPresentWithText("Login");		
		tester.setTextField("username", user);	
		tester.setTextField("password", pass);	
		tester.submit();
		
		tester.assertMatch("Manage Classes");
		tester.clickLinkWithText("School");
		tester.assertMatch("Manage School Information");
		
		tester.setWorkingForm(form);
		tester.setTextField("sitemessage", sitemessage);

		tester.clickButtonWithText(button);

		tester.clickLinkWithText("Log Out");
		tester.assertButtonPresentWithText("Login");
		tester.assertMatch("Today's Message");			

	}
	
	  private void addSubmitButton(String fromXpath) {
		    IElement element = tester.getElementByXPath(fromXpath);
		    DomElement form = ((HtmlUnitElementImpl)element).getHtmlElement();
		    InputElementFactory factory = InputElementFactory.instance;
		    AttributesImpl attributes = new AttributesImpl();
		    attributes.addAttribute("", "", "type", "", "submit");
		    attributes.addAttribute("", "", "value", "", "Submit");
		    HtmlElement submit = factory.createElement(form.getPage(), "input", attributes);
		    form.appendChild(submit);
	  }
	
	
}