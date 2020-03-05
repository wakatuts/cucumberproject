package stepDefinition;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	TestContext testContext;
	
	public Hooks(TestContext context) {
		
		testContext = context;
	}
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
		testContext.getWebDriverManager().closeDriver();
	}

}
