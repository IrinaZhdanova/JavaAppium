package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import wiki_tests.tests.ArticleWikiTest;
import wiki_tests.tests.MyListsWikiTest;
import wiki_tests.tests.SearchWikiTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ArticleWikiTest.class,
        MyListsWikiTest.class,
        SearchWikiTest.class
})

public class TestWikiSuite { }
