package tests.steps;

import core.setup.config.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup(Scenario scenario) {
        System.out.println(scenario.getName());
        this.testContext.init();
    }

    @After
    public void teardown() {
        this.testContext.closeBrowser();
        this.testContext.quitPlaywright();
    }

}
