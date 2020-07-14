package wiki_tests.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lesson_project.lib.Platform;
import wiki_tests.lib.ui.ArticleWikiPageObject;
import wiki_tests.lib.ui.android.AndroidWikiArticlePageObject;
import wiki_tests.lib.ui.ios.IOSWikiArticlePageObject;

public class ArticleWikiPageObjectFactory {

    public static ArticleWikiPageObject get(AppiumDriver driver) {

        if (Platform.getInstance().isAndroid()) {
            return new AndroidWikiArticlePageObject(driver);
        } else {
            return new IOSWikiArticlePageObject(driver);
        }
    }
}
