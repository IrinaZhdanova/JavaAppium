package wiki_tests.lib.ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.ArticleWikiPageObject;

public class AndroidWikiArticlePageObject extends ArticleWikiPageObject {

    static {
        SEARCH_TITLE = "id:org.wikipedia:id/search_src_text";
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        PYTHON_ARTICLE_DESCRIPTION = "xpath://*[contains(@text,'An interpreted, high-level')]";
        PYTHON_NAME_ARTICLE_LIST = "xpath://*[@text='Python articles']";
        GOLANG_ARTICLE_TITLE = "xpath://*[@resource-id='org.wikipedia:id/view_page_title_text'][@text='Go (programming language)']";
        GOLANG_ARTICLE_DESCRIPTION = "xpath://*[contains(@text,'Redirected from Golang')]";
        TITLE_PYTHON = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Python (programming language)']";
        TITLE_GOLANG = "id:org.wikipedia:id/view_page_title_text";
        MORE_OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        ADD_TO_LIST_BUTTON = "xpath://*[@text='Add to reading list']";
        GOT_IT_BUTTON = "id:org.wikipedia:id/onboarding_button";
        INPUT_LIST_NAME_BUTTON = "id:org.wikipedia:id/text_input";
        OK_BUTTON = "xpath://*[@text='OK']";
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }

    public AndroidWikiArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
