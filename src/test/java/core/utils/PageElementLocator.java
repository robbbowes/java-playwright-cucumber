package core.utils;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import core.setup.config.Screen;
import core.setup.config.TestContext;
import org.testng.Assert;

import java.util.Map;

public class PageElementLocator {

    public static Locator getLocator(TestContext testContext, String locatorKey) {
        final Screen screen = testContext.getScreen();
        final Page page = screen.getCurrentTabInfo().currentTab();
        final String elementLocator = PageElementLocator.queryClassForLocator(screen, locatorKey);

        final String errorMessage = String.format("No locator with key '%s' found in the mappings of the '%s' class.",
                locatorKey, testContext.getScreen().getCurrentTabInfo().currentTabClass().getClass().getSimpleName());
        Assert.assertNotNull(elementLocator, errorMessage);

        return page.locator(elementLocator);
    }

    private static String queryClassForLocator(Screen screen, String locatorKey) {
        final Map<String, String> locators = screen.getCurrentTabInfo()
                .currentTabClass()
                .getLocators();

        Assert.assertNotNull(locators);
        return locators.get(locatorKey);
    }

}
