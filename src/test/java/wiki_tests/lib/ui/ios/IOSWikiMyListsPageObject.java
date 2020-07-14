package wiki_tests.lib.ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.MyWikiListsPageObject;

public class IOSWikiMyListsPageObject extends MyWikiListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{TITLE}')]";
        FOLDER_BY_MANE_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        SYNC_SAVED_ARTICLES_POPUP = "id:Sync your saved articles?";
        CLOSE_BUTTON = "id:Close";
    }

    public IOSWikiMyListsPageObject(RemoteWebDriver driver) {

        super(driver);
    }
}
