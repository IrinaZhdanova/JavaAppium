package wiki_tests.lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import wiki_tests.lib.ui.SearchWikiPageObject;

public class IOSWikiSearchPageObject extends SearchWikiPageObject {

    static {
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "id:Search Wikipedia";
        SEARCH_LINE = "xpath://XCUIElementTypeSearchField";
        LIST_SEARCH_RESULT_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        LIST_SEARCH_RESULT = "xpath://XCUIElementTypeCollectionView";
        JAVA_SEARCH_LINE = "xpath://XCUIElementTypeStaticText[contains(@name, Java)]";
    }

    public IOSWikiSearchPageObject(AppiumDriver driver){

        super(driver);
    }
}
