package tests.steps.assertions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import core.setup.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ElementText {

    private final TestContext testContext;

    public ElementText(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("the {string} should contain the text {string}")
    public void shouldContainText(String locatorKey, String expectedText) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        PlaywrightAssertions.assertThat(locator).containsText(expectedText);
    }

    @Then("the {string} should not contain the text {string}")
    public void shouldNotContainText(String locatorKey, String expectedText) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        PlaywrightAssertions.assertThat(locator).not().containsText(expectedText);
    }

    @Then("the {string} should equal the text {string}")
    public void shouldEqualText(String locatorKey, String expectedText) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        PlaywrightAssertions.assertThat(locator).hasText(expectedText);
    }

    @Then("the {string} should not equal the text {string}")
    public void shouldNotEqualText(String locatorKey, String unexpectedText) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        PlaywrightAssertions.assertThat(locator).not().hasText(unexpectedText);
    }

    @Then("on the {string} the {string} should be {string}")
    public void valueWithTextIsVisible(String locatorLookupKey, String childLocatorKey, String text) {
        Locator parentLocator = this.testContext.getScreen().getLocatorHistory().get(locatorLookupKey);
        Assert.assertNotNull(String.format("No locator found for '%s'", locatorLookupKey));

        Locator childLocator = PageElementLocator.getLocator(this.testContext, childLocatorKey);

        String actualText = parentLocator.locator(childLocator).textContent();
        Assert.assertEquals(actualText, text);
    }


}
