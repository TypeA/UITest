package com.livejournal.uitests.authorization.useful.log_in_with_incorrect_data;

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
public class LogInWithIncorrectData extends WebTest {

    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        on(LoginPage.class);

    }

    @When("user enter incorrect data: name $name, password $password and clicks LogIn")
    public void user_enter_incorrect_data_and_clicks_LogIn(String name, String password) {
        on(LoginPage.class).getLoginForm().authorizeBy(name, password);
    }

    @Then("user is not logged and see message $message")
    public void user_is_not_logged_and_see_message(String message) {
        verify().that(on(LoginPage.class).getErrorText().getText().contains(message))
                .ifResultIsExpected(VerifyText.okTextForMessage(message))
                .ifElse(VerifyText.errorTextForMessage(message, on(LoginPage.class).getErrorText().getText()))
                .finish();

    }
}
