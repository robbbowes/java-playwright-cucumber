package tests.steps.core;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import core.core.config.Screen;
import core.core.config.TestContext;
import core.utils.NavigationBehaviour;
import core.utils.PageElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

}
