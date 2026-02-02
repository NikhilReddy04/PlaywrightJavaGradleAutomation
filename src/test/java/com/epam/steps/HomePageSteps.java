package com.epam.steps;

import com.epam.pages.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
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
