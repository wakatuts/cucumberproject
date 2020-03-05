package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null) {
			return driverPath;
		} else {
			throw new RuntimeException("driverPath not specified in the Configuration.properties file");
		}
	}
	
	public int getImplicitlyWait() {
		String implicitlyWaitString = properties.getProperty("implicitlyWait");
		if (implicitlyWaitString != null) {
			return Integer.parseInt(implicitlyWaitString);
		} else {
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file");
		}
	}
	
	public String getUrl() {
		String url = properties.getProperty("url");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("url not specified in the Configuration.properties file");
		}
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName.equals("chrome")) {
			return DriverType.CHROME;
		} else if (browserName.equals("firefox")) {
			return DriverType.FIREFOX;
		} else if (browserName.equals("edge")) {
			return DriverType.EDGE;
		} else {
			throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
		}
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName.equalsIgnoreCase("local")) {
			return EnvironmentType.LOCAL;
		} else if (environmentName.equalsIgnoreCase("remote")){
			return EnvironmentType.REMOTE;
		} else if (environmentName.equalsIgnoreCase("cloud")) {
			return EnvironmentType.CLOUD;
		}else {
			throw new RuntimeException("Environment Name Key value in Configuration.properties is not matched : " + environmentName);
		}
	}
	
	public Boolean isBrowserMaximumSize() {
		String isWindowMaximize = properties.getProperty("isWindowMaximize");
		return Boolean.parseBoolean(isWindowMaximize);
	}
	
	public String getTestDataResourcePath(){
		
		 String testDataResourcePath = properties.getProperty("testDataResourcePath");
		 if(testDataResourcePath!= null) return testDataResourcePath;
		 else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath"); 
	}
}
