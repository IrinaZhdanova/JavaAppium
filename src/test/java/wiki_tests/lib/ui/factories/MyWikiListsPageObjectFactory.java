package wiki_tests.lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.PlatformWiki;
import wiki_tests.lib.ui.MyWikiListsPageObject;
import wiki_tests.lib.ui.android.AndroidWikiMyListsPageObject;
import wiki_tests.lib.ui.ios.IOSWikiMyListsPageObject;
import wiki_tests.lib.ui.mobile_web.MWWikiMyListsPageObject;

public class MyWikiListsPageObjectFactory {

    public static MyWikiListsPageObject get(RemoteWebDriver driver) {

        if (PlatformWiki.getInstance().isAndroid()) {
            return new AndroidWikiMyListsPageObject(driver);
        } else if (PlatformWiki.getInstance().isIOS()) {
            return new IOSWikiMyListsPageObject(driver);
        } else {
            return new MWWikiMyListsPageObject(driver);
        }
    }
}
