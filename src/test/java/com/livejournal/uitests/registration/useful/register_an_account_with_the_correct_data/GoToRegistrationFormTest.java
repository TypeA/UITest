package com.livejournal.uitests.registration.useful.register_an_account_with_the_correct_data;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageForUnsignedInUser;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class GoToRegistrationFormTest extends WebTest {

    @When("user on Main Page clicks on Login Menu and clicks Create New Account")
    public void user_on_Main_Page_clicks_on_Login_Menu() {
        on(MainPageForUnsignedInUser.class)
                .getFullscreenHeaderUnlogged()
                .getLoginMenuItem().click();
        on(LoginForm.class).getCreateAccountLink().click();
    }

    @Then("user should be on Registration Form")
    public void user_should_be_on_Registration_Form() {
        verify().expectedResult("Create Account link", getCurrentBrowser().getDriver().getCurrentUrl().contains("/create"))
                .showMessageIfVerificationFailed("You are not in Create Account Page! Current URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + " Correct URL contains: /create").finish();
    }

}
