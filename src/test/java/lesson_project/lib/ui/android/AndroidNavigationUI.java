package lesson_project.lib.ui.android;

import lesson_project.lib.ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUi {

    static {
        MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }

    public AndroidNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
