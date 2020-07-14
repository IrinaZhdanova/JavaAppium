package wiki_tests.lib.ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import wiki_tests.lib.ui.NavigationUIWikiPageObject;

public class IOSWikiNavigationUIPageObject extends NavigationUIWikiPageObject {

    static {
        MY_LISTS_LINK = "id:Saved";
    }

    public IOSWikiNavigationUIPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
