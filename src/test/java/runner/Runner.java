package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepdefinitions", plugin = "html:D:\\Rest Assured\\APIAutomation\\target\\reports\\result.html")
public class Runner {

}
