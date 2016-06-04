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
 public class Test_Add_Attendance_13 extends Globals{
  
  WebTester tester;
  
  public String user = "test";  
  public String pass = "test";
  public String landingPageAssert = "Manage Classes";

  public String page = "1";  
  public String page2 = "31";  

  public String optionSemester = "semester";
  public String optionSemesterValue = "1'> <a href=\"hacker.it\">malicious link semester</a><br '";
  public String optionStudent = "student";
  public String optionStudentValue = "1'> <a href=\"hacker.it\">malicious link student</a><br '";
  
  public String form = "registration";  
  public String link = "Attendance";
  public String pageName = "Add New Attendance Record";  
    
  
  @Before
  public void prepare(){
    tester = new WebTester();
    tester.setBaseUrl(baseUrl);
}
  
  @Test
  public void pageAndPage2(){
    tester.beginAt("/index.php");
    tester.setTextField("username", user);
    tester.setTextField("password", pass);
    tester.submit();
    
    tester.assertMatch(landingPageAssert);    
    
    tester.clickLinkWithExactText(link);
    tester.assertMatch(link);

    tester.setWorkingForm(form);
    
    tester.setHiddenField("page", page + " '> <a href=\"hacker.it\">malicious link page</a><br '");
    tester.setHiddenField("page2", page2 + " '> <a href=\"hacker.it\">malicious link page2</a><br '");
    tester.getElementByXPath("//select[@name='"+optionSemester+"']/option").setAttribute("value", optionSemesterValue);
    tester.getElementByXPath("//select[@name='"+optionStudent+"']/option").setAttribute("value", optionStudentValue);

    addSubmitButton("//form[@name='"+form+"']");
    tester.submit();
    
    tester.assertMatch(pageName);
	myAssertLink(tester, "malicious link page");
	myAssertLink(tester, "malicious link page2");
    assertMatch(tester, "malicious link semester");
    assertMatch(tester, "malicious link student");
      
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