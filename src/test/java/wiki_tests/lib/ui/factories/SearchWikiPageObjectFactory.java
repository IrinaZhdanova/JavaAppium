package wiki_tests.lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.PlatformWiki;
import wiki_tests.lib.ui.SearchWikiPageObject;
import wiki_tests.lib.ui.android.AndroidWikiSearchPageObject;
import wiki_tests.lib.ui.ios.IOSWikiSearchPageObject;
import wiki_tests.lib.ui.mobile_web.MWWikiSearchPageObject;

public class SearchWikiPageObjectFactory {

    public static SearchWikiPageObject get(RemoteWebDriver driver) {

        if (PlatformWiki.getInstance().isAndroid()) {
            return new AndroidWikiSearchPageObject(driver);
        } else if (PlatformWiki.getInstance().isIOS()) {
            return new IOSWikiSearchPageObject(driver);
        } else {
            return new MWWikiSearchPageObject(driver);
        }
    }
}
