package core.utils;

import com.microsoft.playwright.Page;
import core.config.GlobalConfig;
import core.records.PageRouteInfo;

public class NavigationBehaviour {

    public static void navigateToPage(Page page, String pageId, GlobalConfig config) {
        String baseUrl = config.getBaseUrl();
        PageRouteInfo routeInfo = config.getRouteMappings().get(pageId);
        String url = baseUrl + routeInfo.route();

        page.navigate(url);
        page.waitForURL(routeInfo.pattern());
    }

}
