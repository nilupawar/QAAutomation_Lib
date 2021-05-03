package com.practice.nilesh.pages;

import com.practice.nilesh.BasePage;
import com.practice.nilesh.PageElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.practice.nilesh.ElementType.*;
import static com.practice.nilesh.LocatorType.*;

public class LoginPage extends BasePage {
    /*------------------------------------------------------------------------------------------------------------------
     * Declare page's Object
     *------------------------------------------------------------------------------------------------------------------*/
    PageElement userName = new PageElement(TEXT_BOX, "UserName", ID, "Username", "");
    PageElement passWord = new PageElement(TEXT_BOX, "Password", ID, "Password", "");
    PageElement loginButton = new PageElement(BUTTON, "Login button", NAME, "login");
    PageElement loginFailedMessage = new PageElement(PLAIN_TEXT, "Login fail", XPATH, "//div[contains(text(),'Login failed')]");


    /*------------------------------------------------------------------------------------------------------------------
     * Define Page methods
     *------------------------------------------------------------------------------------------------------------------*/
    public void loginToApplication() {
        userName.enterValue();
        passWord.enterValue(true);
        loginButton.click();
    }

    public boolean isLoginFailed() {
        return loginFailedMessage.getObjectsCount() == 0;
    }


    /*------------------------------------------------------------------------------------------------------------------
     * Initialise login page object
     *------------------------------------------------------------------------------------------------------------------*/
    LoginPage(RemoteWebDriver driver) {
        super(driver);
    }
}

