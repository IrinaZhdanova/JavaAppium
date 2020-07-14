package wiki_tests.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lesson_project.lib.Platform;
import wiki_tests.lib.ui.MyWikiListsPageObject;
import wiki_tests.lib.ui.android.AndroidWikiMyListsPageObject;
import wiki_tests.lib.ui.ios.IOSWikiMyListsPageObject;

public class MyWikiListsPageObjectFactory {

    public static MyWikiListsPageObject get(AppiumDriver driver) {

        if (Platform.getInstance().isAndroid()) {
            return new AndroidWikiMyListsPageObject(driver);
        } else {
            return new IOSWikiMyListsPageObject(driver);
        }
    }
}
