package com.epam.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {

    private final Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    // //p[contains(.,'Hair Dryer')]
    public Locator getProductByName(String productName) {
        String xpath = "//p[contains(.,'" + productName + "')]";
        return page.locator(xpath);
    }

    public Locator myCartHeading() {
        return page.locator("//h1[normalize-space()='My Cart']");
    }
}
