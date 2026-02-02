package com.epam.tests;

import com.epam.hooks.PlaywrightHooks;
import com.epam.steps.HomePageSteps;
import com.epam.steps.LoginSteps;
import com.epam.steps.ProductsSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddToCartTest extends PlaywrightHooks {
    @Steps
    LoginSteps loginSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    ProductsSteps productsSteps;

    @Test
    @DisplayName("Add to cart")
    void verifyProductsPageButton(){
        loginSteps.loginAs("rahul",
                "rahul@2021",
                "https://nikhtrendz.ccbp.tech/login");
        homePageSteps.validateShopNowButtonVisibility();
        homePageSteps.goToProductsPage();
        productsSteps.addAnItemToCart();
        productsSteps.verifyAddToCart();
    }

}
