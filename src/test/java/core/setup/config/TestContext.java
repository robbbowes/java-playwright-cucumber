package core.setup.config;

import com.microsoft.playwright.*;
import core.setup.records.PageRouteInfo;
import core.utils.PropertiesReader;
import pages.abstractions.CucumberPage;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

public class TestContext {

    private static final ThreadLocal<Playwright> PLAYWRIGHT_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Browser> BROWSER_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> BROWSER_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Page> PAGE_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Screen> SCREEN_THREAD_LOCAL = new ThreadLocal<>();
    private Map<CucumberPage, PageRouteInfo> mappings;
    private String browserName;
    private String baseUrl;

    public void init() {
        final Properties driverProperties = PropertiesReader.read("config/environment.properties");
        browserName = driverProperties.getProperty("browser");
        baseUrl = driverProperties.getProperty("url");
        mappings = PageMappings.getMappings();

        initPlaywright();
        Browser browser = initBrowser(browserName);
        BrowserContext browserContext = initBrowserContext(browser);
        Page page = initPage(browserContext);
        page.onDialog(Dialog::accept);

        Screen screen = new Screen(browser, browserContext, page);
        SCREEN_THREAD_LOCAL.set(screen);
    }

    public Screen getScreen() {
        return SCREEN_THREAD_LOCAL.get();
    }

    public Map<CucumberPage, PageRouteInfo> getMappings() {
        return mappings;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    private static Playwright getPlaywright() {
        return PLAYWRIGHT_THREAD_LOCAL.get();
    }

    private void initPlaywright() {
        Playwright playwright = Playwright.create();
        PLAYWRIGHT_THREAD_LOCAL.set(playwright);
    }

    private Browser initBrowser(final String browserName) {
        ArrayList<String> args = new ArrayList<>();
        args.add("--start-maximized");
        args.add("--parallel 3");
        args.add("-f json:./reports/report.json");

        Browser browser;
        switch (browserName) {
            case "chrome" -> browser = getPlaywright().chromium().launch(
                    new BrowserType.LaunchOptions().setChannel("chromium").setHeadless(false).setArgs(args));

            case "headless" -> browser = getPlaywright().chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(true));

            case "firefox" -> browser = getPlaywright().firefox().launch(
                    new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(false).setArgs(args));

            case "webkit" -> browser = getPlaywright().webkit().launch(
                    new BrowserType.LaunchOptions().setHeadless(true).setArgs(args));

            default -> throw new IllegalStateException("Unexpected value: " + browserName);
        }
        BROWSER_THREAD_LOCAL.set(browser);
        return BROWSER_THREAD_LOCAL.get();
    }

    private BrowserContext initBrowserContext(Browser browser) {
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setViewportSize(null);
        BrowserContext browserContext = browser.newContext(contextOptions);
        BROWSER_CONTEXT_THREAD_LOCAL.set(browserContext);
        return BROWSER_CONTEXT_THREAD_LOCAL.get();
    }

    private Page initPage(BrowserContext browserContext) {
        Page page = browserContext.newPage();
        PAGE_THREAD_LOCAL.set(page);
        return PAGE_THREAD_LOCAL.get();
    }

    public void closeBrowser() {
        getScreen().getBrowser().close();
        getScreen().getCurrentTabInfo().currentTab().close();
    }

    public void quitPlaywright() {
        if (getScreen().getCurrentTabInfo().currentTab() != null) {
            getPlaywright().close();
        }
    }
}
