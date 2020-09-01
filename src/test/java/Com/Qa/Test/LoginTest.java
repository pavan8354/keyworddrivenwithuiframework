package Com.Qa.Test;

import org.testng.annotations.Test;

import com.qa.hubspot.keyword.engine.keywordengine;

public class LoginTest {
	
	public keywordengine keyWordEngine;	
	@Test
	public void loginTest_Scenario() {
		
		keyWordEngine = new keywordengine();
		keyWordEngine.startexecution("login");		
	}
}
