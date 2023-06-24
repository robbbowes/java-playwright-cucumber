package tests.steps.actions;

import com.microsoft.playwright.Locator;
import core.setup.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Check {

    private final TestContext testContext;

    public Check(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I check the {string} checkbox")
    public void check(String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        locator.check();
    }

    @When("I uncheck the {string} checkbox")
    public void uncheck(String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        locator.uncheck();
    }

    @Then("the {string} checkbox is checked")
    public void isChecked(String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        assertThat(locator).isChecked();
    }

    @Then("the {string} checkbox is unchecked")
    public void isUnchecked(String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        assertThat(locator).not().isChecked();
    }

}
