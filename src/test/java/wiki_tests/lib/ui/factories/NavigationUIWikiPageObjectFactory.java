package wiki_tests.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lesson_project.lib.Platform;
import wiki_tests.lib.ui.NavigationUIWikiPageObject;
import wiki_tests.lib.ui.android.AndroidWikiNavigationUIPageObject;
import wiki_tests.lib.ui.ios.IOSWikiNavigationUIPageObject;

public class NavigationUIWikiPageObjectFactory {

    public static NavigationUIWikiPageObject get(AppiumDriver driver) {

        if (Platform.getInstance().isAndroid()) {
            return new AndroidWikiNavigationUIPageObject(driver);
        } else {
            return new IOSWikiNavigationUIPageObject(driver);
        }
    }
}
