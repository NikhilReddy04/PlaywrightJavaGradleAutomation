package com.epam.api.tests;

import com.epam.api.steps.CheckoutMockServerSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class CheckoutMockServerTest {

    @Steps
    CheckoutMockServerSteps checkoutMockServerSteps;

    @Test
    void validateSuccessfulPayment() {
        checkoutMockServerSteps.checkoutWithValidCard();
    }

    @Test
    void validateFailingPayment() {
        checkoutMockServerSteps.checkoutWithInvalidCard();
    }
}
