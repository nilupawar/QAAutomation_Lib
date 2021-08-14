package com.nilesh.lib.config;

import com.nilesh.lib.types.BrowserName;
import com.nilesh.lib.util.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/*
 *  author : Nilesh Pawar
 * */
final class DriverUtil {
    private WebDriver driver;
    private BrowserName browserName;
    private Capabilities capabilities;
    private final Logger logger = LoggerFactory.getLogger(DriverUtil.class);

    public DriverUtil() {
        initialiseDriver();
        setTimeOut();
    }

    private void initialiseDriver() {
        if (TestConfig.getConfig("browserName").equalsIgnoreCase("CHROME")) {
            browserName = BrowserName.CHROME;
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else if (TestConfig.getConfig("browserName").equalsIgnoreCase("FIREFOX")) {
            browserName = BrowserName.FIREFOX;
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        } else if (TestConfig.getConfig("browserName").equalsIgnoreCase("EDGE")) {
            browserName = BrowserName.EDGE;
            WebDriverManager.iedriver().setup();
            this.driver = new EdgeDriver();
        }
        if (Boolean.getBoolean("maximiseBrowserWhenOpen")) {
            this.driver.manage().window().maximize();
            logger.debug("Browser maximised");
        }
    }

    private void setTimeOut() {
        int pageLoadTime = Utility.parseIntTestConfig("pageLoadTime");
        int objectLoadTime = Utility.parseIntTestConfig("objectLoadTime");
        driver.manage().timeouts().pageLoadTimeout(pageLoadTime * 1000L, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(objectLoadTime * 1000L, TimeUnit.MILLISECONDS);
        logger.info("Page load time is set to '{}', and object load time is set to '{}'", pageLoadTime, objectLoadTime);
    }


    BrowserName getBrowserName() {
        return browserName;
    }

    //TODO - Not completely implemented
    Capabilities getCapabilities() {
        return capabilities;
    }

    WebDriver getDriverInstance() {
        return driver;
    }

}
