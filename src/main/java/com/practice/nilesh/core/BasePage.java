package com.practice.nilesh.core;

import org.openqa.selenium.WebDriver;

import java.net.URL;

/*
 *  author : Nilesh Pawar
 * */
public abstract class BasePage {
    WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void navigateTo(URL url) {
    }

    protected void takeScreenshot() {
    }

    protected void maximise() {
    }

    protected void closeAndQuitBrowser() {
    }

    protected void closeBrowserWindow() {
    }

    protected void getAlertBoxText() {
    }

    protected String getPageTitle() {
        return null;
    }
}
