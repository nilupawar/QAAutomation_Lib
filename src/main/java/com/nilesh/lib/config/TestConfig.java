package com.nilesh.lib.config;

import com.nilesh.lib.exception.FrameworkException;
import com.nilesh.lib.exception.MissingMandatoryConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.Stream;

/*
 *  author : Nilesh Pawar
 * */
public final class TestConfig {
    private static TestConfig testConfig;
    private final Properties properties = new Properties();
    private final Logger logger = LoggerFactory.getLogger(TestConfig.class);
    private final String[] mustHavePropertiesValueInTestSuite = {"application_url",
            "browserName"};


    private void setDefaultPropertiesWhenNotSetInTestSuite() {
        properties.setProperty("maximiseBrowserWhenOpen", "TRUE");
        properties.setProperty("pageLoadTime", "20");
        properties.setProperty("objectLoadTime", "20");
        properties.setProperty("object.wait.time.micro", "05");
        properties.setProperty("object.wait.time.macro", "10");
        properties.setProperty("object.wait.time.reliable", "20");
        properties.setProperty("object.wait.time.slow", "60");
        /* ------------------------------------------------------------------------------------------------
         * Add more default framework configuration properties in this method
         * Same config property will be overwritten when present in TestConfig.properties file in test suite
         * ----------------------------------------------------------------------------------------------- */
        logger.debug("Initialising Default configuration from library");
    }

    private TestConfig() {
        setDefaultPropertiesWhenNotSetInTestSuite();

        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream("TestConfig.properties")) {
            properties.load(input);
            properties.forEach((key, value) -> System.setProperty(key.toString().trim(), value.toString().trim()));

            Stream.of(mustHavePropertiesValueInTestSuite)
                    .forEach(property -> {
                        if (properties.getProperty(property.trim()) == null) {
                            throw new MissingMandatoryConfigException(" Mandatory property '" + property + "' missing in TestConfig.properties file in test suite");
                        }
                        if (properties.getProperty(property.trim()).isEmpty()) {
                            throw new MissingMandatoryConfigException(" Mandatory property '" + property + "' missing value in TestConfig.properties file in test suite");
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
            throw new FrameworkException(e.getMessage());
        }
    }

    private static TestConfig getInstance() {
        if (testConfig == null) {
            testConfig = new TestConfig();
        }
        return testConfig;
    }

    public static String getConfig(String propertyName) {
        return getInstance().properties.getProperty(propertyName.trim());
    }
}
