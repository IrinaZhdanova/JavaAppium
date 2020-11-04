package wiki_tests.lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.PlatformWiki;
import wiki_tests.lib.ui.NavigationUIWikiPageObject;
import wiki_tests.lib.ui.android.AndroidWikiNavigationUIPageObject;
import wiki_tests.lib.ui.ios.IOSWikiNavigationUIPageObject;
import wiki_tests.lib.ui.mobile_web.MWWikiNavigationUIPageObject;

public class NavigationUIWikiPageObjectFactory {

    public static NavigationUIWikiPageObject get(RemoteWebDriver driver) {
        if (PlatformWiki.getInstance().isAndroid()) {
            return new AndroidWikiNavigationUIPageObject(driver);
        } else if (PlatformWiki.getInstance().isIOS()) {
            return new IOSWikiNavigationUIPageObject(driver);
        } else {
            return new MWWikiNavigationUIPageObject(driver);
        }
    }
}
