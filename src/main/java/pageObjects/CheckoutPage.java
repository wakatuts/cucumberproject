package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import selenium.Wait;
import testDataTypes.Customer;

public class CheckoutPage {
	
	WebDriver driver;
	Select selectObject_BillingCountry;
	Select selectObject_BillingState;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = "#billing_first_name")
	private WebElement txtbx_FirstName;
	
	@FindBy(how = How.CSS, using = "#billing_last_name")
	private WebElement txtbx_LastName;
	
	@FindBy(how = How.CSS, using = "#billing_email")
	private WebElement txtbx_Email;
	
	@FindBy(how = How.CSS, using = "#billing_phone")
	private WebElement txtbx_Phone;
	
	@FindBy(how = How.ID, using = "billing_country")
	private WebElement drpdwn_Country;
	
	@FindBy(how = How.CSS, using  = "#billing_city")
	private WebElement txtbx_City;
	
	@FindBy(how = How.CSS, using  = "#billing_address_1")
	private WebElement txtbx_Address1;
	
	@FindBy(how = How.CSS, using  = "#billing_postcode")
	private WebElement txtbx_PostCode;
	
	@FindBy(how = How.ID, using = "billing_state")
	private WebElement drpdwn_State;
	
	@FindBy(how = How.ID, using = "terms")
	private WebElement chkbx_AcceptTermsAndCondition;
	
	@FindBy(how = How.CSS, using = "#place_order") 
	private WebElement btn_PlaceOrder;
	
	public void enter_FirstName(String firstName) {
		txtbx_FirstName.sendKeys(firstName);
	}
	
	public void enter_LastName(String lastName) {
		txtbx_LastName.sendKeys(lastName);
	}
	
	public void enter_Email(String email) {
		txtbx_Email.sendKeys(email);
	}
	
	public void enter_Phone(String phone) {
		txtbx_Phone.sendKeys(phone);
	}
	
	public void enter_City(String city) {
		txtbx_City.sendKeys(city);
	}
	
	public void select_Country(String country) {
		selectObject_BillingCountry = new Select(drpdwn_Country);
		selectObject_BillingCountry.selectByVisibleText(country);
	}

	public void enter_Address1(String address1) {
		txtbx_Address1.sendKeys(address1);
	}
	
	public void enter_PostCode(String postCode) {
		txtbx_PostCode.sendKeys(postCode);
	}
	
	public void select_BillingState(String billingState) {
		selectObject_BillingState = new Select(drpdwn_State);
		selectObject_BillingState.selectByVisibleText(billingState);
	}
	
	public void tick_TermsAndCondition(boolean value) {
		if (value) {
			chkbx_AcceptTermsAndCondition.click();
		}
	}
	
	public void click_PlaceOrder() {
		btn_PlaceOrder.submit();
		 Wait.untilJqueryIsDone(driver);
		 Wait.untilPageLoadComplete(driver);
	}
	
	/*
	 * !Encapsulated keywords start here!
	 * 
	 */
	
	public void populateDefault_PersonalDetails(Customer customer) {
		 enter_FirstName(customer.firstName);
		 enter_LastName(customer.lastName);
		 enter_Phone(customer.phoneNumber.mob);
		 enter_Email(customer.emailAddress);
		 select_Country(customer.address.country);
		 enter_City(customer.address.city);
		 enter_Address1(customer.address.streetAddress);
		 enter_PostCode(customer.address.postCode);
		 select_BillingState(customer.address.state);
	}
}
