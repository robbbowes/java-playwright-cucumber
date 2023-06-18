package core.utils;

import com.microsoft.playwright.Page;
import core.config.GlobalConfig;
import core.config.TestContext;
import core.pages.abstractions.CucumberPage;
import core.records.PageRouteInfo;

import java.util.Map;

public class NavigationBehaviour extends TestContext {

    public static void navigateToPage(Page page, String pageId, GlobalConfig config) {
        String baseUrl = config.getBaseUrl();
        Map<Class<? extends CucumberPage>, PageRouteInfo> routeMappings = config.getRouteMappings();

        PageRouteInfo routeInfo = null;
        for (Class<? extends CucumberPage> aClass : routeMappings.keySet()) {
            if (pageId.equals(aClass.getSimpleName())) {
                routeInfo = routeMappings.get(aClass);
                break;
            }
        }

        String url = baseUrl + routeInfo.route();

        page.navigate(url);
        page.waitForURL(routeInfo.pattern());


    }

}
