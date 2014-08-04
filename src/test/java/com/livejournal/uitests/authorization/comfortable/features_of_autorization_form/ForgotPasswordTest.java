package com.livejournal.uitests.authorization.comfortable.features_of_autorization_form;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
import com.livejournal.uitests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class ForgotPasswordTest extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        on(LoginPage.class);

    }

    @When("user click link Forgot Password")
    public void user_click_link_Forgot_Password() {
        on(LoginPage.class).getLoginForm().getLostInfo().click();
    }
    
    @Then ("user in Lost Information Page")
    public void user_in_Lost_Information_Page(){
        verify.verifyText("You are not in Lost Information Page", getCurrentBrowser().getDriver().getCurrentUrl(), "/lostinfo.bml");
    }
}
