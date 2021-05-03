package com.practice.nilesh;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/*
*  author : Nilesh Pawar
* */
public class BasePage {
    RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(URL url) {
    }

    public void takeScreenshot() {
    }

    public void maximise() {
    }

    public void closeAndQuitBrowser() {
    }

    public void closeBrowserWindow() {
    }

    public String getPageTitle() {
        return null;
    }
}
