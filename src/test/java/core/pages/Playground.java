package core.pages;

import core.pages.abstractions.CucumberPage;

import java.util.Map;

public class Playground implements CucumberPage {

    private static final Map<String, String> LOCATORS = Map.ofEntries(
            Map.entry("movies autocomplete", "input#movies-input"),
            Map.entry("new tab button", "[data-id='new-tab-button']")
    );

    public Map<String, String> getLocators() {
        return LOCATORS;
    }
}
