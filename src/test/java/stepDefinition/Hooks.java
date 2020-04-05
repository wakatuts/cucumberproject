package stepDefinition;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.FileReaderManager;

public class Hooks {
	
	TestContext testContext;
	private static final String CUCUMBER_REPORTING_CONFIG_FILE="cucumber.reporting.config.file"; 
	
	public Hooks(TestContext context) {
		
		testContext = context;
	}
	
	@Before
	public void setUp() {
		
		//Set Cucumber Property Location
		System.setProperty(CUCUMBER_REPORTING_CONFIG_FILE, FileReaderManager.getInstance().getConfigFileReader().getCucumberConfigFile());
		
	}
	
	@After
	public void tearDown() {
		
		testContext.getWebDriverManager().closeDriver();
	}

}
