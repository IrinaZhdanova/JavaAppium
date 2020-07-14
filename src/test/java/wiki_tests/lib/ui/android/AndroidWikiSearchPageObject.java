package wiki_tests.lib.ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.SearchWikiPageObject;

public class AndroidWikiSearchPageObject extends SearchWikiPageObject {

    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
        LIST_SEARCH_RESULT_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                "//*[@text='{SUBSTRING}']";
        SEARCH_RESULT_TITLE_AND_DESCRIPTION_TPL = "xpath://*[@class='android.widget.TextView']" +
                "//*[@text='{TITLE}']";
        LIST_SEARCH_RESULT = "id:org.wikipedia:id/page_list_item_container";
        SEARCH_LINE = "id:org.wikipedia:id/search_src_text";
        JAVA_SEARCH_LINE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text,'Java')]";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
    }

    public AndroidWikiSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
