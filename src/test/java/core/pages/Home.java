package core.pages;

import core.pages.abstractions.CucumberPage;


import java.util.Map;

public final class Home extends CucumberPage {

    private static final Map<String, String> LOCATORS = Map.ofEntries(
            Map.entry("contacts header", "[data-id='contacts']"),
            Map.entry("create", "[data-id='add-button']"),
            Map.entry("search", "[data-id='search']"),
            Map.entry("header logo", "[data-id='header-logo']")
    );

    public Map<String, String> getLocators() {
        return LOCATORS;
    }

}
