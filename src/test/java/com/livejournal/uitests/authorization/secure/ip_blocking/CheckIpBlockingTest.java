package com.livejournal.uitests.authorization.secure.ip_blocking;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class CheckIpBlockingTest extends WebTest {

    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        on(LoginPage.class);

    }

    @When("user 4 times enters incorrect data: name $name, incorrect_password $incorrect_password")
    public void user_4_times_enters_incorrect_data(String name, String incorrect_password) {
        for (int i = 0; i < 4; i++) {
            on(LoginPage.class).getLoginForm().authorizeBy(name, incorrect_password);
        }

    }

    @Then("user see message $message and can't enter with correct data: name $name, correct_password $correct_password")
    public void ip_is_blocked(String message, String name, String correct_password) {
        
        verify().expectedResult("Error text on Autorization Page", on(LoginPage.class).getErrorText().getText().contains(message))
                .showMessageIfVerificationFailed("Incorrect error text on Page! Current text: " + on(LoginPage.class).getErrorText().getText() + " Correct text contains:" + message).finish();
        on(LoginPage.class).getLoginForm().authorizeBy(name, correct_password);
                verify().expectedResult("Blocking IP", getCurrentBrowser().getDriver().getCurrentUrl().contains("/login.bml"))
                .showMessageIfVerificationFailed("IP is not blocked!").finish();
    }

}
