package wiki_tests.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.PlatformWiki;

public class NavigationUIWikiPageObject extends MainWikiPageObject {

    protected static String
            MY_LISTS_LINK,
            OPEN_NAVIGATION,
            SEARCH_ICON;

    public NavigationUIWikiPageObject(RemoteWebDriver driver) {

        super(driver);
    }

    public void openNavigation() throws InterruptedException {
        if (PlatformWiki.getInstance().isMw()) {
            this.waitForElementClickable(OPEN_NAVIGATION,
                    "Cannot find and click open navigation button",
                    15);
            this.waitForElementAndClick(OPEN_NAVIGATION,
                    "Cannot find and click open navigation button - 2",
                    10);
        } else {
            System.out.println("Method openNavigation() does nothing for platform "
                    + PlatformWiki.getInstance().getPlatformVar());
        }
    }

    public void openSearchIcon() {

        if (PlatformWiki.getInstance().isMw()) {
            this.waitForElementClickable(SEARCH_ICON,
                    "Cannot locate search icon button",
                    10);
            this.waitForElementAndClick(SEARCH_ICON,
                    "Cannot locate search icon button - 2",
                    5);
        }
    }

    public void clickMyLists() {
        this.waitForElementClickable(MY_LISTS_LINK,
                "Cannot find navigation button to My list",
                10);
        this.waitForElementAndClick(MY_LISTS_LINK,
                "Cannot find navigation button to My list - 2",
                5);
    }
}
