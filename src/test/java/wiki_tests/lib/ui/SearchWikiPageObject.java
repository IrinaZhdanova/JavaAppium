package wiki_tests.lib.ui;

import io.appium.java_client.AppiumDriver;

public class SearchWikiPageObject extends MainWikiPageObject {

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            LIST_SEARCH_RESULT_SUBSTRING_TPL,
            SEARCH_RESULT_TITLE_AND_DESCRIPTION_TPL,
            LIST_SEARCH_RESULT,
            SEARCH_LINE,
            JAVA_SEARCH_LINE;


    public SearchWikiPageObject(AppiumDriver driver) {

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
        this.waitForElementAndClick((SEARCH_INIT_ELEMENT),
                "Cannot find and click init search element",
                5);
        this.waitForElementPresent((SEARCH_INIT_ELEMENT),
                "Cannot find search input after clicking search init element");
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys((SEARCH_INPUT),
                search_line,
                "Cannot find and type into search input",
                5);
    }

    public void getSearchResultList() {
        this.waitForElementPresent((LIST_SEARCH_RESULT),
                "Search result of 'Python' request is empty",
                10);
    }

    public void getSearchAndClearSearchLine() {
        waitForElementAndClear((SEARCH_LINE),
                "Cannot find search field",
                5);
    }

    public void waitToDisappearRequestInSearch() {
        this.waitForElementNotPresent((LIST_SEARCH_RESULT),
                "Search request is still present on page",
                5);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath,
                "Cannot find search result with substring " + substring);
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        String search_title_description = getResultSearchElementsByTitleAndDescription(title, description);
        this.waitForElementPresent(search_title_description,
                "Cannot find search result after search request " + title + description);
    }


    public int getAmountOfFoundArticles() {
        this.waitForElementPresent((JAVA_SEARCH_LINE),
                "Cannot find anything by request ",
                15);
        return this.getAmountOfElements((JAVA_SEARCH_LINE));
    }
}
