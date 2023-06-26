package tests.steps.actions;

import com.microsoft.playwright.Locator;
import core.setup.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.When;

public class Select {

    private final TestContext testContext;

    public Select(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I select {string} in the {string} dropdown")
    public void select(String text, String locatorKey) {
        Locator locator = PageElementLocator.getLocator(this.testContext, locatorKey);
        locator.selectOption(text);
    }
}
