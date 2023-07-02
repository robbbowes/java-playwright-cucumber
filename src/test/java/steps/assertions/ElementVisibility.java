package steps.assertions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import core.setup.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.Then;

public class ElementVisibility {

    private final TestContext testContext;

    public ElementVisibility(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("the {string} should be visible")
    public void theShouldBeDisplayed(String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        PlaywrightAssertions.assertThat(locator).isVisible();
    }

    @Then("^\"(\\d+)\" \"(.+?)\"s? should be displayed$")
    public void numberShouldBeDisplayed(String count, String locatorKey) {
        int i = Integer.parseInt(count);
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        PlaywrightAssertions.assertThat(locator).hasCount(i);
    }

    @Then("the {string} should not be displayed")
    public void shouldNotBeDisplayed(String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        PlaywrightAssertions.assertThat(locator).not().isVisible();
    }



}
