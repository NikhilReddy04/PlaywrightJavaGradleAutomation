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
        page().getByRole(com.microsoft.playwright.options.AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("USERNAME")).fill(username);
    }

    public void enterPassword(String password) {
        page().getByRole(com.microsoft.playwright.options.AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("PASSWORD")).fill(password);
    }

    public void clickLogin() {
        page().getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
