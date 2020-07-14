package lesson_project.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lesson_project.lib.Platform;
import lesson_project.lib.ui.NavigationUi;
import lesson_project.lib.ui.android.AndroidNavigationUI;
import lesson_project.lib.ui.ios.IOSNavigationUI;
import lesson_project.lib.ui.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory {

    public static NavigationUi get(RemoteWebDriver driver) {

        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUI(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSNavigationUI(driver);
        } else {
            return new MWNavigationUI(driver);
        }
    }
}
