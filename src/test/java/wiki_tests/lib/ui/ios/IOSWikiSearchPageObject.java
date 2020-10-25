package wiki_tests.lib.ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.SearchWikiPageObject;

public class IOSWikiSearchPageObject extends SearchWikiPageObject {

    static {
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "id:Search Wikipedia";
        SEARCH_LINE = "xpath://XCUIElementTypeSearchField";
        LIST_SEARCH_RESULT_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        LIST_SEARCH_RESULT = "xpath://XCUIElementTypeCollectionView";
        JAVA_SEARCH_LINE = "xpath://XCUIElementTypeStaticText[contains(@name, Java)]";
        SEARCH_RESULT_ELEMENT = "xpath:/XCUIElementTypeCollectionView";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name=No results found]";
        SEARCH_RESULT_TITLE_AND_DESCRIPTION_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'Java')][contains(@name,'language')]";
    }

    public IOSWikiSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
