package stepDefinition;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckOutPageSteps {
	
	TestContext testContext;
	CheckoutPage checkOutPage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	WebDriver driver;
	
	public CheckOutPageSteps (TestContext context) {
		testContext = context;
		checkOutPage = testContext.getPageObjectManager().getCheckoutPage();
	}
	
	@When("enter {string} personal details on checkout page")
	public void enter_personal_details_on_checkout_page(String customerName){
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		checkOutPage.populateDefault_PersonalDetails(customer);
	}
	
	@When("place the order")
	public void place_the_order() {
		
		 try {
			 
			checkOutPage.tick_TermsAndCondition(true);
			 
		} catch (StaleElementReferenceException e) {
			System.out.println("stale element!");
			
		} finally {
			checkOutPage.tick_TermsAndCondition(true);
		}
		 
		 checkOutPage.click_PlaceOrder();
		 
	}

}
