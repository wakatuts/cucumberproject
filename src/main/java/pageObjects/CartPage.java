package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.Wait;

public class CartPage {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = ".cart-button")
	private WebElement btn_Cart;
	
	@FindBy(how = How.CSS, using = ".checkout-button.alt")
	private WebElement btn_ContinueToCheckout;

	public void click_Cart() {
		btn_Cart.click();
	}
	
	public void click_ContinueToCheckout() {
		btn_ContinueToCheckout.click();
		Wait.untilJqueryIsDone(driver);
	}
}
