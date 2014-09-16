package com.livejournal.uitests.authorization.useful.log_in_with_correct_data;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeaderLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class LogInWithCorrectData extends WebTest {

    //Scenario: Successfully autorization(1/3)
    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        on(LoginPageUnlogged.class);

    }

    //Scenario: Successfully autorization(2/3)
    @When("user enter correct data: name $name, password $password and clicks LogIn")
    public void user_enter_correct_data_and_clicks_LogIn(String name, String password) {
        on(LoginPageUnlogged.class)
                .authorizeBy(name, password);
    }

    //Scenario: Successfully autorization(3/3)
    @Then("user logged in")
    public void user_logged_in() {
        on(FullscreenHeaderLogged.class)
                .clickOnLogo();
        verify().that(on(FullscreenHeaderLogged.class).isDisplayed())
                .ifResultIsExpected("User is logged")
                .ifElse("The user is not logged!")
                .finish();
    }

}
