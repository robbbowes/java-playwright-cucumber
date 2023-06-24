package core.setup.config;

import pages.abstractions.CucumberPage;
import core.setup.records.PageRouteInfo;
import pages.mappings.PageMappings;
import core.utils.PropertiesReader;

import java.util.Map;
import java.util.Properties;

public class GlobalConfig {

    private final Properties envProps;
    private final Map<CucumberPage, PageRouteInfo> routeMappings;

    public GlobalConfig() {
        envProps = PropertiesReader.read("config/environment.properties");
        routeMappings = PageMappings.getMappings();
    }

    public String getBaseUrl() {
        return envProps.getProperty("url");
    }

    public Map<CucumberPage, PageRouteInfo> getRouteMappings() {
        return routeMappings;
    }
}
