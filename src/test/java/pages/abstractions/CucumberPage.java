package pages.abstractions;

import java.util.Map;

public interface CucumberPage {

    Map<String, String> getLocators();

    Map<String, String> getSubLocators();

}
