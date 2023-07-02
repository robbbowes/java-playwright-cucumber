package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.abstractions.CucumberPage;

import java.util.Map;

public class CreateContact implements CucumberPage {

    public Map<String, Locator> getLocators(Page page) {
        return Map.ofEntries(
                Map.entry("name", page.locator("input[data-id='name']")),
                Map.entry("phone", page.locator("input[data-id='phone']")),
                Map.entry("street", page.locator("input[data-id='street']")),
                Map.entry("city", page.locator("input[data-id='city']")),
                Map.entry("gender", page.locator("select[data-id='gender']")),
                Map.entry("save button", page.locator("button[data-id='save-button']"))
        );
    }


}
