package tests.steps.assertions;

import com.microsoft.playwright.Locator;
import core.setup.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.Then;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ElementVisibility {

    private final TestContext testContext;

    public ElementVisibility(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("the {string} should be displayed")
    public void shouldBeDisplayed(String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        assertThat(locator).isVisible();
    }

    @Then("the {string} should not be displayed")
    public void shouldNotBeDisplayed(String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        assertThat(locator).not().isVisible();
    }

}
