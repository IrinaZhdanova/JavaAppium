package lesson_project.lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lesson_project.lib.ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUI extends NavigationUi {

    static {
        MY_LISTS_LINK = "id:Saved";
    }

    public IOSNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
