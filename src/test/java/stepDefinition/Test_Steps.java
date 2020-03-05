package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Test_Steps {
	
	private static WebDriver driver = null;
	private static WebDriverWait wait = null;
	
	
	@Given("^User is on Home Page$")
	public void User_is_on_Home_Page() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","E:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
		 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024, 768));
        wait = new WebDriverWait(driver, 10);
 
        //Launch the Online Store Website
 
        driver.get("http://www.store.demoqa.com");
	}
	
	@Given("^Dismiss Link is deleted First$")
	public void user_Click_Dismiss_Link() throws Throwable {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dismiss")));
        driver.findElement(By.linkText("Dismiss")).click();
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		
        driver.findElement(By.linkText("My Account")).click();
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_UserName_and_Password(String username, String password) throws Throwable {

        driver.findElement(By.id("username")).sendKeys(username); 
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
	}
	
	@When("^User enters Credentials to LogIn$")
	public void user_enters_credentials(DataTable userCredentials) {
		List<List<String>> data = userCredentials.asLists(String.class);
		String userName = data.get(0).get(0);
		String passWord = data.get(0).get(1);
        driver.findElement(By.id("username")).sendKeys(userName); 
        driver.findElement(By.id("password")).sendKeys(passWord);
        driver.findElement(By.name("login")).click();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {

        System.out.println("Login Successfully");
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		
        driver.findElement (By.linkText("Logout")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {

        System.out.println("LogOut Successfully");
        driver.quit();
	}

}
