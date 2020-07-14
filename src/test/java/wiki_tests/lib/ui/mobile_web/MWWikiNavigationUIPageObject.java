package wiki_tests.lib.ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.NavigationUIWikiPageObject;

public class MWWikiNavigationUIPageObject extends NavigationUIWikiPageObject {

    static {
        MY_LISTS_LINK = "css:a[data-event-name='menu.unStar']";
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
        SEARCH_ICON = "css:#searchIcon";
    }

    public MWWikiNavigationUIPageObject(RemoteWebDriver driver) {

        super(driver);
    }
}
