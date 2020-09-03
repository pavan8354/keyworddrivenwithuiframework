package Com.Qa.Test;

import org.testng.annotations.Test;


import com.qa.hubspot.keyword.engine.keywordengine;

/*
 * 
 * @author pavan g
 * 
 * 
 * 
 */

public class LoginTest {
	
	public keywordengine keyWordEngine;	
	@Test
	public void loginTest_Scenario() {
		
		keyWordEngine = new keywordengine();
		keyWordEngine.startexecution("login");		
	}
	@Test
	public void signupTest_Scenario() {
		
		keyWordEngine = new keywordengine();
		keyWordEngine.startexecution("login1");		
	}
}
