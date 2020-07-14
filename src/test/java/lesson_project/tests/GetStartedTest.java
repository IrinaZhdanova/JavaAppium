package lesson_project.tests;

import lesson_project.lib.CoreTestCase;
import lesson_project.lib.Platform;
import lesson_project.lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassTroughWelcome() {

        if((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMw())){
            return;
        }
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWayToExploreText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddAndOrEditPreferredLangText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnAboutDataCollectedText();
        WelcomePage.clickGetStartedButton();
    }
}
