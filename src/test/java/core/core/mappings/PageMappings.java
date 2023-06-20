package core.core.mappings;

import core.pages.CreateContact;
import core.pages.Playground;
import core.pages.abstractions.CucumberPage;
import core.core.records.PageRouteInfo;
import core.pages.Home;

import java.util.Map;
import java.util.regex.Pattern;

public final class PageMappings {

    private static final Map<Class<? extends CucumberPage>, PageRouteInfo> MAP = Map.ofEntries(
            Map.entry(Home.class,
                    new PageRouteInfo("/", Pattern.compile(""))),

            Map.entry(CreateContact.class,
                    new PageRouteInfo("/tasks/create", Pattern.compile("^/tasks/create$"))),

            Map.entry(Playground.class,
                    new PageRouteInfo("/playground", Pattern.compile("^/playground$")))
    );

    public static Map<Class<? extends CucumberPage>, PageRouteInfo> getMappings() {
        return MAP;
    }
}
