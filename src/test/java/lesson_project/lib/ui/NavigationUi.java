package lesson_project.lib.ui;

import lesson_project.lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUi extends MainPageObject {

    protected static String
            MY_LISTS_LINK,
            OPEN_NAVIGATION;

    public NavigationUi(RemoteWebDriver driver) {
        super(driver);
    }

    public void openNavigation() throws InterruptedException {
        if (Platform.getInstance().isMw()) {
            this.waitForElementClickable(OPEN_NAVIGATION,
                    "Cannot find and click open navigation button",
                    10);
            this.waitForElementAndClick(OPEN_NAVIGATION,
                    "Cannot find and click open navigation button - 2",
                    10);
        } else {
            System.out.println("Method openNavigation() does nothing for platform "
                    + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists() {
        if (Platform.getInstance().isMw()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5);
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5);
        }
    }
}
