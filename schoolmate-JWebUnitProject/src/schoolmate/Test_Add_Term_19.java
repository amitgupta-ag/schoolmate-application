package schoolmate;

import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.htmlunit.HtmlUnitElementImpl;
import net.sourceforge.jwebunit.junit.WebTester;

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
 public class Test_Add_Term_19 extends Globals{
	
	WebTester tester;
	
	public String subject = "Terms";	
	public String pageName = "Add New Term";	
	public String form = "terms";	
	public String page = "1";	
	public String page2 = "8";	
		
	
	@Before
	public void prepare(){
		tester = new WebTester();
		tester.setBaseUrl(baseUrl);
	}
	
	@Test
	public void pageAndPage2(){
		tester.beginAt("/index.php");
		tester.setTextField("username", "test");	
		tester.setTextField("password", "test");	
		tester.submit();
		
		tester.assertMatch("Manage Classes");
		
		tester.clickLinkWithText(subject);		
		tester.assertMatch("Manage " + subject);
		tester.setWorkingForm(form);
		
		tester.setTextField("page", page + " '> <a href=\"hacker.it\">malicious link page</a><br '");
		tester.setTextField("page2", page2 + " '> <a href=\"hacker.it\">malicious link page2</a><br '");

		addSubmitButton("//form[@name='"+form+"']");
		tester.submit();
		
		tester.assertMatch(pageName);
		myAssertLink(tester, "malicious link page");
		myAssertLink(tester, "malicious link page2");		
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