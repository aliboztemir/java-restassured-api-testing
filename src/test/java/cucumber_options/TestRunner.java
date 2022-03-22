package cucumber_options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"step_definitions"},
        tags = "@Positive",
        plugin = {"pretty", "html:target/cucumber-reports.html", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "json:target/cucumber-html-reports/cucumber.json"},
        monochrome = true
        // Can also be run from Maven using the following command:
        // mvn test -Dcucumber.options="--tags @Smoke or @Stress"
)
public class TestRunner {

}