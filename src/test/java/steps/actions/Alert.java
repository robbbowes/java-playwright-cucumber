package steps.actions;

import com.microsoft.playwright.Dialog;

import core.setup.config.TestContext;

import io.cucumber.java.en.When;

public class Alert {

    private final TestContext testContext;

    public Alert(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I accept the alert")
    public void acceptAlert() {
        this.testContext.getScreen().getCurrentTabInfo().currentTab().onDialog(Dialog::accept);
    }

}
