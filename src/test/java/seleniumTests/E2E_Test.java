package seleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E_Test {
	
	
	 private static WebDriver driver;
	 
	 public static void main(String[] args) throws Exception{
	 System.setProperty("webdriver.chrome.driver","E:\\webdriver\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("http://www.shop.demoqa.com");
	 
	 driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");
	 
	 
	 List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
	 items.get(0).click();
	 
	 Select colorDropdown = new Select(driver.findElement(By.id("pa_color")));
	 colorDropdown.selectByVisibleText("White");

	 Select sizeDropdown = new Select(driver.findElement(By.id("pa_size")));
	 sizeDropdown.selectByVisibleText("Medium");
	
	 WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
	 addToCart.click(); 
	 
	 
	 WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
	 cart.click();
	 
	 WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
	 continueToCheckout.click(); 
	 
	 
	 Thread.sleep(5000);
	 WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
	 firstName.sendKeys("Lakshay");
	 
	 WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
	 lastName.sendKeys("Sharma");
	 
	 WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
	 emailAddress.sendKeys("test@gmail.com");
	 
	 WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
	 phone.sendKeys("07438862327");
	 
	 Select countryDropDown = new Select(driver.findElement(By.id("billing_country")));
	 countryDropDown.selectByVisibleText("India");
	 
//	 WebElement countryDropDown = driver.findElement(By.cssSelector(".select2-selection__arrow"));
//	 countryDropDown.click();
//	 Thread.sleep(2000);
//	 
//	 List<WebElement> countryList = driver.findElements(By.cssSelector(".select2-results ul li"));
//	 for(WebElement country : countryList){
//	 if(country.getText().equals("India")) {
//	 country.click(); 
//	 Thread.sleep(3000);
//	 break;
//	 } 
//	 }

	 WebElement city = driver.findElement(By.cssSelector("#billing_city"));
	 city.sendKeys("Delhi");
	 
	 WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
	 address.sendKeys("Shalimar Bagh");
	 
	 WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
	 postcode.sendKeys("110088"); 
	 
//	 WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
//	 shipToDifferetAddress.click();
//	 Thread.sleep(3000);
	 
//	 List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
//	 paymentMethod.get(0).click();
	 
	 Select stateDropdown = new Select(driver.findElement(By.id("billing_state")));
	 stateDropdown.selectByVisibleText("Delhi");
	 WebElement acceptTC = null;
	 
	 try {
		 
		 acceptTC = driver.findElement(By.id("terms"));
		 acceptTC.click();
		 
	} catch (StaleElementReferenceException e) {
		 
		System.out.println("Stale Element!");
		
	} finally {
		 acceptTC = driver.findElement(By.id("terms"));
		 acceptTC.click();
	}
	 
	 WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
	 placeOrder.submit();
	 
	 driver.quit();
	 
	 }

}
