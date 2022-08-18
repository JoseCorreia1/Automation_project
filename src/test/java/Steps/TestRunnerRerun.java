package Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed_scenarios.txt",
        monochrome = true,
        glue = {"Steps"},
        plugin = {
                "pretty",
                "json:target1/cucumber.json",
                "html:target1/cucumber-reports/cucumber-html-report",
                "rerun:target1/failed_scenarios.txt"
        })
public class TestRunnerRerun {
}
