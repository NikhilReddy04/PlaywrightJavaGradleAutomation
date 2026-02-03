package com.epam.ui.steps;

import com.epam.ui.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step("Login as user {0}")
    public void loginAs(String username, String password, String url) {
        loginPage.openPage(url);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
}
