package pages.abstractions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Map;

public interface CucumberPage {

    Map<String, Locator> getLocators(Page page);

}
