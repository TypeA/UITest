package com.livejournal.uitests.authorization.secure.ip_blocking;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.utility.iterations.IterationsWithLoginForm;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class IpBlocking extends LJTest {
    
    //Scenario: IP blocking, when you spent login attempts(1/3)
    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        open(LoginPageUnlogged.class);

    }

    //Scenario: IP blocking, when you spent login attempts(2/3)
    @When("user 3 times enters incorrect data: name $name, incorrect_password $incorrect_password")
    public void user_3_times_enters_incorrect_data(String name, String incorrect_password) {
        new IterationsWithLoginForm(onOpened(LoginPageUnlogged.class), 3, name, incorrect_password).run();
    }

    //Scenario: IP blocking, when you spent login attempts(3/3)
    @Then("user see message $message and can not enter with correct data: name $name, correct_password $correct_password")
    public void user_see_message_and_can_not_enter_with_correct_data(String message, String name) {
        verify().that(onOpened(LoginPageUnlogged.class).getErrorText().getText().contains(message))
                .ifResultIsExpected("Correct text.\nText contains: " + message)
                .ifElse("Incorrect text!\nCurrent text: " + onOpened(LoginPageUnlogged.class).getErrorText().getText())
                .finish();
        onOpened(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name), false);
        verify().that(getCurrentUrl().contains("/login.bml"))
                .ifResultIsExpected("IP is blocked")
                .ifElse("IP is not blocked!")
                .finish();
               
    }

}
