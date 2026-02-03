package com.epam.ui.hooks;

import com.epam.ui.core.PlaywrightManager;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class PlaywrightHooks {

    @BeforeAll
    static void beforeAll() {
        PlaywrightManager.getInstance().startBrowser();
    }

    @BeforeEach
    void beforeEach() {
        PlaywrightManager.getInstance().startSession();
    }

    @AfterEach
    void afterEach() {
        PlaywrightManager.getInstance().closeSession();
    }
}
