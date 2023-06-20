package tests.steps.core;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import core.core.config.Screen;
import core.core.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

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

    @Then("I click the {string} a new tab is opened")
    public void newTab(String locatorKey) {
        Screen screen = this.testContext.getScreen();
        Page newTab = screen.getPage().waitForPopup(() -> PageElementLocator.getLocator(this.testContext, locatorKey).click());
        screen.getContext().pages().add(newTab);
    }
}
