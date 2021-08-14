package com.nilesh.lib.config;

import com.nilesh.lib.exception.FrameworkException;
import com.nilesh.lib.util.Utility;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/*
 *  author : Nilesh Pawar
 * */
public final class TestScenario {
    private Scenario scenario;
    private final WebDriver driver;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public TestScenario() {
        this.driver = new DriverUtil().getDriverInstance();
    }

    public void setCucumberScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeAndQuitBrowser() {
        driver.close();
        driver.quit();
    }

    private File takeScreenShot() {
        File desFile = new File("./target/" + Utility.getScreenshotFileName());
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, desFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FrameworkException("Could not take screenshot : " + e.getMessage());
        }
        return desFile;
    }

    public void cucumberResultLog(String logMessage) {
        scenario.log(logMessage);
    }

    public void attachScreenShotToCucumberResult() {
        File screenshotFile = takeScreenShot();
        scenario.attach(screenshotFile.getPath().getBytes(), "DEFAULT", "DEFAULT");
    }
}
