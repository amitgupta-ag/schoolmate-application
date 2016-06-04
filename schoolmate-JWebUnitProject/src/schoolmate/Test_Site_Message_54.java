package schoolmate;

import org.junit.*;
import net.sourceforge.jwebunit.junit.*;

/**
 * @author AmitGupta
 *
 */
 public class Test_Site_Message_54  extends Globals {

	private WebTester tester;
	private String previousValue;
	
	@Before
	public void prepare(){
		tester = new WebTester();
		tester.setBaseUrl(baseUrl);
	}
	
	@Test
	public void test(){
		tester.beginAt("/index.php");
		tester.setTextField("username", "schoolmate");	
		tester.setTextField("password", "schoolmate");	
		tester.submit();
		
		tester.assertTitleEquals("SchoolMate - UNITN");
		tester.clickLinkWithText("School");
		
		tester.assertMatch("Manage School Information");
		previousValue = tester.getElementByXPath("html//textarea[@name='sitetext']").getTextContent();
		
		tester.setTextField("sitetext", "original message <a href=http://unitn.it>malicious link</a>");
		tester.clickButtonWithText(" Update ");
		
		tester.clickLinkWithText("Log Out");
		
		tester.assertMatch("Today's Message");
		myAssertLink(tester, "malicious link");
//		tester.assertLinkNotPresentWithText("malicious link");
		
	}
	
	@After
	public void cleanUp(){
		if (previousValue!= null) {
			tester.beginAt("/index.php");
			tester.setTextField("username", "schoolmate");	
			tester.setTextField("password", "schoolmate");	
			tester.submit();
			
			tester.assertTitleEquals("SchoolMate - UNITN");
			tester.clickLinkWithText("School");
			
			tester.assertMatch("Manage School Information");
			tester.setTextField("sitetext", previousValue);
			tester.clickButtonWithText(" Update ");
		}
	}
	
}



