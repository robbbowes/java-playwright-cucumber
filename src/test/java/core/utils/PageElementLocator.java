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
        final Locator elementLocator = PageElementLocator.queryClassForLocator(screen, locatorKey);

        final String errorMessage = String.format("No locator with key '%s' found in the mappings of the '%s' class.",
                locatorKey, testContext.getScreen().getCurrentTabInfo().currentTabClass().getClass().getSimpleName());
        Assert.assertNotNull(elementLocator, errorMessage);

        return elementLocator;
    }

    private static Locator queryClassForLocator(Screen screen, String locatorKey) {
        final Page page = screen.getCurrentTabInfo().currentTab();
        final Map<String, Locator> locators = screen.getCurrentTabInfo()
                .currentTabClass()
                .getLocators(page);

        Assert.assertNotNull(locators);
        return locators.get(locatorKey);
    }

}
