package pages;

import pages.abstractions.CucumberPage;

import java.util.Map;

public class Playground extends CucumberPage {

    private static final Map<String, String> LOCATORS = Map.ofEntries(
            Map.entry("movies autocomplete", "input#movies-input"),
            Map.entry("new tab button", "[data-id='new-tab-button']"),
            Map.entry("header logo", "[data-id='header-logo']")
    );

    public Playground() {
        super(LOCATORS);
    }

}
