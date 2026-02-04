package com.epam.ui.utils;

import com.epam.ui.core.PlaywrightManager;
import com.microsoft.playwright.Page;
import net.serenitybdd.core.Serenity;

import java.util.Base64;

public class ScreenshotTaker {

    private static Page page() {
        return PlaywrightManager.getInstance().getPage();
    }

    public static void attachScreenshot(String title) {
        byte[] screenshot = page().screenshot(); //

        String base64Image =
                Base64.getEncoder().encodeToString(screenshot);

        Serenity.recordReportData()
                .withTitle(title)
                .andContents(
                        "<img src='data:image/png;base64," + base64Image + "'/>"
                );
    }
}
