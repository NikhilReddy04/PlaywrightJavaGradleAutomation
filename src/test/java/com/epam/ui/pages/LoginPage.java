package com.epam.ui.pages;

import com.epam.ui.core.PlaywrightManager;
import com.microsoft.playwright.Page;
import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject {

    private Page page() {
        return PlaywrightManager.getInstance().getPage();
    }

    public void openPage(String url) {
        page().navigate(url);
    }

    public void enterUsername(String username) {
        page().fill("#username", username);
    }

    public void enterPassword(String password) {
        page().fill("#password", password);
    }

    public void clickLogin() {
        page().click("//button[normalize-space()='Login']");
    }
}
