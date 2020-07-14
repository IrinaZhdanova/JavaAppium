package wiki_tests.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lesson_project.lib.Platform;
import wiki_tests.lib.ui.SearchWikiPageObject;
import wiki_tests.lib.ui.android.AndroidWikiSearchPageObject;
import wiki_tests.lib.ui.ios.IOSWikiSearchPageObject;

public class SearchWikiPageObjectFactory {

    public static SearchWikiPageObject get(AppiumDriver driver) {

        if (Platform.getInstance().isAndroid()) {
            return new AndroidWikiSearchPageObject(driver);
        } else {
            return new IOSWikiSearchPageObject(driver);
        }
    }
}
