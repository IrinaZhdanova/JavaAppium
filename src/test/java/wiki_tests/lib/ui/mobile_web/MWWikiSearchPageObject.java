package wiki_tests.lib.ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.SearchWikiPageObject;


public class MWWikiSearchPageObject extends SearchWikiPageObject {

    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
    }

    public MWWikiSearchPageObject(RemoteWebDriver driver) {

        super(driver);
    }
}
