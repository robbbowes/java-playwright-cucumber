package pages;

import pages.abstractions.CucumberPage;


import java.util.Map;

public final class Home extends CucumberPage {

    private static final Map<String, String> LOCATORS = Map.ofEntries(
            Map.entry("contacts header", "[data-id='contacts']"),
            Map.entry("create button", "[data-id='add-button']"),
            Map.entry("search", "[data-id='search']"),
            Map.entry("header logo", "[data-id='header-logo']"),
            Map.entry("playground button", "[data-id='playground-button']"),
            Map.entry("contact item", "[data-id='contact']"),
            Map.entry("delete button", "button[data-id='delete-button']"),
            Map.entry("name", "[data-id='name']"),
            Map.entry("gender value", "[data-id='gender']")
    );

    public Home() {
        super(LOCATORS);
    }

}
