package core.pages;

import core.pages.abstractions.CucumberPage;


import java.util.Map;

public final class Home implements CucumberPage {

    private static final Map<String, String> LOCATORS = Map.ofEntries(
            Map.entry("contacts header", "[data-id='contacts']"),
            Map.entry("create button", "[data-id='add-button']"),
            Map.entry("search input", "[data-id='search']"),
            Map.entry("header logo", "[data-id='header-logo']"),
            Map.entry("playground button", "[data-id='playground-button']")
    );

    public Map<String, String> getLocators() {
        return LOCATORS;
    }

}
