package core.utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import core.core.config.Screen;
import core.core.config.TestContext;
import core.pages.abstractions.CucumberPage;

import java.lang.reflect.Constructor;
import java.util.Map;

public class PageElementLocator {

    public static Locator getLocator(TestContext testContext, String locatorKey) {
        Screen screen = testContext.getScreen();
        Page page = screen.getPage();
        String elementLocator = PageElementLocator.queryClassForLocator(screen, locatorKey);
        return page.locator(elementLocator);
    }

    private static String queryClassForLocator(Screen screen, String locatorKey) {
        Map<String, String> locators = null;
        try {
            Class<? extends CucumberPage> currentPageClass = screen.getCurrentPageClass();
            Constructor<? extends CucumberPage> constructor = currentPageClass.getConstructor();
            CucumberPage cucumberPage = constructor.newInstance();
            locators = cucumberPage.getLocators();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        assert locators != null;
        String locator = locators.get(locatorKey);
        return locator;
    }

}
