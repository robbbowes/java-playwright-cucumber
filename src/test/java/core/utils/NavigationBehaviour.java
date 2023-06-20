package core.utils;

import com.microsoft.playwright.Page;
import core.core.config.GlobalConfig;
import core.core.config.TestContext;
import core.pages.abstractions.CucumberPage;
import core.core.records.PageRouteInfo;

import java.util.Map;

public class NavigationBehaviour {

    public static void navigateToPage(TestContext testContext, String pageId) {
        final Page page = testContext.getScreen().getPage();
        final GlobalConfig config = testContext.getGlobalConfig();

        Map<Class<? extends CucumberPage>, PageRouteInfo> routeMappings = config.getRouteMappings();

        PageRouteInfo routeInfo = null;
        Class<? extends CucumberPage> pageClass = null;
        for (Class<? extends CucumberPage> aClass : routeMappings.keySet()) {
            if (pageId.equals(aClass.getSimpleName())) {
                routeInfo = routeMappings.get(aClass);
                pageClass = aClass;
                break;
            }
        }

        assert routeInfo != null;
        final String url = config.getBaseUrl() + routeInfo.route();
        page.navigate(url);
        page.waitForURL(routeInfo.pattern());
        testContext.getScreen().setCurrentPageClass(pageClass);
    }

    public static void waitForCorrectPage(TestContext testContext, String pageId) {
        GlobalConfig config = testContext.getGlobalConfig();
        final String baseUrl = config.getBaseUrl();
        Map<Class<? extends CucumberPage>, PageRouteInfo> routeMappings = config.getRouteMappings();

        PageRouteInfo routeInfo = null;
        Class<? extends CucumberPage> pageClass = null;
        for (Class<? extends CucumberPage> aClass : routeMappings.keySet()) {
            if (pageId.equals(aClass.getSimpleName())) {
                routeInfo = routeMappings.get(aClass);
                pageClass = aClass;
                break;
            }
        }

        assert routeInfo != null;
        final String url = baseUrl + routeInfo.route();
        testContext.getScreen().getPage().waitForURL(url);
        testContext.getScreen().setCurrentPageClass(pageClass);
    }

}
