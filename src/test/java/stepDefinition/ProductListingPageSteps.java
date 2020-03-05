package stepDefinition;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;
import pageObjects.ProductListingPage;

public class ProductListingPageSteps {
	
	TestContext testContext;
	ProductListingPage productListingPage;
	
	public ProductListingPageSteps (TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}
	
	@When("choose to buy the first item")
	public void choose_to_buy_the_first_item() {
		String productName = productListingPage.getProductName(0); 
		testContext.getScenarioContext().setContext(Context.PRODUCT_NAME, productName);
		productListingPage.select_Product(0);
	}
	
	@When("selects {string} color and {string} size")
	public void selects_color_and_size(String color, String size) {
		
		productListingPage.select_Color(color);
		productListingPage.select_Size(size);
		productListingPage.click_AddToCart();
	}

}
