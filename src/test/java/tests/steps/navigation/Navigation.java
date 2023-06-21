package tests.steps.navigation;

import core.core.config.TestContext;
import core.utils.NavigationBehaviour;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Navigation {

    private final TestContext testContext;

    public Navigation(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I am on the {string} page")
    public void onPage(String pageId) {
        NavigationBehaviour.navigateToPage(this.testContext, pageId);
    }

    @Then("I am redirected to the {string} page")
    public void redirected(String pageId) {
        NavigationBehaviour.waitForCorrectPage(this.testContext, pageId);
    }
}
