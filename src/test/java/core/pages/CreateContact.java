package core.pages;

import core.pages.abstractions.CucumberPage;

import java.util.Map;

public class CreateContact implements CucumberPage {

    private static final Map<String, String> LOCATORS = Map.ofEntries(

    );

    public Map<String, String> getLocators() {
        return LOCATORS;
    }
}
