package core.setup.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import core.setup.records.CurrentTabInfo;
import pages.Home;
import pages.abstractions.CucumberPage;

public class Screen {

    private final Browser browser;
    private final BrowserContext context;
    private CurrentTabInfo currentTabInfo;

    public Screen(Browser browser, BrowserContext context, Page currentTab) {
        this.browser = browser;
        this.context = context;
        this.currentTabInfo = new CurrentTabInfo(currentTab, new Home());
    }

    public Browser getBrowser() {
        return browser;
    }

    public BrowserContext getContext() {
        return context;
    }

    public CurrentTabInfo getCurrentTabInfo() {
        return this.currentTabInfo;
    }

    public void setCurrentTabInfo(Page currentTab, CucumberPage currentTabClass) {
        this.currentTabInfo = new CurrentTabInfo(currentTab, currentTabClass);
    }

}
