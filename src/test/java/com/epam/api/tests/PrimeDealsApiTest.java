package com.epam.api.tests;

import com.epam.api.steps.LoginApiSteps;
import com.epam.api.steps.PrimeDealsSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.epam.api.config.ApiConfig;

@ExtendWith(SerenityJUnit5Extension.class)
public class PrimeDealsApiTest {

    @Steps
    PrimeDealsSteps primeDealsSteps;

    @Steps
    LoginApiSteps loginSteps;

    @BeforeAll
    static void setup() {
        // Initialize base URI before tests
        ApiConfig.init();
    }

    @Test
    void validatePrimeDeals() {
        loginSteps.login("rahul", "rahul@2021");
        loginSteps.saveToken();
        primeDealsSteps.callPrimeDealsApi();
        primeDealsSteps.verifyPrimeDealsArray();
        primeDealsSteps.verifyFirstDealFields();
    }
}
