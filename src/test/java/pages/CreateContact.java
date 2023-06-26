package pages;

import pages.abstractions.CucumberPage;

import java.util.Map;

public class CreateContact implements CucumberPage {

    private static final Map<String, String> LOCATORS = Map.ofEntries(

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
