package core.utils;

import com.microsoft.playwright.Page;
import core.setup.config.TestContext;
import core.setup.records.RouteClassResult;
import pages.abstractions.CucumberPage;
import core.setup.records.PageRouteInfo;
import org.testng.Assert;

import java.util.Map;

public class NavigationBehaviour {

    public static void navigateToPage(TestContext testContext, String pageId) {
        final Page currentTab = testContext.getScreen().getCurrentTabInfo().currentTab();
        final RouteClassResult result = getResult(testContext.getMappings(), pageId);
        final PageRouteInfo routeInfo = result.routeInfo();
        final CucumberPage currentTabClass = result.pageClass();

        final String url = testContext.getBaseUrl() + routeInfo.route();
        currentTab.navigate(url);

        currentTab.waitForURL(routeInfo.regexPattern());
        testContext.getScreen().setCurrentTabInfo(currentTab, currentTabClass);
    }

    public static void waitForCorrectPage(TestContext testContext, String pageId) {
        final Page currentTab = testContext.getScreen().getCurrentTabInfo().currentTab();
        final RouteClassResult result = getResult(testContext.getMappings(), pageId);
        final PageRouteInfo routeInfo = result.routeInfo();
        final CucumberPage currentTabClass = result.pageClass();

        currentTab.waitForURL(routeInfo.regexPattern());
        testContext.getScreen().setCurrentTabInfo(currentTab, currentTabClass);
    }

    public static CucumberPage getCurrentTabClass(Map<CucumberPage, PageRouteInfo> routeMappings, Page currentTab) {
        final String url = currentTab.url();

        final CucumberPage cucumberPage = routeMappings.entrySet().stream()
                .filter(entry -> url.matches(entry.getValue().regexPattern().pattern()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        Assert.assertNotNull(cucumberPage, String.format("Page class not found for url: '%s'", url));
        return cucumberPage;
    }

    private static RouteClassResult getResult(Map<CucumberPage, PageRouteInfo> routeMappings, String pageId) {
        final RouteClassResult routeClassResult = routeMappings.keySet().stream()
                .filter(pageClass -> pageId.equals(pageClass.getClass().getSimpleName()))
                .map(pageClass -> new RouteClassResult(routeMappings.get(pageClass), pageClass))
                .findFirst()
                .orElse(null);

        Assert.assertNotNull(routeClassResult, String.format("Route info and class not found for page with id: '%s'", pageId));
        return routeClassResult;

    }

}
