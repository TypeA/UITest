package com.livejournal.uitests.authorization.comfortable;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
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
    public void user_in_Lost_Information_Page(String page, String URL) {
        String ok_text = "You in " + page + "\n URL contains: " + URL;
        String error_text = "You not in " + page + "!\n Current URL: ";
        String correct_URL = "\nCorrect URL contains: " + URL;
        verify().expectedResult(ok_text, getCurrentUrl().contains(URL))
                .showMessageIfVerificationFailed(error_text + getCurrentUrl() + correct_URL).finish();
    }
}
