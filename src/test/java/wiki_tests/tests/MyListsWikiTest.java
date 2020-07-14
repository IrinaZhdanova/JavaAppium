package wiki_tests.tests;

import org.junit.Test;
import wiki_tests.lib.CoreWikiTestCase;
import wiki_tests.lib.PlatformWiki;
import wiki_tests.lib.ui.ArticleWikiPageObject;
import wiki_tests.lib.ui.MyWikiListsPageObject;
import wiki_tests.lib.ui.NavigationUIWikiPageObject;
import wiki_tests.lib.ui.SearchWikiPageObject;
import wiki_tests.lib.ui.factories.ArticleWikiPageObjectFactory;
import wiki_tests.lib.ui.factories.MyWikiListsPageObjectFactory;
import wiki_tests.lib.ui.factories.NavigationUIWikiPageObjectFactory;
import wiki_tests.lib.ui.factories.SearchWikiPageObjectFactory;

public class MyListsWikiTest extends CoreWikiTestCase {
    @Test
    public void testSaveTwoArticlesAndClearOne() {

        SearchWikiPageObject SearchWikiPageObject = SearchWikiPageObjectFactory.get(driver);
        SearchWikiPageObject.initSearchInput();
        SearchWikiPageObject.typeSearchLine("Python");

        ArticleWikiPageObject ArticleWikiPageObject = ArticleWikiPageObjectFactory.get(driver);
        ArticleWikiPageObject.waitForShortPythonDescriptionAndClick();
        ArticleWikiPageObject.getArticleCard();

        String name_of_folder = "Python articles";
        if(PlatformWiki.getInstance().isAndroid()) {
            ArticleWikiPageObject.getArticleToMyList(name_of_folder);
        } else {
            ArticleWikiPageObject.addArticlesToMySaved();
        }

        ArticleWikiPageObject.closeArticle();
        if(PlatformWiki.getInstance().isIOS()) {
            ArticleWikiPageObject.pressCancelButtonIOS();
        }

        SearchWikiPageObject.initSearchInput();
        SearchWikiPageObject.typeSearchLine("Golang");

        ArticleWikiPageObject.waitForShortGolangDescriptionAndClick();
        ArticleWikiPageObject.waitForTitleElement();
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
        NavigationUIWikiPageObject NavigationUIWikiPageObject = NavigationUIWikiPageObjectFactory.get(driver);
        NavigationUIWikiPageObject.clickMyLists();

        MyWikiListsPageObject MyWikiListsPageObject = MyWikiListsPageObjectFactory.get(driver);
        if(PlatformWiki.getInstance().isIOS()){
            MyWikiListsPageObject.closeSyncSavedArticlesPopup();
        } else if(PlatformWiki.getInstance().isAndroid()){
            MyWikiListsPageObject.getCreatedList();
            MyWikiListsPageObject.openFolderByName(name_of_folder);
        }

        MyWikiListsPageObject.swipeByArticleToDelete(article_title);
        ArticleWikiPageObject.waitForPythonArticleInList();
    }
}

