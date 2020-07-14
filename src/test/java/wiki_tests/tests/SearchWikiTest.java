package wiki_tests.tests;

import org.junit.Test;
import wiki_tests.lib.CoreWikiTestCase;
import wiki_tests.lib.PlatformWiki;
import wiki_tests.lib.ui.ArticleWikiPageObject;
import wiki_tests.lib.ui.SearchWikiPageObject;
import wiki_tests.lib.ui.factories.ArticleWikiPageObjectFactory;
import wiki_tests.lib.ui.factories.SearchWikiPageObjectFactory;


public class SearchWikiTest extends CoreWikiTestCase {

    @Test
    public void testFindSearchString() {

        SearchWikiPageObject SearchWikiPageObject = SearchWikiPageObjectFactory.get(driver);
        SearchWikiPageObject.initSearchInput();

        ArticleWikiPageObject ArticleWikiPageObject = ArticleWikiPageObjectFactory.get(driver);
        String string_title = ArticleWikiPageObject.waitForSearchTitleElement();

        if(PlatformWiki.getInstance().isAndroid()){
            assertEquals("Cannot find 'Search...' string in wiki app",
                    "Search…",
                    string_title);
        } else{
            assertEquals("Cannot find 'Search...' string in wiki app",
                    "Search Wikipedia", string_title);
        }
    }

    @Test
    public void testPerformSearchAndRemoveSymbolsAfterSearch() {

        SearchWikiPageObject SearchWikiPageObject = SearchWikiPageObjectFactory.get(driver);
        SearchWikiPageObject.initSearchInput();
        SearchWikiPageObject.typeSearchLine("Python");
        SearchWikiPageObject.getSearchResultList();
        SearchWikiPageObject.getSearchAndClearSearchLine();
        SearchWikiPageObject.waitToDisappearRequestInSearch();
    }

    @Test
    public void testCheckJavaSearchResults() {

        SearchWikiPageObject SearchWikiPageObject = SearchWikiPageObjectFactory.get(driver);
        SearchWikiPageObject.initSearchInput();
        SearchWikiPageObject.typeSearchLine("Java");
        SearchWikiPageObject.waitForSearchResult("Java");
        int amount_of_search_results = SearchWikiPageObject.getAmountOfFoundArticles();
        assertNotNull("Cannot find 'Java' in search results", amount_of_search_results);
    }

    @Test
    public void testCheckJavaSearchResultsTest() {

        SearchWikiPageObject SearchWikiPageObject = SearchWikiPageObjectFactory.get(driver);
        SearchWikiPageObject.initSearchInput();
        SearchWikiPageObject.typeSearchLine("Java");
        SearchWikiPageObject.waitForElementByTitleAndDescription("Javhffhva", "language");
        int amount_of_search_results = SearchWikiPageObject.getAmountOfFoundArticles();
        assertNotNull("Cannot find 'Java' in search results", amount_of_search_results);
    }
}
