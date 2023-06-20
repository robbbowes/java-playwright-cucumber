package tests.steps.navigation;

import com.microsoft.playwright.Page;
import core.core.config.GlobalConfig;
import core.core.config.Screen;
import core.core.config.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class Tab {

    private final TestContext testContext;

    public Tab(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("^I switch to the \"([0-9]+st|[0-9]+nd|[0-9]+rd|[0-9]+th)\" tab$")
    public void onPage(String tabNumber) {
        Screen screen = this.testContext.getScreen();
        System.out.println(tabNumber);
    }


}
