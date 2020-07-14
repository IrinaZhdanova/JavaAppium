package wiki_tests.tests;

import org.junit.Test;
import wiki_tests.lib.CoreWikiTestCase;
import wiki_tests.lib.PlatformWiki;
import wiki_tests.lib.ui.*;
import wiki_tests.lib.ui.factories.ArticleWikiPageObjectFactory;
import wiki_tests.lib.ui.factories.MyWikiListsPageObjectFactory;
import wiki_tests.lib.ui.factories.NavigationUIWikiPageObjectFactory;
import wiki_tests.lib.ui.factories.SearchWikiPageObjectFactory;

public class MyListsWikiTest extends CoreWikiTestCase {

    private static final String name_of_folder = "Python articles";
    private static final String
            login = "AppiumJavaTest",
            password = "Qwerty666";
    @Test
    public void testSaveTwoArticlesAndClearOne() throws InterruptedException {

        SearchWikiPageObject SearchWikiPageObject = SearchWikiPageObjectFactory.get(driver);
        SearchWikiPageObject.initSearchInput();
        SearchWikiPageObject.typeSearchLine("Python");

        ArticleWikiPageObject ArticleWikiPageObject = ArticleWikiPageObjectFactory.get(driver);
        ArticleWikiPageObject.waitForShortPythonDescriptionAndClick();
        ArticleWikiPageObject.getArticleCard();

        if(PlatformWiki.getInstance().isAndroid()) {
            ArticleWikiPageObject.getArticleToMyList(name_of_folder);
        } else {
            ArticleWikiPageObject.addArticlesToMySaved();
        }

        if(PlatformWiki.getInstance().isMw()) {
            AuthorizationWikiPageObject Auth = new AuthorizationWikiPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticleWikiPageObject.waitForTitleElement();
            ArticleWikiPageObject.addArticlesToMySaved();
        }

        ArticleWikiPageObject.closeArticle();
        if(PlatformWiki.getInstance().isIOS()) {
            ArticleWikiPageObject.pressCancelButtonIOS();
        }

        NavigationUIWikiPageObject NavigationUIWikiPageObject = NavigationUIWikiPageObjectFactory.get(driver);
        if (PlatformWiki.getInstance().isMw()) {
            NavigationUIWikiPageObject.openSearchIcon();
        } else {
            SearchWikiPageObject.initSearchInput();
        }

        SearchWikiPageObject.typeSearchLine("Golang");

        ArticleWikiPageObject.waitForShortGolangDescriptionAndClick();

        if (PlatformWiki.getInstance().isAndroid() || PlatformWiki.getInstance().isIOS()) {
            ArticleWikiPageObject.waitForTitleGolangElement();
        } else {
            ArticleWikiPageObject.waitForTitleElement();
        }

        String article_title = ArticleWikiPageObject.getArticleTitle();
        if(PlatformWiki.getInstance().isAndroid()) {
            ArticleWikiPageObject.getArticleCard();
        }

        if(PlatformWiki.getInstance().isAndroid()) {
            ArticleWikiPageObject.getWikiArticleTwoSteps();
            ArticleWikiPageObject.getSecondWikiArticleToMyList();
        } else {
            ArticleWikiPageObject.addArticlesToMySaved();
        }

        ArticleWikiPageObject.closeArticle();
        if(PlatformWiki.getInstance().isIOS()) {
            ArticleWikiPageObject.pressCancelButtonIOS();
        }
        NavigationUIWikiPageObject.openNavigation();
        NavigationUIWikiPageObject.clickMyLists();

        MyWikiListsPageObject MyWikiListsPageObject = MyWikiListsPageObjectFactory.get(driver);
        if(PlatformWiki.getInstance().isIOS()){
            MyWikiListsPageObject.closeSyncSavedArticlesPopup();
        } else if(PlatformWiki.getInstance().isAndroid()){
            MyWikiListsPageObject.getCreatedList();
            MyWikiListsPageObject.openFolderByName(name_of_folder);
        }

        if (PlatformWiki.getInstance().isMw()) {
            driver.navigate().refresh();
        }

        MyWikiListsPageObject.swipeByArticleToDelete(article_title);
        ArticleWikiPageObject.waitForPythonArticleInList();
    }
}

