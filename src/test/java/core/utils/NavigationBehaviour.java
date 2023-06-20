package core.utils;

import com.aventstack.extentreports.util.Assert;
import com.microsoft.playwright.Page;
import core.core.config.GlobalConfig;
import core.core.config.TestContext;
import core.pages.abstractions.CucumberPage;
import core.core.records.PageRouteInfo;

import java.util.Map;
import java.util.regex.Pattern;

public class NavigationBehaviour {

    public static void navigateToPage(TestContext testContext, String pageId) {
        final Page page = testContext.getScreen().getCurrentTab();
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
        page.waitForURL(routeInfo.regexPattern());
        testContext.getScreen().setCurrentTabClass(pageClass);
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
        testContext.getScreen().getCurrentTab().waitForURL(url);
        testContext.getScreen().setCurrentTabClass(pageClass);
    }

    public static Class<? extends CucumberPage> getCurrentTabClass(TestContext testContext) {
        GlobalConfig config = testContext.getGlobalConfig();
        Map<Class<? extends CucumberPage>, PageRouteInfo> routeMappings = config.getRouteMappings();
        String url = testContext.getScreen().getCurrentTab().url();
        String route = url.replace(config.getBaseUrl(), "");

        Class<? extends CucumberPage> pageClass = null;
        for (Map.Entry<Class<? extends CucumberPage>, PageRouteInfo> entry : routeMappings.entrySet()) {
            Pattern regexPattern = entry.getValue().regexPattern();
            boolean matches = route.matches(regexPattern.pattern());
            if (matches) {
                pageClass = entry.getKey();
                break;
            }
        }
        Assert.notNull(pageClass, String.format("Page class not found for route: %s", route));
        return pageClass;
    }

}
