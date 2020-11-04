package wiki_tests.lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationWikiPageObject extends MainWikiPageObject {
    private static final String
            LOGIN_BUTTON = "xpath://body/div//a[text()='Log in']",
            LOGIN_INPUT = "css:.mw-input #wpName1",
            PASSWORD_BUTTON = "css:input[name=wpPassword]",
            SUBMIT_BUTTON = "css:button[name=wploginattempt]";

    public AuthorizationWikiPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton() {
        this.waitForElementClickable(LOGIN_BUTTON,
                "Cannot find auth button",
                15);
        this.waitForElementAndClick(LOGIN_BUTTON,
                "Cannot find and click auth button",
                5);
    }

    public void enterLoginData(String login, String password) throws InterruptedException {
//        Thread.sleep(1000);
        this.waitForElementAndSendKeys(LOGIN_INPUT, login,
                "Cannot find and enter a login to the login input",
                5);
        this.waitForElementAndSendKeys(PASSWORD_BUTTON, password,
                "Cannot find and enter a password to the password input",
                5);
    }

    public void submitForm() {
        this.waitForElementAndClick(SUBMIT_BUTTON,
                "Cannot find and click submit auth button",
                5);
    }
}
