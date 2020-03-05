package stepDefinition;


import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import pageObjects.HomePage;


public class HomePageSteps {
	
	TestContext testContext;
	HomePage home;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		home = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("user is on Home Page")
	public void user_is_on_Home_Page() {
		home.navigateTo_HomePage();

	}

	@When("he search for {string}")
	public void he_search_for_dress(String dress) {
		home.perform_Search(dress);
	}

}
