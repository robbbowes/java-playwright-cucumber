package tests.steps.navigation;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import core.setup.config.Screen;
import core.setup.config.TestContext;
import pages.abstractions.CucumberPage;
import core.utils.NavigationBehaviour;
import core.utils.PageElementLocator;
import core.utils.RegexPatterns;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tab {

    private final TestContext testContext;

    public Tab(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("^I switch to the \"([0-9]+st|[0-9]+nd|[0-9]+rd|[0-9]+th)\" tab$")
    public void onPage(String tabNumber) {
        final String numberString = tabNumber.replaceAll(RegexPatterns.ONLY_NUMBERS.pattern(), "");
        final int tabIndex = Integer.parseInt(numberString) - 1;

        final Page currentTab = this.testContext.getScreen().getContext().pages().get(tabIndex);

        currentTab.bringToFront();

        final CucumberPage currentTabClass = NavigationBehaviour.getCurrentTabClass(testContext.getMappings(), currentTab);
        this.testContext.getScreen().setCurrentTabInfo(currentTab, currentTabClass);
    }

    @Then("I click the {string} the {string} page is opened in a new tab")
    public void newTab(String locatorKey, String pageId) {
        final Screen screen = this.testContext.getScreen();
        final Page newTab = screen.getCurrentTabInfo().currentTab().waitForPopup(()
                -> PageElementLocator.getLocator(this.testContext, locatorKey).click());

        screen.getContext().pages().add(newTab);

        newTab.waitForLoadState(LoadState.DOMCONTENTLOADED);
        newTab.bringToFront();

        final CucumberPage currentTabClass = NavigationBehaviour.getCurrentTabClass(testContext.getMappings(), newTab);
        testContext.getScreen().setCurrentTabInfo(newTab, currentTabClass);

        NavigationBehaviour.waitForCorrectPage(testContext, pageId);
    }

}
