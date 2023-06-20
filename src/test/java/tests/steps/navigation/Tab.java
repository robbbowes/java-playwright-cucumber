package tests.steps.navigation;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import core.core.config.Screen;
import core.core.config.TestContext;
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
        String numberString = tabNumber.replaceAll(RegexPatterns.ONLY_NUMBERS.pattern(), "");
        int tabIndex = Integer.parseInt(numberString) - 1;
        Page currentTab = testContext.getScreen().getContext().pages().get(tabIndex);
        this.testContext.getScreen().setCurrentTab(currentTab);
    }

    @Then("I click the {string} the {string} page is opened in a new tab")
    public void newTab(String locatorKey, String pageId) {
        Screen screen = this.testContext.getScreen();

        Page newTab = screen.getCurrentTab().waitForPopup(() -> PageElementLocator.getLocator(this.testContext, locatorKey).click());
        screen.getContext().pages().add(newTab);

        newTab.waitForLoadState(LoadState.DOMCONTENTLOADED);
        testContext.getScreen().setCurrentTab(newTab);

        NavigationBehaviour.waitForCorrectPage(testContext, pageId);
    }
}
