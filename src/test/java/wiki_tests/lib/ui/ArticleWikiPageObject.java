package wiki_tests.lib.ui;

import io.appium.java_client.AppiumDriver;
import lesson_project.lib.Platform;
import org.openqa.selenium.WebElement;
import wiki_tests.lib.PlatformWiki;

public class ArticleWikiPageObject extends MainWikiPageObject {

    protected static String
            TITLE,
            SEARCH_TITLE,
            TITLE_GOLANG,
            TITLE_PYTHON,
            PYTHON_ARTICLE_DESCRIPTION,
            PYTHON_NAME_ARTICLE_LIST,
            GOLANG_ARTICLE_TITLE,
            GOLANG_ARTICLE_DESCRIPTION,
            MORE_OPTIONS_BUTTON,
            ADD_TO_LIST_BUTTON,
            GOT_IT_BUTTON,
            INPUT_LIST_NAME_BUTTON,
            OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            CANCEL_BUTTON;


    public ArticleWikiPageObject(AppiumDriver driver) {

        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent((TITLE_GOLANG),
                "Cannot find 'search' article title on page",
                15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if(Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public String waitForSearchTitleElement() {
        if(PlatformWiki.getInstance().isAndroid()) {
            return this.waitForElementPresent(SEARCH_TITLE,
                    "Cannot find 'search' article title on page",
                    15).getAttribute("text");
        } else{
            return this.waitForElementPresent(SEARCH_TITLE,
                    "Cannot find 'search' article title on page",
                    15).getAttribute("name");
        }
    }

    public void waitForShortPythonDescriptionAndClick() {
        this.waitForElementAndClick((
                PYTHON_ARTICLE_DESCRIPTION),
                "Cannot find 'An interpreted, high-level' in Python request search",
                5);
    }

    public void getArticleCard() {
        if(PlatformWiki.getInstance().isAndroid()) {
            this.waitForElementPresent(
                    TITLE,
                    "Cannot find article card",
                    15);
        } else if(PlatformWiki.getInstance().isIOS()){
            this.waitForElementPresent(TITLE_PYTHON,
                    "Cannot find article card",
                    15);
        }
    }

    public void getWikiArticleTwoSteps() {
        this.waitForElementAndClick((MORE_OPTIONS_BUTTON),
                "Cannot find button to open article options",
                5);

        this.waitForElementAndClick((ADD_TO_LIST_BUTTON),
                "Cannot find option to add article to reading list",
                5);
    }

    public void getWikiArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick((GOT_IT_BUTTON),
                "Cannot find 'Got it' button",
                5);

        this.waitForElementAndClear((INPUT_LIST_NAME_BUTTON),
                "Cannot find input to set name article folder",
                5);

        this.waitForElementAndSendKeys((INPUT_LIST_NAME_BUTTON),
                name_of_folder,
                "Cannot put text into articles folder input",
                5);

        this.waitForElementAndClick((OK_BUTTON),
                "Cannot press OK button",
                5);
    }

    public void getSecondWikiArticleToMyList() {
        this.waitForElementAndClick((PYTHON_NAME_ARTICLE_LIST),
                "Cannot find created list",
                5);
    }

    public void closeArticle() {
        this.waitForElementAndClick((CLOSE_ARTICLE_BUTTON),
                "Cannot close article, cannot close X link",
                15);
    }

    public void waitForShortGolangDescriptionAndClick() {
        this.waitForElementAndClick(
                GOLANG_ARTICLE_DESCRIPTION,
                "Cannot find 'Redirected from Golang' in Golang request search",
                5);
    }

    public void openGolangArticle() {
        String search_line = "Golang";
        assertElementPresent((GOLANG_ARTICLE_TITLE),
                "We've not found title article result by request " + search_line);
    }

    public void getArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick((MORE_OPTIONS_BUTTON),
                "Cannot find button to open article options",
                5);

        this.waitForElementAndClick((ADD_TO_LIST_BUTTON),
                "Cannot find option to add article to reading list",
                5);

        this.waitForElementAndClick((GOT_IT_BUTTON),
                "Cannot find 'Got it' button",
                5);

        this.waitForElementAndClear((INPUT_LIST_NAME_BUTTON),
                "Cannot find input to set name article folder",
                5);

        this.waitForElementAndSendKeys((INPUT_LIST_NAME_BUTTON),
                name_of_folder,
                "Cannot put text into articles folder input",
                5);

        this.waitForElementAndClick((OK_BUTTON),
                "Cannot press OK button",
                5);
    }

    public void addArticlesToMySaved() {
        this.waitForElementAndClick(ADD_TO_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                10);
    }

    public void pressCancelButtonIOS() {
        this.waitForElementAndClick(CANCEL_BUTTON,
                "Cannot find cancel button",
                10);
    }

    public void waitForPythonArticleInList() {
        this.waitForElementPresent(TITLE_PYTHON,
                "There is no 'Python (programming language)' article",
                15);
    }
}
