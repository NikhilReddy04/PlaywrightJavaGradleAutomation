package com.epam.core;

import com.microsoft.playwright.*;

public final class PlaywrightManager {

    private static final ThreadLocal<Playwright> playwrightTL = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserTL = new ThreadLocal<>();

    private static final ThreadLocal<BrowserContext> contextTL = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageTL = new ThreadLocal<>();

    private PlaywrightManager() {}

    private static class Holder {
        private static final PlaywrightManager INSTANCE = new PlaywrightManager();
    }

    public static PlaywrightManager getInstance() {
        return Holder.INSTANCE;
    }

    // ✅ Chromium only, thread-safe
    public void startBrowser() {

        if (playwrightTL.get() == null) {

            Playwright playwright = Playwright.create();
            playwrightTL.set(playwright);

            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false));

            browserTL.set(browser);

            Runtime.getRuntime()
                    .addShutdownHook(new Thread(this::shutdown));
        }
    }

    public void startSession() {

        BrowserContext context = browserTL.get().newContext();
        Page page = context.newPage();

        contextTL.set(context);
        pageTL.set(page);
    }

    public Page getPage() {
        return pageTL.get();
    }

    public void closeSession() {

        if (pageTL.get() != null) {
            pageTL.get().close();
            pageTL.remove();
        }

        if (contextTL.get() != null) {
            contextTL.get().close();
            contextTL.remove();
        }
    }

    private void shutdown() {

        if (browserTL.get() != null) {
            browserTL.get().close();
            browserTL.remove();
        }

        if (playwrightTL.get() != null) {
            playwrightTL.get().close();
            playwrightTL.remove();
        }
    }
}
