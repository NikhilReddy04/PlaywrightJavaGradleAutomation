package com.epam.ui.pages;

import com.epam.ui.core.PlaywrightManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import net.serenitybdd.core.pages.PageObject;

public class ProductsPage extends PageObject {
    private Page page() {
        return PlaywrightManager.getInstance().getPage();
    }

    public Locator primeDealsTitle( ){
        return page().locator("xpath=//h1[normalize-space()='Exclusive Prime Deals']");
    }

    public Locator getAProductFromProductsPage(){
        page().pause();
        return page().locator("xpath=//ul[@class='products-list']//h1").first();
    }

    public void clickAddToCartButton(){
        page().locator("//button[normalize-space()='ADD TO CART']").click();
    }

    public void goToCart(){
        page().locator("//a[contains(text(),'Cart')]").click();
    }
}
