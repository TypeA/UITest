package com.livejournal.uitests.registration.comfortable.features_of_password;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.PopupsBlock;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class PasswordDescriptionTest extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter123 password $password")
    public void user_see_Password_Bubble_In_Registration_Page(String password) {
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordField().enter(password);

    }

    @Then("user see Password Bubble which contains text $text and URL $URL")
    public void password_Bubble_contains_text(String text, String URL) {
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordField().click();
        verify().expectedResult("Disply popup", on(PopupsBlock.class).isDisplayed())
                .showMessageIfVerificationFailed("Popup is not displyed!")
                .and().expectedResult("Text in Popup", on(PopupsBlock.class).getPopupText().getText().contains(text))
                .showMessageIfVerificationFailed("Incorrect text on Popup! Text on popup: " + on(PopupsBlock.class).getPopupText().getText()+" Correct text contains: " + text).finish();

        on(PopupsBlock.class).getLearnMoreLink().click();
        this.verify().expectedResult("URL", getCurrentBrowser().getDriver().getCurrentUrl().contains(URL))
                .showMessageIfVerificationFailed("Incorrect URL! CurrentUrl: "+  getCurrentBrowser().getDriver().getCurrentUrl() + " Correct URL contains: " + URL).finish();

    }
}
