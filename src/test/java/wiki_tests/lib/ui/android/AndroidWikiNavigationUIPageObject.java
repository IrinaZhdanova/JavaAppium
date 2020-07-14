package wiki_tests.lib.ui.android;

import io.appium.java_client.AppiumDriver;
import wiki_tests.lib.ui.NavigationUIWikiPageObject;

public class AndroidWikiNavigationUIPageObject extends NavigationUIWikiPageObject {

    static {
        MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }

    public AndroidWikiNavigationUIPageObject(AppiumDriver driver) {
        super(driver);
    }
}
