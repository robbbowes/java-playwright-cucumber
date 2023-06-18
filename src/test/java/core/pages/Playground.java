package core.pages;

import core.pages.abstractions.CucumberPage;

import java.util.Map;

public class Playground extends CucumberPage {

    private static final Map<String, String> LOCATORS = Map.ofEntries(
            Map.entry("movies autocomplete", "input#movies-input")
    );

    public Map<String, String> getLocators() {
        return LOCATORS;
    }
}
