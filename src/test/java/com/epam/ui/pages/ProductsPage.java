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
        return page().getByRole(com.microsoft.playwright.options.AriaRole.HEADING, new Page.GetByRoleOptions().setName("Expensive Prime Deals"));
    }

    public Locator getAProductFromProductsPage(){
        page().pause();
        return page().locator("ul.products-list h1").first();
    }

    public void clickAddToCartButton(){
        page().getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ADD TO CART")).click();
    }

    public void goToCart(){
        page().getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart")).click();
    }
}
