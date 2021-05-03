package com.practice.nilesh;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/*
 *  author : Nilesh Pawar
 * */
public class BasePage {
    RemoteWebDriver driver;

    protected BasePage(RemoteWebDriver driver) {
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
