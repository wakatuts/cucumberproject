package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\resources\\functionalTests"},
				 glue = {"stepDefinition"},
				 monochrome = true,
				 plugin = {"pretty", "html:target/cucumber-reports"})

public class TestRunner {

}
