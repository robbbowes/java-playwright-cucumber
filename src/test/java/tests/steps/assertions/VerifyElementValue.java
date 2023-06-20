package tests.steps.assertions;

import com.microsoft.playwright.Locator;
import core.core.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.Then;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerifyElementValue {

    private final TestContext testContext;

    public VerifyElementValue(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("the {string} should contain the text {string}")
    public void shouldContainText(String locatorKey, String expectedText) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        assertThat(locator).containsText(expectedText);
    }

    @Then("the {string} should not contain the text {string}")
    public void shouldNotContainText(String locatorKey, String expectedText) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        assertThat(locator).not().containsText(expectedText);
    }

    @Then("the {string} should equal the text {string}")
    public void shouldEqualText(String locatorKey, String expectedText) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        assertThat(locator).hasText(expectedText);
    }

    @Then("the {string} should not equal the text {string}")
    public void shouldNotEqualText(String locatorKey, String unexpectedText) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        assertThat(locator).not().hasText(unexpectedText);
    }


}
