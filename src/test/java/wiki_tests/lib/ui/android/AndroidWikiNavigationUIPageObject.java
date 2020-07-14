package wiki_tests.lib.ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.NavigationUIWikiPageObject;

public class AndroidWikiNavigationUIPageObject extends NavigationUIWikiPageObject {

    static {
        MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }

    public AndroidWikiNavigationUIPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
