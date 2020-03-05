package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll(@FindBy(how = How.XPATH, using = "//td[@class=\'woocommerce-table__product-name product-name\']/a"))
	private List<WebElement> prd_List;
	
	public List<String> getProductNames(){
		List<String> productNames = new ArrayList<String>();
		for(WebElement element : prd_List) {
			productNames.add(element.getText());
		}
		return productNames;
	}
}
