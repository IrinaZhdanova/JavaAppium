package lesson_project.lib.ui;

import lesson_project.lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
            FOLDER_BY_MANE_TPL,
            ARTICLE_BY_TITLE_TPL,
            SYNC_SAVED_ARTICLES_POPUP,
            CLOSE_BUTTON,
            REMOVE_FROM_SAVED_BUTTON;

    private static String getFolderXpathByName(String name_of_folder) {
        return FOLDER_BY_MANE_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSaveArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    private static String getRemoveButtonByTitle(String article_title) {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
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
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.waitForElementNotPresent((article_xpath),
                "Saved article still present with title " + article_title,
                15);
    }

    public void swipeByArticleToDelete(String article_title) {
        if (Platform.getInstance().isAndroid()) {
            this.waitForArticleToAppearByTitle(article_title);
        }

        String article_xpath = getSaveArticleXpathByTitle(article_title);

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.swipeElementToLeft((article_xpath),
                    "Cannot find saved article");
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(remove_locator,
                    "Cannot click button to remove article from saved",
                    10);
        }


        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(
                    article_xpath,
                    "Cannot find saved article - 2");
        }
        this.waitForArticleToDisappearByTitle(article_title);
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




