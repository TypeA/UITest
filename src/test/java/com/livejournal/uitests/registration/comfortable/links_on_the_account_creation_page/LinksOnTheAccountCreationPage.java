package com.livejournal.uitests.registration.comfortable.links_on_the_account_creation_page;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.utility.VerifyText;
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
    public void user_in_correct_Page_with_URL(String page, String URL) {
        verify().expectedResult(VerifyText.okTextForURL(page, URL), getCurrentUrl().contains(URL))
                .showMessageIfVerificationFailed(VerifyText.errorTextForURL(page, URL, getCurrentUrl())).finish();
     }

}
