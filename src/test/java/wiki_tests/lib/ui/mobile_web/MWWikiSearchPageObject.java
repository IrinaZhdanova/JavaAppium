package wiki_tests.lib.ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.SearchWikiPageObject;


public class MWWikiSearchPageObject extends SearchWikiPageObject {

    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        SEARCH_LINE = "css:[name='search'][class='search']";
        LIST_SEARCH_RESULT = "css:.search-results-view[style='display: none;']";
        LIST_SEARCH_RESULT_SUBSTRING_TPL = "xpath://li[@class='page-summary with-watchstar']//*[contains(text(),'{SUBSTRING}')]";
    }

    public MWWikiSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
