package wiki_tests.lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import wiki_tests.lib.ui.MyWikiListsPageObject;

public class IOSWikiMyListsPageObject extends MyWikiListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{TITLE}')]";
        FOLDER_BY_MANE_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        SYNC_SAVED_ARTICLES_POPUP = "id:Sync your saved articles?";
        CLOSE_BUTTON = "id:Close";
    }

    public IOSWikiMyListsPageObject(AppiumDriver driver) {

        super(driver);
    }
}
