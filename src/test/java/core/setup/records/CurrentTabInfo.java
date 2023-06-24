package core.setup.records;

import com.microsoft.playwright.Page;
import pages.abstractions.CucumberPage;

public record CurrentTabInfo(Page currentTab, CucumberPage currentTabClass) {
}
