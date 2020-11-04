package wiki_tests.lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.PlatformWiki;
import wiki_tests.lib.ui.ArticleWikiPageObject;
import wiki_tests.lib.ui.android.AndroidWikiArticlePageObject;
import wiki_tests.lib.ui.ios.IOSWikiArticlePageObject;
import wiki_tests.lib.ui.mobile_web.MWWikiArticlePageObject;

public class ArticleWikiPageObjectFactory {

    public static ArticleWikiPageObject get(RemoteWebDriver driver) {
        if (PlatformWiki.getInstance().isAndroid()) {
            return new AndroidWikiArticlePageObject(driver);
        } else if (PlatformWiki.getInstance().isIOS()) {
            return new IOSWikiArticlePageObject(driver);
        } else {
            return new MWWikiArticlePageObject(driver);
        }
    }
}
