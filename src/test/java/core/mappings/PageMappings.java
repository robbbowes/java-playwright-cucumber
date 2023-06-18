package core.mappings;

import core.records.PageRouteInfo;
import core.pages.Home;

import java.util.Map;
import java.util.regex.Pattern;

public final class PageMappings {

    private static final Map<String, PageRouteInfo> MAP = Map.ofEntries(
            Map.entry(Home.class.getSimpleName(), new PageRouteInfo("/", Pattern.compile(""))),
            Map.entry("create contact", new PageRouteInfo("/tasks/create", Pattern.compile("^/tasks/create$"))),
            Map.entry("playground", new PageRouteInfo("/playground", Pattern.compile("^/playground$")))
    );

    public static Map<String, PageRouteInfo> getMappings() {
        return MAP;
    }
}
