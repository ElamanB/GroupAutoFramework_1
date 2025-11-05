package runners.healthcare_openmrs;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"src/test/resources/features/healthcare_openmrs"},
    glue = {"steps.healthcare_openmrs", "utilities"},
    plugin = {
        "pretty",
        "html:target/reports/healthcare-report.html",
        "json:target/reports/healthcare-report.json"
    },
    tags = "@Smoke",
    dryRun = false



)

public class HealthcareRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return(Object[][]) super.scenarios();
    }
}