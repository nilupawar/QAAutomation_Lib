package com.practice.nilesh.util;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    private List<String> scenarioIDs;
    DriverUtil driverUtil = new DriverUtil();
    WebDriver driver = driverUtil.getDriverInstance();

    public void setCucumberScenarioTags(Scenario scenario) {
        scenarioIDs = new ArrayList<>(scenario.getSourceTagNames());
    }

    public void setJunitScenarioTags() {
    }
}
