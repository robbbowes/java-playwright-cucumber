package core.config;

import core.pages.abstractions.CucumberPage;
import core.records.PageRouteInfo;
import core.pages.mappings.PageMappings;
import core.utils.PropertiesReader;

import java.util.Map;
import java.util.Properties;

public class GlobalConfig {

    private final Properties envProps;
    private final Map<Class<? extends CucumberPage>, PageRouteInfo> routeMappings;

    public GlobalConfig() {
        envProps = PropertiesReader.read("config/environment.properties");
        routeMappings = PageMappings.getMappings();
    }

    public String getBaseUrl() {
        return envProps.getProperty("url");
    }

    public Map<Class<? extends CucumberPage>, PageRouteInfo> getRouteMappings() {
        return routeMappings;
    }
}
