package pages;

import pages.abstractions.CucumberPage;

import java.util.Map;

public class CreateContact extends CucumberPage {

    private static final Map<String, String> LOCATORS = Map.ofEntries(
            Map.entry("name", "input[data-id='name']"),
            Map.entry("phone", "input[data-id='phone']"),
            Map.entry("street", "input[data-id='street']"),
            Map.entry("city", "input[data-id='city']"),
            Map.entry("gender", "select[data-id='gender']"),
            Map.entry("save button", "button[data-id='save-button']")
    );

    public CreateContact() {
        super(LOCATORS);
    }

}
