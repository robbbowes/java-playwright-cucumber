package tests.steps.assertions;

import core.config.GlobalConfig;
import core.config.Screen;
import core.config.TestContext;
import io.cucumber.java.en.Then;

public class VerifyElementValue extends TestContext {

    private TestContext testContext;

    public VerifyElementValue(TestContext testContext) {
        this.testContext = testContext;
    }


    @Then("the {string} should contain the text {string}")
    public void containsText(String locator, String expectedText) {
        System.out.println(locator);
        System.out.println(expectedText);
        Screen screen = getScreen();
        GlobalConfig globalConfig = getGlobalConfig();
    }
}
