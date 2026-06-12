package com.epam.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.epam.ui.core.PlaywrightManager;
import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {
    private Page page() {
        return PlaywrightManager.getInstance().getPage();
    }

    public void openPage(String url) {
        page().navigate(url);
    }

    public void clickProductsButton(){
        page().getByRole(com.microsoft.playwright.options.AriaRole.LINK, new Page.GetByRoleOptions().setName("Products")).click();
    }

    public Locator shopNowButton(){
       return page().getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Shop Now"));
    }


}
