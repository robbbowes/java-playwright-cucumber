package tests.steps;

import core.config.Screen;
import core.config.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends TestContext {

    private TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup(Scenario scenario) {
        testContext.init();
        Screen screen = getScreen();
        System.out.println(scenario.getName());
    }
}
