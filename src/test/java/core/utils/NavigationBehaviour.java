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
        final Page currentTab = testContext.getScreen().getCurrentTab();
        final GlobalConfig config = testContext.getGlobalConfig();

        Map<CucumberPage, PageRouteInfo> routeMappings = config.getRouteMappings();

        PageRouteInfo routeInfo = null;
        CucumberPage currentTabClass = null;
        for (CucumberPage aClass : routeMappings.keySet()) {
            if (pageId.equals(aClass.getClass().getSimpleName())) {
                routeInfo = routeMappings.get(aClass);
                currentTabClass = aClass;
                break;
            }
        }

        assert routeInfo != null;
        final String url = config.getBaseUrl() + routeInfo.route();
        currentTab.navigate(url);
        currentTab.waitForURL(routeInfo.regexPattern());
        testContext.getScreen().setCurrentTabInfo(currentTab, currentTabClass);
    }

    public static void waitForCorrectPage(TestContext testContext, String pageId) {
        GlobalConfig config = testContext.getGlobalConfig();
        final String baseUrl = config.getBaseUrl();
        Map<CucumberPage, PageRouteInfo> routeMappings = config.getRouteMappings();

        PageRouteInfo routeInfo = null;
        CucumberPage pageClass = null;
        for (CucumberPage aClass : routeMappings.keySet()) {
            if (pageId.equals(aClass.getClass().getSimpleName())) {
                routeInfo = routeMappings.get(aClass);
                pageClass = aClass;
                break;
            }
        }

        assert routeInfo != null;
        final String url = baseUrl + routeInfo.route();
        Page currentTab = testContext.getScreen().getCurrentTab();
        currentTab.waitForURL(url);
        testContext.getScreen().setCurrentTabInfo(currentTab, pageClass);
    }

    public static CucumberPage getCurrentTabClass(GlobalConfig config, Page currentTab) {
        Map<CucumberPage, PageRouteInfo> routeMappings = config.getRouteMappings();
        String url = currentTab.url();
        String route = url.replace(config.getBaseUrl(), "");

        CucumberPage pageClass = null;
        for (Map.Entry<CucumberPage, PageRouteInfo> entry : routeMappings.entrySet()) {
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
