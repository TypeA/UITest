package com.livejournal.uitests.authorization.useful.log_in_with_incorrect_data;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class LogInWithIncorrectData extends WebTest {

    //Scenario: Unsuccessfully autorization(1/3)
    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        open(MainPageUnlogged.class);
        addCookie("langpref", "en_LJ");
    }

    //Scenario: Unsuccessfully autorization(2/3)
    @When("user enter incorrect data: name $name and clicks LogIn")
    public void user_enter_incorrect_data_and_clicks_LogIn(String name, String password){
        open(LoginPageUnlogged.class)
                .authorizeBy(name, password);
    }

    //Scenario: Unsuccessfully autorization(3/3)
    @Then("user is not logged and see message $message")
    public void user_is_not_logged_and_see_message(String message) {
        verify().that(onOpened(LoginPageUnlogged.class).getErrorText().getText().contains(message))
                .ifResultIsExpected("Correct text.\nText contains: " + message)
                .ifElse("Incorrect text!\nCurrent text: " + onOpened(LoginPageUnlogged.class).getErrorText().getText())
                .finish();

    }
}
