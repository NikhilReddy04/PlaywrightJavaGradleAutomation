package com.epam.steps;

import com.epam.pages.CartPage;
import com.epam.pages.HomePage;
import com.epam.pages.ProductsPage;
import com.microsoft.playwright.Locator;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsSteps {
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Step("Add an item to cart from products page")
    public void addAnItemToCart(){
        Locator product =productsPage.getAProductFromProductsPage();
        System.out.println(product.textContent());

        //Adding product name to shared context
        Serenity.setSessionVariable("selectedProduct").to(product.textContent());
        product.click();
        productsPage.clickAddToCartButton();
    }

    @Step("Verify the item added to the cart")
    public void verifyAddToCart(){
        productsPage.goToCart();
        assertThat(cartPage.myCartHeading()).isVisible();
        String productName = Serenity.sessionVariableCalled("selectedProduct");
        assertThat(cartPage.getProductByName(productName)).isVisible();
    }
}
