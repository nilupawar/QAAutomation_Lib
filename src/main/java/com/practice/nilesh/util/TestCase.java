package com.practice.nilesh.util;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    private List<String> scenarioIDs;
    private DriverUtil driverUtil;
    private WebDriver driver;

    public TestCase() {
        driverUtil = new DriverUtil();
    }

    public void setCucumberScenarioTags(Scenario scenario) {
        scenarioIDs = new ArrayList<>(scenario.getSourceTagNames());
    }

    public void setJunitScenarioTags() {
    }

    public WebDriver getDriver() {
        return driver;
    }
}
