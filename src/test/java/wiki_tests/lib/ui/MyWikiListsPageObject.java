package wiki_tests.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.PlatformWiki;

public class MyWikiListsPageObject extends MainWikiPageObject {
    protected static String
            ARTICLE_BY_TITLE_TPL,
            MY_LIST,
            FOLDER_BY_MANE_TPL,
            PYTHON_ARTICLE_IN_FOLDER,
            PYTHON_TITLE_ARTICLE_CARD,
            SYNC_SAVED_ARTICLES_POPUP,
            CLOSE_BUTTON,
            REMOVE_FROM_SAVED_BUTTON;


    public MyWikiListsPageObject(RemoteWebDriver driver) {

        super(driver);
    }

    public void getCreatedList() {
        this.waitForElementAndClick(MY_LIST,
                "Cannot find new list",
                5);
    }

    private static String getFolderXpathByName(String name_of_folder) {
        return FOLDER_BY_MANE_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }


    public void openFolderByName(String name_of_folder) {
        String folder_name_by_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick((folder_name_by_xpath),
                "Cannot find folder by name" + name_of_folder,
                10);
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent((article_xpath),
                "Cannot find saved article by title " + article_title,
                15);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementNotPresent((article_xpath),
                "Saved article still present with title " + article_title,
                15);
    }


    private String getSaveArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }


    public void clickOnPythonArticleInFolder() {
        this.waitForElementAndClick(PYTHON_ARTICLE_IN_FOLDER,
                "Cannot find 'Python' article in folder",
                10);
    }

    private static String getRemoveButtonByTitle(String article_title) {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    public void swipeByArticleToDelete(String article_title) {
        if (PlatformWiki.getInstance().isAndroid()) {
            this.waitForArticleToAppearByTitle(article_title);
        }

        String article_xpath = this.getSaveArticleXpathByTitle(article_title);

        if (PlatformWiki.getInstance().isIOS() || PlatformWiki.getInstance().isAndroid()) {
            this.swipeElementToLeft((article_xpath),
                    "Cannot find saved article");
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(remove_locator,
                    "Cannot click button to remove article from saved",
                    10);
        }
    }

    public void closeSyncSavedArticlesPopup() {
        this.waitForElementPresent(SYNC_SAVED_ARTICLES_POPUP,
                "Cannot find 'Sync your saved articles?'",
                10);
        this.waitForElementAndClick(CLOSE_BUTTON,
                "Cannot find 'X' symbol on popup",
                10);
    }
}
