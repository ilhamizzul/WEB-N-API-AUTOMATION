package web.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/web/features",
        glue = {"web/stepdefinitions", "web/hooks"},
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:target/index.html"
        },
        monochrome = true
)
@Test(groups = {"web"})
public class TestRunner extends AbstractTestNGCucumberTests {
        @Test(groups = {"web"})
        public void runCucumberTests() {
                // This method is intentionally left empty because Cucumber tests are executed
                // by extending AbstractTestNGCucumberTests and do not require additional logic here.
        }
}
