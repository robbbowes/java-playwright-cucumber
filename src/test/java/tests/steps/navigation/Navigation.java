package tests.steps.navigation;

import com.microsoft.playwright.Page;
import core.core.config.GlobalConfig;
import core.core.config.Screen;
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
//        final Screen screen = this.testContext.getScreen();
//        final Page page = screen.getPage();
//        final GlobalConfig globalConfig = this.testContext.getGlobalConfig();
        NavigationBehaviour.navigateToPage(this.testContext, pageId);
    }

    @Then("I am redirected to the {string} page")
    public void redirected(String pageId) {
//        final Screen screen = this.testContext.getScreen();
//        final Page page = screen.getPage();
//        final GlobalConfig globalConfig = this.testContext.getGlobalConfig();
        NavigationBehaviour.waitForCorrectPage(this.testContext, pageId);
    }
}
