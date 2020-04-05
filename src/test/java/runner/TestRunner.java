package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/functionalTests"},
				 glue = {"stepDefinition"},
				 monochrome = true,
				 //plugin = {"pretty", "html:target/cucumber-reports"}
				 plugin = {"pretty", "json:target/report.json", "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"})

public class TestRunner {

}
