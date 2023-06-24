package core.utils;

import com.microsoft.playwright.Page;
import core.setup.config.GlobalConfig;
import core.setup.config.TestContext;
import core.setup.records.RouteClassResult;
import pages.abstractions.CucumberPage;
import core.setup.records.PageRouteInfo;
import org.testng.Assert;

import java.util.Map;

public class NavigationBehaviour {

    public static void navigateToPage(TestContext testContext, String pageId) {
        final Page currentTab = testContext.getScreen().getCurrentTabInfo().currentTab();
        final GlobalConfig config = testContext.getGlobalConfig();
        final RouteClassResult result = getResult(config, pageId);
        final PageRouteInfo routeInfo = result.routeInfo();
        final CucumberPage currentTabClass = result.pageClass();

        final String url = config.getBaseUrl() + routeInfo.route();
        currentTab.navigate(url);

        currentTab.waitForURL(routeInfo.regexPattern());
        testContext.getScreen().setCurrentTabInfo(currentTab, currentTabClass);
    }

    public static void waitForCorrectPage(TestContext testContext, String pageId) {
        final Page currentTab = testContext.getScreen().getCurrentTabInfo().currentTab();
        final GlobalConfig config = testContext.getGlobalConfig();
        final RouteClassResult result = getResult(config, pageId);
        final PageRouteInfo routeInfo = result.routeInfo();
        final CucumberPage currentTabClass = result.pageClass();

        currentTab.waitForURL(routeInfo.regexPattern());
        testContext.getScreen().setCurrentTabInfo(currentTab, currentTabClass);
    }

    public static CucumberPage getCurrentTabClass(GlobalConfig config, Page currentTab) {
        final Map<CucumberPage, PageRouteInfo> routeMappings = config.getRouteMappings();
        final String url = currentTab.url();

        final CucumberPage cucumberPage = routeMappings.entrySet().stream()
                .filter(entry -> url.matches(entry.getValue().regexPattern().pattern()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        Assert.assertNotNull(cucumberPage, String.format("Page class not found for url: '%s'", url));
        return cucumberPage;
    }

    private static RouteClassResult getResult(GlobalConfig config, String pageId) {
        final Map<CucumberPage, PageRouteInfo> routeMappings = config.getRouteMappings();

        final RouteClassResult routeClassResult = routeMappings.keySet().stream()
                .filter(pageClass -> pageId.equals(pageClass.getClass().getSimpleName()))
                .map(pageClass -> new RouteClassResult(routeMappings.get(pageClass), pageClass))
                .findFirst()
                .orElse(null);

        Assert.assertNotNull(routeClassResult, String.format("Route info and class not found for page with id: '%s'", pageId));
        return routeClassResult;

    }

}
