package tests.steps.filter;

import com.microsoft.playwright.Locator;
import core.setup.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LocatorFilter {

    private final TestContext testContext;

    public LocatorFilter(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("a {string} with the {string} {string} should be displayed")
    public void select(String parentLocatorKey, String childLocatorKey, String text) {
        Locator parentLocator = PageElementLocator.getLocator(this.testContext, parentLocatorKey);
        Locator childLocator = PageElementLocator.getLocator(this.testContext, childLocatorKey);

        Locator matchingLocator = parentLocator.filter(
                new Locator.FilterOptions().setHas(childLocator).setHasText(text)
        );
        Assert.assertNotEquals(matchingLocator.count(), 0);

        this.testContext.getScreen().getLocatorHistory().put(parentLocatorKey, matchingLocator);
    }

    @Then("the {string} on the aforementioned {string} should be {string}")
    public void valueWithTextIsVisible(String childLocatorKey, String locatorLookupKey, String text) {
        Locator parentLocator = this.testContext.getScreen().getLocatorHistory().get(locatorLookupKey);
        Assert.assertNotNull(String.format("No locator found for '%s'", locatorLookupKey));

        Locator childLocator = PageElementLocator.getLocator(this.testContext, childLocatorKey);

        String actualText = parentLocator.locator(childLocator).textContent();
        Assert.assertEquals(actualText, text);
    }
}
