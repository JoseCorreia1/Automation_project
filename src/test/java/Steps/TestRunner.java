package Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",
        monochrome = true,
        glue = {"Steps"},
        tags = {"@uxt"},
        plugin = {
        "json:target/cucumber.json",
        "html:target/cucumber-html-report",
        "rerun:target/failed_scenarios.txt"
        }
)

public class TestRunner {

}
