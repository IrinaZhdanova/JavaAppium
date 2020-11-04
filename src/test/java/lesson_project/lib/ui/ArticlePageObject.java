package lesson_project.lib.ui;

import org.openqa.selenium.WebElement;
import lesson_project.lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            CANCEL_BUTTON;


    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE,
                "Cannot find article title on page",
                15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        } else if (Platform.getInstance().isIOS()) {
            this.swipeTillElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of article - 2",
                    40);
        } else {
            this.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        }
    }

    public void getArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5);

        this.waitForElementAndClick((OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find option to add article to reading list",
                5);

        this.waitForElementAndClick((ADD_TO_MY_LIST_OVERLAY),
                "Cannot find 'Got it' button",
                5);

        this.waitForElementAndClear((MY_LIST_NAME_INPUT),
                "Cannot find input to set name f article folder",
                5);

        this.waitForElementAndSendKeys((MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into articles folder input",
                5);

        this.waitForElementAndClick((MY_LIST_OK_BUTTON),
                "Cannot press OK button",
                5);
    }

    public void closeArticle() {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot close X link",
                    5);
        } else {
            System.out.println("Method closeArticle() does nothing for platform "
                    + Platform.getInstance().getPlatformVar());
        }
    }

    public void addArticlesToMySaved() {
        if (Platform.getInstance().isMw()) {
            this.removeArticleFromSavedIfItAdded();
        }

        this.waitForElementClickable(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5);

        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5);
    }

    public void removeArticleFromSavedIfItAdded() {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove an article from saved",
                    1);
            this.waitForElementPresent(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing");
        }
    }

    public void pressCancelButtonIOS() {
        this.waitForElementAndClick(CANCEL_BUTTON,
                "Cannot find cancel button",
                10);
    }
}


