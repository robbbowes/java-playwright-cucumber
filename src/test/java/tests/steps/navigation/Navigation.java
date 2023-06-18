package tests.steps.navigation;

import com.microsoft.playwright.Page;
import core.config.GlobalConfig;
import core.config.Screen;
import core.config.TestContext;
import core.pages.abstractions.CucumberPage;
import core.utils.NavigationBehaviour;
import io.cucumber.java.en.Given;

public class Navigation extends TestContext {

    private TestContext testContext;

    public Navigation(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I am on the {string} page")
    public void onPage(String pageName) {
        Screen screen = testContext.getScreen();

        Page page = screen.getPage();
        GlobalConfig globalConfig = testContext.getGlobalConfig();

        NavigationBehaviour.navigateToPage(page, pageName, globalConfig);

        System.out.println("I'm on the " + pageName);
    }
}
