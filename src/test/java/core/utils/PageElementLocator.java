package core.utils;

import core.config.Screen;
import core.pages.abstractions.CucumberPage;

import java.lang.reflect.Constructor;
import java.util.Map;

public class PageElementLocator {

    public static String getLocator(Screen screen, String locatorKey) {
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
        return locators.get(locatorKey);
    }


}
