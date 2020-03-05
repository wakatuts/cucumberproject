package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import dataProviders.ConfigFileReader;
import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	ConfigFileReader configFileReader;
	private final String url;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		configFileReader = FileReaderManager.getInstance().getConfigFileReader();
		url = configFileReader.getUrl();
	}
	
	@FindBy(how = How.CLASS_NAME, using = "noo-search")
	private WebElement icon_Search;
	
	@FindBy(how = How.CLASS_NAME, using = "form-control")
	private WebElement txtbx_Search;
	
	public void perform_Search(String search) {
		icon_Search.click();
		txtbx_Search.sendKeys(search);
		txtbx_Search.sendKeys(Keys.ENTER);
	}
	
	public void navigateTo_HomePage() {
		 driver.get(url);
	}
}
