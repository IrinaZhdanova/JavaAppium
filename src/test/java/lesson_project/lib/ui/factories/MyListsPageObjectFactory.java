package lesson_project.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lesson_project.lib.Platform;
import lesson_project.lib.ui.MyListsPageObject;
import lesson_project.lib.ui.android.AndroidMyListsPageObject;
import lesson_project.lib.ui.ios.IOSMyListsPageObject;
import lesson_project.lib.ui.mobile_web.MWMyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObjectFactory {

    public static MyListsPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSMyListsPageObject(driver);
        } else {
            return new MWMyListsPageObject(driver);
        }
    }
}
