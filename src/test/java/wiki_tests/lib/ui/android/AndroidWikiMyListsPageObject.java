package wiki_tests.lib.ui.android;

import io.appium.java_client.AppiumDriver;
import wiki_tests.lib.ui.MyWikiListsPageObject;

public class AndroidWikiMyListsPageObject extends MyWikiListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
        MY_LIST = "id:org.wikipedia:id/item_title";
        FOLDER_BY_MANE_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        PYTHON_ARTICLE_IN_FOLDER = "xpath://*[@text='Python (programming language)']";
        PYTHON_TITLE_ARTICLE_CARD = "xpath://*[@resource-id='org.wikipedia:id/view_page_title_text'][@text='Python (programming language)']";
    }


    public AndroidWikiMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
