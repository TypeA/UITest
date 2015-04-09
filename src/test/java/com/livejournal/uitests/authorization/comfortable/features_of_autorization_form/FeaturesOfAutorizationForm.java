package com.livejournal.uitests.authorization.comfortable.features_of_autorization_form;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class FeaturesOfAutorizationForm extends WebTest {

    //Scenario: Forgot password(1/1)
    //Scenario: Remember me(1/1)
    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        open(LoginPageUnlogged.class);

    }

    //Scenario: Forgot password(2/3)
    @When("user click link Forgot Password")
    public void user_click_link_Forgot_Password() {
        onOpened(LoginPageUnlogged.class)
                .clickOnLostInfoLink();
    }

    //Scenario: Forgot password(3/3)
    @Then("user in correct page $page")
    public void user_in_correct_page(String page) {
        verify().thatIsOn((Class<? extends Page>) this.getPageClassByName(page))
                .finish();
    }
}
