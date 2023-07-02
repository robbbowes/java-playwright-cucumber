package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.abstractions.CucumberPage;

import java.util.Map;

public class Playground implements CucumberPage {

    public Map<String, Locator> getLocators(Page page) {
        return Map.ofEntries(
                Map.entry("movies autocomplete", page.locator("input#movies-input")),
                Map.entry("new tab button", page.locator("[data-id='new-tab-button']")),
                Map.entry("header logo", page.locator("[data-id='header-logo']"))
        );
    }

}
