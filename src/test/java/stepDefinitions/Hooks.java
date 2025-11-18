package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DriverFactory;
import utils.LogFactory;
import utils.ScreenShotUtils;

import java.io.IOException;

public class Hooks {
    private static Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp(io.cucumber.java.Scenario scenario) {
        // Read browser from system property or default to Chrome
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.initBrowser(browser);
    }



    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                ScreenShotUtils.getScreenShot(scenario.getName(), DriverFactory.getDriver());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        DriverFactory.quitDriver();
    }




}
