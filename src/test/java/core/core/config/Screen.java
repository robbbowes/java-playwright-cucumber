package core.core.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import core.pages.Home;
import core.pages.abstractions.CucumberPage;

public class Screen {

    private Browser browser;
    private BrowserContext context;
    private Page page;
    private Class<? extends CucumberPage> currentPageClass;

    public Screen(Browser browser, BrowserContext context, Page page) {
        this.browser = browser;
        this.context = context;
        this.page = page;
        this.currentPageClass = Home.class;
    }

    public Browser getBrowser() {
        return browser;
    }

    public BrowserContext getContext() {
        return context;
    }

    public Page getPage() {
        return page;
    }

    public Class<? extends CucumberPage> getCurrentPageClass() {
        return currentPageClass;
    }

    public void setCurrentPageClass(Class<? extends CucumberPage> currentPageClass) {
        this.currentPageClass = currentPageClass;
    }
}
