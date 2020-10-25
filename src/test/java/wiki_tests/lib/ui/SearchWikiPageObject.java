package wiki_tests.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.PlatformWiki;

public class SearchWikiPageObject extends MainWikiPageObject {

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            LIST_SEARCH_RESULT_SUBSTRING_TPL,
            SEARCH_RESULT_TITLE_AND_DESCRIPTION_TPL,
            LIST_SEARCH_RESULT,
            SEARCH_LINE,
            JAVA_SEARCH_LINE,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT;


    public SearchWikiPageObject(RemoteWebDriver driver) {

        super(driver);
    }

    /*TEMPLATES METHODS */
    private static String getResultSearchElement(String substring) {
        return LIST_SEARCH_RESULT_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElementsByTitleAndDescription(String title, String description) {
        return SEARCH_RESULT_TITLE_AND_DESCRIPTION_TPL.replace("{TITLE}" + "{DESCRIPTION}", title + description);
    }

    /*TEMPLATES METHODS */

    public void initSearchInput() {
        if (PlatformWiki.getInstance().isMw()) {
            this.waitForElementClickable(SEARCH_INIT_ELEMENT,
                    "Cannot find and click init search element",
                    5);
        }

        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,
                "Cannot find and click init search element - 2",
                10);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT,
                "Cannot find search input after clicking search init element");
    }

    public void typeSearchLine(String search_line) throws InterruptedException {
//        Thread.sleep(4000);
        this.waitForElementAndClick(SEARCH_INPUT,
                "Cannot find and type into search input",
                10);

        this.waitForElementAndSendKeys(SEARCH_INPUT,
                search_line,
                "Cannot find and type into search input - 2",
                10);
    }

    public void getSearchResultList() {
        this.waitForElementPresent(LIST_SEARCH_RESULT,
                "Search result of 'Python' request is empty",
                10);
    }

    public void getSearchAndClearSearchLine() {
        this.waitForElementAndClear(SEARCH_LINE,
                "Cannot find search field",
                5);
    }

    public void waitToDisappearRequestInSearch() {
        if (PlatformWiki.getInstance().isMw()) {
            this.waitForElementPresent(LIST_SEARCH_RESULT,
                    "Search request is still present on page",
                    5);
        } else {
            this.waitForElementNotPresent(LIST_SEARCH_RESULT,
                    "Search request is still present on page - 2",
                    5);
        }
    }

    public void waitForSearchResult(String substring) throws InterruptedException {
        String search_result_xpath = getResultSearchElement(substring);
        Thread.sleep(2000);
        this.waitForElementPresent(search_result_xpath,
                "Cannot find search result with substring " + substring);
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        String search_title_description = getResultSearchElementsByTitleAndDescription(title, description);
        this.waitForElementPresent(search_title_description,
                "Cannot find search result after search request " + title + description);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(JAVA_SEARCH_LINE,
                "Cannot find anything by request ",
                15);
        return this.getAmountOfElements(JAVA_SEARCH_LINE);
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT,
                "CANNOT FIND EMPTY RESULT ELEMENT",
                15);
    }

    public void assertThereIsNoResultOfSearch() {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT,
                "We supposed not to find any results");
    }
}
