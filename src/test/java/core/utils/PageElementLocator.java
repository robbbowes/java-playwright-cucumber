package core.utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import core.core.config.Screen;
import core.core.config.TestContext;

import java.util.Map;

public class PageElementLocator {

    public static Locator getLocator(TestContext testContext, String locatorKey) {
        Screen screen = testContext.getScreen();
        Page page = screen.getCurrentTab();
        String elementLocator = PageElementLocator.queryClassForLocator(screen, locatorKey);
        return page.locator(elementLocator);
    }

    private static String queryClassForLocator(Screen screen, String locatorKey) {
        Map<String, String> locators = screen.getCurrentTabClass().getLocators();
        assert locators != null;
        return locators.get(locatorKey);
    }

}
