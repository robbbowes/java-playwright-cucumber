package core.core.records;

import com.microsoft.playwright.Page;
import core.pages.abstractions.CucumberPage;

public record CurrentTabInfo(Page currentTab, CucumberPage currentTabClass) {
}
