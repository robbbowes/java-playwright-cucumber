package core.config;

import com.microsoft.playwright.*;
import core.utils.PropertiesReader;

import java.util.ArrayList;
import java.util.Properties;

public class TestContext {

    private static final ThreadLocal<Playwright> PLAYWRIGHT_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Browser> BROWSER_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> BROWSER_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Page> PAGE_THREAD_LOCAL = new ThreadLocal<>();
    private static Screen screen;
    private static GlobalConfig globalConfig;

    public void init() {
        final Properties driverProperties = PropertiesReader.read("config/environment.properties");
        final String browserName = driverProperties.getProperty("browser");


        initPlaywright();
        Browser browser = initBrowser(browserName);
        BrowserContext browserContext = initBrowserContext();
        Page page = initPage();
        screen = new Screen(browser, browserContext, page);

        globalConfig = new GlobalConfig();
    }

    public Screen getScreen() {
        return screen;
    }

    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }

    private static Playwright getPlaywright() {
        return PLAYWRIGHT_THREAD_LOCAL.get();
    }

    private static Browser getBrowser() {
        return BROWSER_THREAD_LOCAL.get();
    }

    private static BrowserContext getBrowserContext() {
        return BROWSER_CONTEXT_THREAD_LOCAL.get();
    }

    private static Page getPage() {
        return PAGE_THREAD_LOCAL.get();
    }

    private void initPlaywright() {
        Playwright playwright = Playwright.create();
        PLAYWRIGHT_THREAD_LOCAL.set(playwright);
    }

    private Browser initBrowser(final String browserName) {
        ArrayList<String> args = new ArrayList<>();
        args.add("--start-maximized");

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

    private BrowserContext initBrowserContext() {
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setViewportSize(null);
        Browser browser = BROWSER_THREAD_LOCAL.get();
        BrowserContext browserContext = browser.newContext(contextOptions);
        BROWSER_CONTEXT_THREAD_LOCAL.set(browserContext);
        return BROWSER_CONTEXT_THREAD_LOCAL.get();
    }

    private Page initPage() {
        Page page = getBrowserContext().newPage();
        PAGE_THREAD_LOCAL.set(page);
        return PAGE_THREAD_LOCAL.get();
    }

//    public static void openPage(String url) {
//        getPage().navigate(url);
//    }

    public static void closeBrowser() {
        screen.getBrowser().close();
        screen.getPage().close();
    }

    public static void quitPlaywright() {
        if (screen.getPage() != null) {
            getPlaywright().close();
        }
    }
}
