package lesson_project.lib.ui.mobile_web;

import lesson_project.lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions-watch #ca-watch[role='button']";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:.mw-ui-icon-wikimedia-unStar-progressive.watched";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
