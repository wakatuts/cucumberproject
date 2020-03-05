package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductListingPage {
	
	WebDriver driver;
	Select selectObject_Color;
	Select selectObject_Size;

	public ProductListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
	private WebElement btn_AddToCart;
	
	@FindBy(how = How.CSS, using = ".noo-product-inner")
	private List<WebElement> prd_List;
	
	@FindBy(how = How.ID, using  = "pa_color")
	private WebElement drpdwn_Color;
	
	@FindBy(how = How.ID, using  = "pa_size")
	private WebElement drpdwn_Size;
	
	public void click_AddToCart() {
		btn_AddToCart.click();
	}
	
	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
	}
	
	 public String getProductName(int productNumber) {
		 return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
	}
	
	public void select_Color(String color) {
		selectObject_Color = new Select(drpdwn_Color);
		selectObject_Color.selectByVisibleText(color);
	}
	
	public void select_Size(String size) {
		selectObject_Size = new Select(drpdwn_Size);
		selectObject_Size.selectByVisibleText(size);
	} 
}
