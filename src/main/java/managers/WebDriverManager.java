package managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import dataProviders.ConfigFileReader;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
	private WebDriver driver;
	private ConfigFileReader configFileReader = FileReaderManager.getInstance().getConfigFileReader();
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public WebDriverManager() {
		driverType = configFileReader.getBrowser();
		environmentType = configFileReader.getEnvironment();
	}
	
	public WebDriver getDriver() {
		if (driver == null) {
			driver = createDriver();
		}
		return driver;
	}
	
	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL: driver = createLocalDriver();
			break;
		case REMOTE: driver = createRemoteDriver();
			break;
		case CLOUD: driver = createCloudDriver();
		break;

		}
		return driver;
	}
	
	private WebDriver createRemoteDriver() {
		String hostName = configFileReader.getHostName();
		switch (driverType) {
		case FIREFOX: 
			throw new RuntimeException("FireFoxRemoteDriver is not yet implemented");
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, configFileReader.getDriverPath());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			
			if(configFileReader.isHeadlessMode()) {
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--disable-gpu");
			}

			if (configFileReader.isBrowserMaximumSize()) {
				chromeOptions.addArguments("--window-size=1920,1080");			
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://"+hostName+"/:4444/wd/hub"), chromeOptions);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			break;
		case EDGE: 
			throw new RuntimeException("EdgeRemoteDriver is not yet implemented");
		}
		return driver;
	}
	
	private WebDriver createCloudDriver() {
		throw new RuntimeException("CloudWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX: 
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, configFileReader.getDriverPath());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			
			if(configFileReader.isHeadlessMode()) {
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--disable-gpu");
			}

			if (configFileReader.isBrowserMaximumSize()) {
				chromeOptions.addArguments("--window-size=1920,1080");			
			}
			
			driver = new ChromeDriver(chromeOptions);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			break;
		case EDGE: 
			driver = new EdgeDriver();
			break;
		}
		return driver;
		
	}
	
	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}
