package wiki_tests.lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import wiki_tests.lib.ui.NavigationUIWikiPageObject;

public class IOSWikiNavigationUIPageObject extends NavigationUIWikiPageObject {

    static {
        MY_LISTS_LINK = "id:Saved";
    }

    public IOSWikiNavigationUIPageObject(AppiumDriver driver) {
        super(driver);
    }
}
