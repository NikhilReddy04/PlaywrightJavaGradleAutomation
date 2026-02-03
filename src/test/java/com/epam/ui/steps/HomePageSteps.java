package com.epam.ui.steps;

import com.epam.ui.pages.HomePage;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageSteps extends ScenarioSteps {
    HomePage homePage;

    @Step("Go to products page")
    public void goToProductsPage(){
        homePage.clickProductsButton();
    }

    @Step("Validate shop now button visibility")
    public void validateShopNowButtonVisibility(){
        assertThat(homePage.shopNowButton()).isVisible();
    }

}
