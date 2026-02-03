package com.epam.api.tests;

import com.epam.api.config.ApiConfig;
import com.epam.api.steps.LoginApiSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
class LoginApiTest {

    @Steps
    LoginApiSteps loginSteps;

    @BeforeAll
    static void setup() {
        ApiConfig.init();
    }

    @Test
    void loginShouldReturnToken() {
        loginSteps.login("rahul", "rahul@2021");
        loginSteps.saveToken();
    }
}
