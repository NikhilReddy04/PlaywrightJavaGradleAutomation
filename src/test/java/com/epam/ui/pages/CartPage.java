package com.epam.ui.pages;

import com.epam.ui.core.PlaywrightManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {

    private Page page() {
        return PlaywrightManager.getInstance().getPage();
    }

    // //p[contains(.,'Hair Dryer')]
    public Locator getProductByName(String productName) {
        return page().getByText(productName, new Page.GetByTextOptions().setExact(true));
    }

    public Locator myCartHeading() {
        return page().getByRole(com.microsoft.playwright.options.AriaRole.HEADING, new Page.GetByRoleOptions().setName("My Cart"));
    }
}
