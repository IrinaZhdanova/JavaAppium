package lesson_project.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lesson_project.lib.Platform;
import lesson_project.lib.ui.SearchPageObject;
import lesson_project.lib.ui.android.AndroidSearchPageObject;
import lesson_project.lib.ui.ios.IOSSearchPageObject;
import lesson_project.lib.ui.mobile_web.MWSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory {

    public static SearchPageObject get(RemoteWebDriver driver) {

        if (Platform.getInstance().isAndroid()) {
            return new AndroidSearchPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSSearchPageObject(driver);
        } else {
            return new MWSearchPageObject(driver);
        }
    }
}
