package com.livejournal.uitests.authorization.useful.log_in_with_correct_data;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeaderLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class LogInWithCorrectData extends LJTest {

    //Scenario: Successfully autorization(1/3)
    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        open(LoginPageUnlogged.class);
    }

    //Scenario: Successfully autorization(2/3)
    @When("user enter correct data: name $name and clicks LogIn")
    public void user_enter_correct_data_and_clicks_LogIn(String name) {
        onOpened(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
    }

    //Scenario: Successfully autorization(3/3)
    @Then("user logged in")
    public void user_logged_in() {
        onDisplayed(FullscreenHeaderLogged.class)
                .clickOnLogo();
        verify().that(onDisplayed(FullscreenHeaderLogged.class).isDisplayed())
                .ifResultIsExpected("User is logged")
                .ifElse("The user is not logged!")
                .finish();
    }

}
