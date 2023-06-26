package tests.steps.actions;

import com.microsoft.playwright.Locator;
import core.setup.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.When;

public class Input {

    private final TestContext testContext;

    public Input(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I type {string} in the {string}")
    public void clickThe(String text, String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        locator.fill(text);
    }
}
