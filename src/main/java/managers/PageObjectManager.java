package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private HomePage homePage;
	private ProductListingPage productListingPage;
	private ConfirmationPage confirmationPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;		
	}
	
	public CartPage getCartPage() {
		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
	}
	
	public CheckoutPage getCheckoutPage() {
		return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
	}

	public ProductListingPage getProductListingPage() {
		return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;
	}
	
	public ConfirmationPage getConfirmationPage() {
		return (confirmationPage == null) ? confirmationPage = new ConfirmationPage(driver) : confirmationPage;
	}
}
