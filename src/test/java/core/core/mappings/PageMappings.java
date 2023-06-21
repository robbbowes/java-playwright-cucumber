package core.core.mappings;

import core.pages.CreateContact;
import core.pages.Playground;
import core.pages.abstractions.CucumberPage;
import core.core.records.PageRouteInfo;
import core.pages.Home;

import java.util.Map;
import java.util.regex.Pattern;

public final class PageMappings {

    private static final Map<CucumberPage, PageRouteInfo> MAP = Map.ofEntries(
            Map.entry(new Home(),
                    new PageRouteInfo("/", Pattern.compile(""))),

            Map.entry(new CreateContact(),
                    new PageRouteInfo("/tasks/create", Pattern.compile("^/tasks/create$"))),

            Map.entry(new Playground(),
                    new PageRouteInfo("/playground", Pattern.compile("^/playground$")))
    );

    public static Map<CucumberPage, PageRouteInfo> getMappings() {
        return MAP;
    }
}
