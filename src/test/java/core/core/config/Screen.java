package core.core.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import core.pages.Home;
import core.pages.abstractions.CucumberPage;

public class Screen {

    private final Browser browser;
    private final BrowserContext context;
    private Page currentTab;
    private Class<? extends CucumberPage> currentTabClass;

    public Screen(Browser browser, BrowserContext context, Page currentTab) {
        this.browser = browser;
        this.context = context;
        this.currentTab = currentTab;
        this.currentTabClass = Home.class;
    }

    public Browser getBrowser() {
        return browser;
    }

    public BrowserContext getContext() {
        return context;
    }

    public Page getCurrentTab() {
        return currentTab;
    }

    public void setCurrentTab(Page tab) {
        currentTab = tab;
    }

    public Class<? extends CucumberPage> getCurrentTabClass() {
        return currentTabClass;
    }

    public void setCurrentTabClass(Class<? extends CucumberPage> currentTabClass) {
        this.currentTabClass = currentTabClass;
    }
}
