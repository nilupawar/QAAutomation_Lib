package com.practice.nilesh.core;

import com.practice.nilesh.util.TestCase;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {
    public Scenario scenario;
    private TestCase testCase;

    @Before(order = 0)
    public void initialiseTest(Scenario scenario) {
        this.scenario = scenario;
        this.testCase.setCucumberScenarioTags(scenario);
    }

    public CucumberHooks(TestCase testCase) {
        this.testCase = testCase;
        System.out.println("Pico container called : " + testCase.hashCode());
    }
}
