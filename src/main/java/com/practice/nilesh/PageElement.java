package com.practice.nilesh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 *  author : Nilesh Pawar
 * */
public class PageElement {
    private String name;
    private LocatorType locatorType;
    private String locatorValue;
    private PageFrame pageFrame;
    private String testData;
    private RemoteWebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(PageElement.class);

    public PageElement(String name, LocatorType locatorType, String locatorValue, PageFrame pageFrame, String testData) {
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
        this.pageFrame = pageFrame;
        this.testData = testData;
    }

    public PageElement(String name, LocatorType locatorType, String locatorValue, PageFrame pageFrame) {
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
        this.pageFrame = pageFrame;
    }

    public PageElement(String name, LocatorType locatorType, String locatorValue) {
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
    }

    private void switchToFrame() {
        driver.switchTo().defaultContent();
        if (pageFrame != null) {
            switch (pageFrame.getIdentificationType()) {
                case INDEX:
                    driver.switchTo().frame(pageFrame.getFrameIndex());
                    break;
                case WEB_ELEMENT:
                    driver.switchTo().frame(pageFrame.getFrameWebElement());
                    break;
                case LOCATOR:
                    driver.switchTo().frame(pageFrame.getFrameLocator());
                    break;
            }
        }
    }

    /*
     *
     * */
    private WebElement getWebElement() {
        this.switchToFrame();
        switch (this.locatorType) {
            case XPATH:
                return driver.findElementByXPath(this.locatorValue);
            case CSS:
                return driver.findElementByCssSelector(this.locatorValue);
            case ID:
                return driver.findElementById(this.locatorValue);
            case NAME:
                return driver.findElementByName(this.locatorValue);
            case LINK_TEXT:
                return driver.findElementByLinkText(this.locatorValue);
            case PARTIAL_LINK_TEXT:
                return driver.findElementByPartialLinkText(this.locatorValue);
            case CLASS_NAME:
                return driver.findElementByClassName(this.locatorValue);
            case TAG_NAME:
                return driver.findElementByTagName(this.locatorValue);

        }
        return null;
    }

    /*
     *
     * */
    public void enterValue() {
        logger.debug("Trying to enter value '{}' in element '{}' of type '{}'", testData, name, locatorType);

        WebElement webElement = getWebElement();
        assert webElement != null;
        webElement.sendKeys(testData);

        logger.info("Entered value '{}' in element '{}' of type '{}'", testData, name, locatorType);
    }

    /*
     *
     * */
    public void enterValue(boolean isPassword) {

    }

    /*
     *
     * */
    public void enterValue(String value, boolean isPassword) {

    }

    /*
     *
     * */
    public void click() {
        logger.debug("Trying to click on element '{}' of type '{}' ", name, locatorType);
        WebElement webElement = getWebElement();
        assert webElement != null;
        webElement.click();
        logger.info("Clicked element '{}' of type '{}'", name, locatorType);
    }

    public void doubleClick() {
        logger.debug("Trying to double click on element '{}' of type '{}' ", name, locatorType);
        WebElement webElement = getWebElement();
        assert webElement != null;
        //TODO - Perform Double click operation
        logger.info("Double clicked element '{}' of type '{}'", name, locatorType);
    }

}
