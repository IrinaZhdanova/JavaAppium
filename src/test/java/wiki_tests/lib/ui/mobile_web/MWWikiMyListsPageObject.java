package wiki_tests.lib.ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.MyWikiListsPageObject;

public class MWWikiMyListsPageObject extends MyWikiListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://li[@class='page-summary with-watchstar']//h3[contains(text(), '{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://a[contains(@class, 'watched')]/../a/h3[contains(text(), '{TITLE}')]";
    }


    public MWWikiMyListsPageObject(RemoteWebDriver driver) {

        super(driver);
    }

}
