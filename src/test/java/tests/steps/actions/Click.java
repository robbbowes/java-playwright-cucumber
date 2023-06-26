package tests.steps.actions;

import com.microsoft.playwright.Locator;
import core.setup.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Click {

    private final TestContext testContext;

    public Click(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I click the {string}")
    public void clickThe(String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        locator.click();
    }

    @Then("I click on the {string} on the aforementioned {string}")
    public void valueWithTextIsVisible(String childLocatorKey, String locatorLookupKey) {
        Locator parentLocator = this.testContext.getScreen().getLocatorHistory().get(locatorLookupKey);
        Assert.assertNotNull(String.format("No locator found for '%s'", locatorLookupKey));

        Locator childLocator = PageElementLocator.getLocator(this.testContext, childLocatorKey);

        parentLocator.locator(childLocator).click();
    }

}
