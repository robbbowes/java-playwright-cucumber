package core.pages;

import core.records.ElementKeyInfo;

import java.util.Arrays;
import java.util.List;

public final class Home {

    private static final List<ElementKeyInfo> LOCATORS = Arrays.asList(
            new ElementKeyInfo("contacts header", "[data-id='contacts']"),
            new ElementKeyInfo("create", "[data-id='add-button']"),
            new ElementKeyInfo("search", "[data-id='search']"),
            new ElementKeyInfo("header logo", "[data-id='header-logo']")
    );

    public List<ElementKeyInfo> getLocators() {
        return LOCATORS;
    }
}
