package wiki_tests.lib.ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.ArticleWikiPageObject;

public class MWWikiArticlePageObject extends ArticleWikiPageObject {

    static {
        TITLE = "css:#content h1";
        ADD_TO_LIST_BUTTON = "css:#page-actions-watch #ca-watch[role='button']";
        FOOTER_ELEMENT = "css:footer";
        PYTHON_ARTICLE_DESCRIPTION = "xpath://div[@class='wikidata-description'][contains(text(), 'General-purpose, high-level')]";
        GOLANG_ARTICLE_DESCRIPTION = "css:li[title='Go (programming language)']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions-watch #ca-watch[role='button']";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:.mw-ui-icon-wikimedia-unStar-progressive.watched";
        GOLANG_ARTICLE_TITLE = "id:section_0";
        TITLE_GOLANG = "id:section_0";
        SEARCH_TITLE = "css:[aria-label='Search Wikipedia']";
    }

    public MWWikiArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

