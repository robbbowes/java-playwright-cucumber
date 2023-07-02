package core.setup.config;

import pages.CreateContact;
import pages.Playground;
import pages.abstractions.CucumberPage;
import core.setup.records.PageRouteInfo;
import pages.Home;
import core.utils.PropertiesReader;

import java.util.Map;
import java.util.regex.Pattern;

public final class PageMappings {

    private static final String BASE_URL = PropertiesReader
            .read("config/environment.properties")
            .getProperty("url");

    private static final Map<CucumberPage, PageRouteInfo> MAP = Map.ofEntries(
            Map.entry(new Home(), new PageRouteInfo("", regex("/"))),

            Map.entry(new CreateContact(), new PageRouteInfo("/tasks/create", regex("/tasks/create"))),

            Map.entry(new Playground(), new PageRouteInfo("/playground", regex("/playground")))
    );

    public static Map<CucumberPage, PageRouteInfo> getMappings() {
        return MAP;
    }

    private static Pattern regex(String urlEnd) {
        return Pattern.compile("^" + BASE_URL + urlEnd + "$");
    }
}
