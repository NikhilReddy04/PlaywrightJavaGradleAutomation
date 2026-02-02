package com.epam.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.epam.core.PlaywrightManager;
import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {
    private Page page() {
        return PlaywrightManager.getInstance().getPage();
    }

    public void openPage(String url) {
        page().navigate(url);
    }

    public void clickProductsButton(){
        page().click("xpath=//a[normalize-space()='Products']");
    }

    public Locator shopNowButton(){
       return page().locator("xpath=//button[normalize-space()='Shop Now']");
    }


}
