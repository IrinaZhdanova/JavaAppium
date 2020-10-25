package wiki_tests.lib.ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.ArticleWikiPageObject;

public class IOSWikiArticlePageObject extends ArticleWikiPageObject {

    static {
        SEARCH_TITLE = "id:Search Wikipedia";
        TITLE_GOLANG = "id:Go (programming language)";
        PYTHON_ARTICLE_DESCRIPTION = "id:General-purpose, high-level programming language";
        GOLANG_ARTICLE_DESCRIPTION = "id:Go (programming language)";
        GOLANG_ARTICLE_TITLE = "id:Go (programming language)";
        TITLE_PYTHON = "id:Python (programming language)";
        ADD_TO_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        CANCEL_BUTTON = "id:Cancel";
    }

    public IOSWikiArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
