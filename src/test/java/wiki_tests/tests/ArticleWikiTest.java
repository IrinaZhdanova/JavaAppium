package wiki_tests.tests;

import org.junit.Test;
import wiki_tests.lib.CoreWikiTestCase;
import wiki_tests.lib.ui.ArticleWikiPageObject;
import wiki_tests.lib.ui.SearchWikiPageObject;
import wiki_tests.lib.ui.factories.ArticleWikiPageObjectFactory;
import wiki_tests.lib.ui.factories.SearchWikiPageObjectFactory;

public class ArticleWikiTest extends CoreWikiTestCase {
    @Test
    public void testFindGolangArticleAndCheckTitle() throws InterruptedException {

        SearchWikiPageObject SearchWikiPageObject = SearchWikiPageObjectFactory.get(driver);
        SearchWikiPageObject.initSearchInput();
        SearchWikiPageObject.typeSearchLine("Golang");

        ArticleWikiPageObject ArticleWikiPageObject = ArticleWikiPageObjectFactory.get(driver);
        ArticleWikiPageObject.waitForShortGolangDescriptionAndClick();
        ArticleWikiPageObject.openGolangArticle();
    }
}
