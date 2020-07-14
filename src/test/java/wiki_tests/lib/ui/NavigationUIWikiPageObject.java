package wiki_tests.lib.ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUIWikiPageObject extends MainWikiPageObject {

    protected static String
            MY_LISTS_LINK;

    public NavigationUIWikiPageObject(AppiumDriver driver) {

        super(driver);
    }

    public void clickMyLists() {
        this.waitForElementAndClick((MY_LISTS_LINK),
                "Cannot find navigation button to My list",
                5);
    }
}
