package pages.abstractions;

import java.util.Map;

public abstract class CucumberPage {

    private final Map<String, String> locators;

    protected CucumberPage(Map<String, String> locators) {
        this.locators = locators;
    }

    public Map<String, String> getLocators() {
        return locators;
    }

}
