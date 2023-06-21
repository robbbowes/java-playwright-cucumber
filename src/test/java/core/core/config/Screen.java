package core.core.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import core.core.records.CurrentTabInfo;
import core.pages.Home;
import core.pages.abstractions.CucumberPage;

import java.util.HashMap;
import java.util.Map;

public class Screen {

    private final Browser browser;
    private final BrowserContext context;
    private Page currentTab;
    private CucumberPage currentTabClass;
//    private Map<Page, CucumberPage> currentTabInfo = new HashMap<>();
    private CurrentTabInfo currentTabInfo;

    public Screen(Browser browser, BrowserContext context, Page currentTab) {
        this.browser = browser;
        this.context = context;
        this.currentTab = currentTab;
        this.currentTabClass = new Home();
//        this.currentTabInfo.put(this.currentTab, new Home());
        this.currentTabInfo = new CurrentTabInfo(this.currentTab, new Home());
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

//    public CucumberPage getCurrentTabClass() {
//        return currentTabClass;
//    }
//
//    public void setCurrentTabClass(CucumberPage currentTabClass) {
//        this.currentTabClass = currentTabClass;
//    }

    public CurrentTabInfo getCurrentTabInfo() {
        return this.currentTabInfo;
    }

    public void setCurrentTabInfo(Page currentTab, CucumberPage currentTabClass) {
        this.currentTabInfo = new CurrentTabInfo(currentTab, currentTabClass);
    }

//    public Map<Page, CucumberPage> getCurrentTabsInfo() {
//        return this.currentTabInfo;
//    }
}
