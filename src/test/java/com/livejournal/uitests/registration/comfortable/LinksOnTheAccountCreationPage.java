package com.livejournal.uitests.registration.comfortable;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class LinksOnTheAccountCreationPage extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user click TOS Link")
    public void user_click_TOS_Link() {
        on(CreateAccountPage.class).getCreateAccountForm().getTosRusLink().click();
    }

    @When("user click Privacy Link")
    public void user_click_Privacy_Link() {
        on(CreateAccountPage.class).getCreateAccountForm().getPrivacyRusLink().click();
    }

    @Then("user in correct page $page with URL $URL")
    public void user_in_TOS_Page(String page, String URL) {
        String ok_text = "You in " + page + "\n URL contains: " + URL;
        String error_text = "You not in " + page + "!\n Current URL: ";
        String correct_URL = "\nCorrect URL contains: " + URL;
        verify().expectedResult(ok_text, getCurrentUrl().contains(URL))
                .showMessageIfVerificationFailed(error_text + getCurrentUrl() + correct_URL).finish();
    }

}
