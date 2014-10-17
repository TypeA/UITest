package com.livejournal.uitests.registration.comfortable.features_of_password;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.MappingLink;
import com.livejournal.uitests.pages.service_pages.create_account_pages.PopupsBlock;
import com.livejournal.uitests.utility.VerifyText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class FeaturesOfPassword extends WebTest {

    //Scenario: Displays password(1/5)
    //Scenario: Password description(1/3)
    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        open(CreateAccountPage.class);
    }

    //Scenario: Displays password(2/5)
    //Scenario: Password description(2/3)
    @When("user enter password $password")
    public void user_enter_password(String password) {
        open(CreateAccountPage.class)
                .enterPassword(password);
    }

    //Scenario: Displays password(4/5)
    @When("user clicks Mapping Button")
    public void user_clicks_Mapping_Button() {
        onOpened(CreateAccountPage.class)
                .clickOnPasswordMappingLink(MappingLink.HIDE);
    }

    //Scenario: Displays password(3/5)
    @Then("the password is hidden")
    public void the_password_is_hidden() {
        verify().that(onOpened(CreateAccountPage.class).displayedPasswordMappingLink(MappingLink.HIDE))
                .ifResultIsExpected("Correct icon is displayed: hide icon")
                .ifElse("Hide icon is hidden!")
                .and()
                .that(!onOpened(CreateAccountPage.class).displayedPasswordMappingLink(MappingLink.SHOW))
                .ifResultIsExpected("Correct icon is hidden: show icon")
                .ifElse("Show icon is displayed!")
                .finish();
    }

    //Scenario: Displays password(5/5)
    @Then("the password is displayed")
    public void the_password_is_displayed() {
        verify().that(!onOpened(CreateAccountPage.class).displayedPasswordMappingLink(MappingLink.HIDE))
                .ifResultIsExpected("Correct icon is hidden: hide icon")
                .ifElse("Hide icon is displayed!")
                .and()
                .that(onOpened(CreateAccountPage.class).displayedPasswordMappingLink(MappingLink.SHOW))
                .ifResultIsExpected("Correct icon is displayed: show icon")
                .ifElse("Show icon is hidden!")
                .finish();

    }

    //Scenario: Password description(3/3)
    @Then("user see Password Bubble which contains text $text and URL $URL (page $page)")
    public void user_see_Password_Bubble_which_contains_text_and_URL(String text, String URL, String page) {
        onOpened(CreateAccountPage.class).clickOnPasswordField();
        verify().that(onDisplayed(PopupsBlock.class).isDisplayed())
                .ifResultIsExpected("Popup is displyed")
                .ifElse("Popup is not displyed!")
                .and()
                .that(onDisplayed(PopupsBlock.class).getPopupText().contains(text))
                .ifResultIsExpected(VerifyText.okTextForMessage(text))
                .ifElse(VerifyText.errorTextForMessage(onDisplayed(PopupsBlock.class).getPopupText()))
                .finish();

        onDisplayed(PopupsBlock.class).clickOnLearnMoreLink();
        verify().that(getCurrentUrl().contains(URL))
                .ifResultIsExpected(VerifyText.okTextForURL(page, URL))
                .ifElse(VerifyText.errorTextForURL(page, URL, getCurrentUrl()))
                .finish();

    }
}
