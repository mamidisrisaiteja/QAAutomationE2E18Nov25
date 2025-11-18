package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

@CucumberOptions(
        features="src\\test\\resources\\features",
        glue={"stepDefinitions"},
        plugin={"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Parameters("browser")
    @BeforeClass
    public void driverInit(String browser){
        DriverFactory.initBrowser(browser);
    }

}
