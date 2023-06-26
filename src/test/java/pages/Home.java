package pages;

import pages.abstractions.CucumberPage;


import java.util.Map;

public final class Home implements CucumberPage {

    private static final Map<String, String> LOCATORS = Map.ofEntries(
            Map.entry("contacts header", "[data-id='contacts']"),
            Map.entry("create button", "[data-id='add-button']"),
            Map.entry("search", "[data-id='search']"),
            Map.entry("header logo", "[data-id='header-logo']"),
            Map.entry("playground button", "[data-id='playground-button']"),
            Map.entry("contact item", "[data-id='contact']"),
            Map.entry("delete button", "button[data-id='delete-button']")
    );

    private static final Map<String, String> SUB_LOCATORS = Map.ofEntries(

    );

    public Map<String, String> getLocators() {
        return LOCATORS;
    }

    public Map<String, String> getSubLocators() {
        return SUB_LOCATORS;
    }

}
