package core.config;

import core.records.PageRouteInfo;
import core.mappings.PageMappings;
import core.utils.PropertiesReader;

import java.util.Map;
import java.util.Properties;

public class GlobalConfig {

    private final Properties envProps;
    private final Map<String, PageRouteInfo> routeMappings;

    public GlobalConfig() {
        envProps = PropertiesReader.read("config/environment.properties");
        routeMappings = PageMappings.getMappings();
    }

    public String getBaseUrl() {
        return envProps.getProperty("url");
    }

    public Map<String, PageRouteInfo> getRouteMappings() {
        return routeMappings;
    }
}
