package com.nilesh.lib.core;

import com.nilesh.lib.config.TestScenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CucumberHooks {
    private Scenario scenario;
    private final TestScenario testScenario;
    private final Logger logger = LoggerFactory.getLogger(CucumberHooks.class);

    @Before(order = 0)
    public void initialiseTest(Scenario scenario) {
        logger.info("-------------------------------------------------------------------------------");
        logger.info("Starting execution for new test, having tags : '{}' ", scenario.getSourceTagNames());
        this.scenario = scenario;
        this.testScenario.setCucumberScenario(scenario);
    }

    @After(order = 0)
    public void cleanUp() {
        if (scenario.isFailed()) {
            testScenario.attachScreenShotToCucumberResult();
        }
        testScenario.closeAndQuitBrowser();
        logger.info("Test execution completed for test having tags : {} ", scenario.getSourceTagNames());
        logger.info("Test Status : {} ", scenario.getStatus());
        logger.info("-------------------------------------------------------------------------------");
    }

    public CucumberHooks(TestScenario testScenario) {
        this.testScenario = testScenario;
    }
}
