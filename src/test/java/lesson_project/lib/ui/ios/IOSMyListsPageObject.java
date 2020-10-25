package lesson_project.lib.ui.ios;

import lesson_project.lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListsPageObject extends MyListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{TITLE}')]";
        SYNC_SAVED_ARTICLES_POPUP = "id:Sync your saved articles?";
        CLOSE_BUTTON = "id:Close";
    }

    public IOSMyListsPageObject(RemoteWebDriver driver) {

        super(driver);
    }
}
