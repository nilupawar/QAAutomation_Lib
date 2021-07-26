package com.practice.nilesh.ele;

import com.practice.nilesh.types.ElementType;
import com.practice.nilesh.types.LocatorType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/*
 *  author : Nilesh Pawar
 * */
public class PageElement {
    private final String name;
    private final LocatorType locatorType;
    private final String locatorValue;
    private PageFrame pageFrame;
    private String testData;
    private WebDriver driver;
    private final ElementType elementType;

    private static final Logger logger = LoggerFactory.getLogger(PageElement.class);

    public PageElement(ElementType elementType, String name, LocatorType locatorType, String locatorValue, PageFrame pageFrame, String testData) {
        this.elementType = elementType;
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
        this.pageFrame = pageFrame;
        this.testData = testData;
    }

    public PageElement(ElementType elementType, String name, LocatorType locatorType, String locatorValue, PageFrame pageFrame) {
        this.elementType = elementType;
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
        this.pageFrame = pageFrame;
    }

    public PageElement(ElementType elementType, String name, LocatorType locatorType, String locatorValue) {
        this.elementType = elementType;
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
    }

    public PageElement(ElementType elementType, String name, LocatorType locatorType, String locatorValue, String testData) {
        this.elementType = elementType;
        this.name = name;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
        this.testData = testData;
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
                default:
                    logger.error("Invalid choice for frame identification type '{}'", pageFrame.getIdentificationType());
                    break;
            }
        }
    }

    /*
     *
     * */
    private List<WebElement> getWebElements() {
        this.switchToFrame();
        switch (this.locatorType) {
            case XPATH:
                return driver.findElements(By.xpath(this.locatorValue));
            case CSS:
                return driver.findElements(By.cssSelector(this.locatorValue));
            case ID:
                return driver.findElements(By.id(this.locatorValue));
            case NAME:
                return driver.findElements(By.name(this.locatorValue));
            case LINK_TEXT:
                return driver.findElements(By.linkText(this.locatorValue));
            case PARTIAL_LINK_TEXT:
                return driver.findElements(By.partialLinkText(this.locatorValue));
            case CLASS_NAME:
                return driver.findElements(By.className(this.locatorValue));
            case TAG_NAME:
                return driver.findElements(By.tagName(this.locatorValue));
            default:
                logger.error("Invalid choice for locator type '{}'", locatorType);
                break;

        }
        return Collections.emptyList();
    }

    /*
     *
     * */
    private WebElement getWebElement() {
        this.switchToFrame();
        switch (this.locatorType) {
            case XPATH:
                return driver.findElement(By.xpath(this.locatorValue));
            case CSS:
                return driver.findElement(By.cssSelector(this.locatorValue));
            case ID:
                return driver.findElement(By.id(this.locatorValue));
            case NAME:
                return driver.findElement(By.name(this.locatorValue));
            case LINK_TEXT:
                return driver.findElement(By.linkText(this.locatorValue));
            case PARTIAL_LINK_TEXT:
                return driver.findElement(By.partialLinkText(this.locatorValue));
            case CLASS_NAME:
                return driver.findElement(By.className(this.locatorValue));
            case TAG_NAME:
                return driver.findElement(By.tagName(this.locatorValue));
            default:
                logger.error("Invalid choice for locator type '{}'", locatorType);
                break;
        }
        return null;
    }

    public WebElement getObject() {
        return getWebElement();
    }

    public int getObjectsCount() {
        return getWebElements().size();
    }

    public List<WebElement> getObjects() {
        return getWebElements();
    }

    /*
     *
     * */
    public void enterValue() {
        putValue(testData, false);
    }

    public void enterValue(boolean isPassword) {
        putValue(testData, isPassword);
    }

    public void enterPassword() {
        putValue(testData, true);
    }

    public void enterValue(String value, boolean isPassword) {
        putValue(value, isPassword);
    }


    /*
     *
     * */
    public void click() {
        logger.debug("Trying to click on element '{}' of type '{}' ", name, elementType);
        WebElement webElement = getWebElement();
        assert webElement != null;
        webElement.click();
        logger.info("Clicked element '{}' of type '{}'", name, elementType);
    }

    /*
     *
     * */
    public void doubleClick() {
        logger.debug("Trying to double click on element '{}' of type '{}' ", name, elementType);
        WebElement webElement = getWebElement();
        assert webElement != null;
        //TODO - Perform Double click operation
        logger.info("Double clicked element '{}' of type '{}'", name, elementType);
    }

    /*
     *
     * */
    private void putValue(String dataValue, boolean isPassword) {
        logger.debug("Trying to enter value '{}' in element '{}' of type '{}'", isPassword ? "*******" : dataValue, name, elementType);
        WebElement webElement = getWebElement();
        assert webElement != null;
        webElement.sendKeys(dataValue);
        logger.info("Entered value '{}' in element '{}' of type '{}'", isPassword ? "*******" : dataValue, name, elementType);
    }
}
