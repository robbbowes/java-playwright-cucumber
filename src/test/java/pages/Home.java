package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.abstractions.CucumberPage;


import java.util.Map;

public final class Home implements CucumberPage {

    public Map<String, Locator> getLocators(Page page) {
        return Map.ofEntries(
                Map.entry("contacts header", page.locator("[data-id='contacts']")),
                Map.entry("create button", page.locator("[data-id='add-button']")),
                Map.entry("search", page.locator("[data-id='search']")),
                Map.entry("header logo", page.locator("[data-id='header-logo']")),
                Map.entry("playground button", page.locator("[data-id='playground-button']")),
                Map.entry("contact item", page.locator("[data-id='contact']")),
                Map.entry("delete button", page.locator("button[data-id='delete-button']")),
                Map.entry("name", page.locator("[data-id='name']")),
                Map.entry("gender value", page.locator("[data-id='gender']"))
        );

    }
}