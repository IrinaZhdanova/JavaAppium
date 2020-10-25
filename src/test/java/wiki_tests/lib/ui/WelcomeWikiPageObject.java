package wiki_tests.lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomeWikiPageObject extends MainWikiPageObject {

    private static final String
            STEP_LEARN_MORE_LINK = "name:Learn more about Wikipedia",
            STEP_NEW_WAYS_TO_EXPLORE = "name:New ways to explore",
            STEP_ADD_OR_EDIT_PREF_LANGUAGES_LINK = "name:Add or edit preferred languages",
            STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "id:Learn more about data collected",
            NEXT_BUTTON = "name:Next",
            GET_STARTED = "name:Get started",
            SKIP_BUTTON = "id:Skip";

    public WelcomeWikiPageObject(AppiumDriver driver) {

        super(driver);
    }

    public void waitForLearnMoreLink() {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK,
                "Cannot find 'Learn more about Wikipedia' link",
                10);
    }

    public void waitForNewWayToExploreText() {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE,
                "Cannot find 'New ways to explore' link",
                10);
    }

    public void waitForAddAndOrEditPreferredLangText() {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREF_LANGUAGES_LINK,
                "Cannot find 'Add or edit preferred languages' link",
                10);
    }

    public void waitForLearnAboutDataCollectedText() {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK,
                "Cannot find 'Learn more about data collected' link",
                10);
    }


    public void clickNextButton() {
        this.waitForElementAndClick(NEXT_BUTTON,
                "Cannot find and click 'Next' button",
                10);
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(GET_STARTED,
                "Cannot find and click 'Get started' button",
                10);
    }

    public void clickSkip() {
        this.waitForElementAndClick(SKIP_BUTTON,
                "Cannot find and click skip button",
                5);
    }
}
