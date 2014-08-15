package com.livejournal.uitests.authorization.secure.ip_blocking;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
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
    
    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        on(LoginPage.class);

    }

    @When("user 3 times enters incorrect data: name $name, incorrect_password $incorrect_password")
    public void user_3_times_enters_incorrect_data(String name, String incorrect_password) {
        new IterationsWithLoginForm(on(LoginPage.class), 3, name, incorrect_password).run();
    }

    @Then("user see message $message and can't enter with correct data: name $name, correct_password $correct_password")
    public void ip_is_blocked(String message, String name, String correct_password) {

        verify().expectedResult(VerifyText.okTextForMessage(message), on(LoginPage.class).getErrorText().getText().contains(message))
                .showMessageIfVerificationFailed(VerifyText.errorTextForMessage(message, on(LoginPage.class).getErrorText().getText())).finish();
        on(LoginPage.class).getLoginForm().authorizeBy(name, correct_password);
        verify().expectedResult("IP is blocked", getCurrentUrl().contains("/login.bml"))
                .showMessageIfVerificationFailed("IP is not blocked!").finish();
               
    }

}
