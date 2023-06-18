package core.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class Screen {

    private Browser browser;
    private BrowserContext context;
    private Page page;

    public Screen(Browser browser, BrowserContext context, Page page) {
        this.browser = browser;
        this.context = context;
        this.page = page;
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
}
