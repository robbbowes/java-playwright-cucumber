package tests.steps.assertions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import core.config.Screen;
import core.config.TestContext;
import core.utils.PageElementLocator;
import io.cucumber.java.en.Then;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerifyElementValue extends TestContext {

    private TestContext testContext;

    public VerifyElementValue(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("the {string} should contain the text {string}")
    public void containsText(String locatorKey, String expectedText) {
        Screen screen = getScreen();
        Page page = screen.getPage();
        String elementLocator = PageElementLocator.getLocator(screen, locatorKey);
        Locator locator = page.locator(elementLocator);
        assertThat(locator).containsText(expectedText);
    }

}
