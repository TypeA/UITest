package com.livejournal.uitests.registration.comfortable;

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
public class FeaturesOfPassword extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        getCurrentBrowser().clearCache();
        on(CreateAccountPage.class);
    }

    @When("user enter password $password")
    public void user_enter_password(String password) {
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordField().enter(password);
    }

    @When("user clicks Mapping Button")
    public void user_clicks_Mapping_Button() {
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordMappingLinkHide().click();
    }

    @Then("the password is hidden")
    public void the_password_is_hidden() {
        verify().expectedResult("Correct icon display password", on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordMappingLinkHide().isDisplayed())
                .showMessageIfVerificationFailed("Incorrect icon display password!").and()
                .expectedResult("Correct icon display password", !on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordMappingLinkShow().isDisplayed())
                .showMessageIfVerificationFailed("Incorrect icon display password!").finish();
    }

    @Then("the password is displayed")
    public void the_password_is_displayed() {
        verify().expectedResult("Correct icon display password", !on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordMappingLinkHide().isDisplayed())
                .showMessageIfVerificationFailed("Incorrect icon display password!").and()
                .expectedResult("Correct icon display password", on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordMappingLinkShow().isDisplayed())
                .showMessageIfVerificationFailed("Incorrect icon display password!").finish();

    }

    @Then("user see Password Bubble which contains text $text and URL $URL")
    public void password_Bubble_contains_text(String text, String URL) {
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordField().click();
        verify().expectedResult("Popup is displyed", on(PopupsBlock.class).isDisplayed())
                .showMessageIfVerificationFailed("Popup is not displyed!")
                .and().expectedResult("Correct text in Popup.\nText contains: " + text, on(PopupsBlock.class).getPopupText().getText().contains(text))
                .showMessageIfVerificationFailed("Incorrect text on Popup!\nText on popup: " + on(PopupsBlock.class).getPopupText().getText() + "\nCorrect text contains: " + text).finish();

        on(PopupsBlock.class).getLearnMoreLink().click();
        this.verify().expectedResult("Correct URL contains: " + URL, getCurrentBrowser().getDriver().getCurrentUrl().contains(URL))
                .showMessageIfVerificationFailed("Incorrect URL!\nCurrentUrl: " + getCurrentBrowser().getDriver().getCurrentUrl() + "\nCorrect URL contains: " + URL).finish();

    }
}
