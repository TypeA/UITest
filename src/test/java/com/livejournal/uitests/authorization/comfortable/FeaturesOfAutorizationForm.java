package com.livejournal.uitests.authorization.comfortable;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
import com.livejournal.uitests.utility.VerifyText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class FeaturesOfAutorizationForm extends WebTest {

    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        on(LoginPage.class);

    }

    @When("user click link Forgot Password")
    public void user_click_link_Forgot_Password() {
        on(LoginPage.class).getLoginForm().getLostInfo().click();
    }

    @Then("user in correct page <page> with URL <URL>")
    public void user_in_correct_Page(String page, String URL) {
        verify().expectedResult(VerifyText.okTextForURL(page, URL), getCurrentUrl().contains(URL))
                .showMessageIfVerificationFailed(VerifyText.errorTextForURL(page, URL, getCurrentUrl())).finish();
    }
}
