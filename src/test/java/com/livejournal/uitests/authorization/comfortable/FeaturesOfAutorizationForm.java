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

    @Then("user in Lost Information Page")
    public void user_in_Lost_Information_Page() {
        verify().expectedResult("Lost Information Page", getCurrentBrowser().getDriver().getCurrentUrl().contains("/lostinfo.bml"))
                .showMessageIfVerificationFailed("You are not in Lost Information Page! Current URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + " Correct URL contains: /lostinfo.bml").finish();

    }
}
