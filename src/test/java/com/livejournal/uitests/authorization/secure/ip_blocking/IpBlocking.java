package com.livejournal.uitests.authorization.secure.ip_blocking;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.utility.VerifyText;
import com.livejournal.uitests.utility.iterations.IterationsWithLoginForm;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class IpBlocking extends WebTest {
    
    //Scenario: Check IP blocking(1/3)
    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        on(LoginPageUnlogged.class);

    }

    //Scenario: Check IP blocking(2/3)
    @When("user 3 times enters incorrect data: name $name, incorrect_password $incorrect_password")
    public void user_3_times_enters_incorrect_data(String name, String incorrect_password) {
        new IterationsWithLoginForm(on(LoginPageUnlogged.class), 3, name, incorrect_password).run();
    }

    //Scenario: Check IP blocking(3/3)
    @Then("user see message $message and can not enter with correct data: name $name, correct_password $correct_password")
    public void user_see_message_and_can_not_enter_with_correct_data(String message, String name, String correct_password) {
        verify().that(on(LoginPageUnlogged.class).getErrorText().getText().contains(message))
                .ifResultIsExpected(VerifyText.okTextForMessage(message))
                .ifElse(VerifyText.errorTextForMessage(on(LoginPageUnlogged.class).getErrorText().getText()))
                .finish();
        on(LoginPageUnlogged.class)
                .authorizeBy(name, correct_password);
        verify().that(getCurrentUrl().contains("/login.bml"))
                .ifResultIsExpected("IP is blocked")
                .ifElse("IP is not blocked!")
                .finish();
               
    }

}
