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
 public class Test_Edit_Grade_76  extends Globals {
  
  WebTester tester;
  
  public String user = "professor";  
  public String pass = "professor";
  public String landingPageAssert = "Steve Jobs's Classes";

  public String page = "2";  
  public String page2 = "7";  
  public String selectclass = "1";  
  public String optionName = "assignment";
  public String optionValue = "1'\") /> <a href='hacker.it'>malicious link assignment</a> <mac(\"'";
  public String checkBoxValue = "1'\") /> <a href='hacker.it'>malicious link checkBox</a> <mac(\"'";
  
  public String form = "grades";  
  public String link = "Grades";
  public String pageName = "Edit Grade";  
    
  
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

    tester.clickLinkWithExactText("Presentation Skills");
    tester.assertMatch("Class Settings");
    
    tester.clickLinkWithExactText(link);
    tester.assertMatch(link);

    tester.setWorkingForm(form);
    
    tester.checkCheckbox("delete[]");
    tester.setHiddenField("page", page + " '> <a href=\"hacker.it\">malicious link page</a><br '");
    tester.setHiddenField("page2", page2 + " '> <a href=\"hacker.it\">malicious link page2</a><br '");
    tester.setTextField("selectclass", selectclass + " '> <a href=\"hacker.it\">malicious link selectclass</a><br '");
    tester.getElementByXPath("//input[@name='delete[]']").setAttribute("value", checkBoxValue);
    tester.getElementByXPath("//select[@name='"+optionName+"']/option").setAttribute("value", optionValue);

    addSubmitButton("//form[@name='"+form+"']");
    tester.submit();
    
    tester.assertMatch(pageName);
    assertMatch(tester, "malicious link page");
    assertMatch(tester, "malicious link page2");
    assertMatch(tester, "malicious link checkBox");
    assertMatch(tester, "malicious link assignment");
    assertMatch(tester, "malicious link selectclass");
      
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