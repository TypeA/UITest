package com.livejournal.uitests.registration.useful.register_an_account_with_the_correct_data;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageForUnsignedInUser;
import com.livejournal.uitests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class GoToRegistrationFormTest extends WebTest {

    @Steps
    Verificate verify;

    @When("user on Main Page clicks on Login Menu and clicks Create New Account")
    public void user_on_Main_Page_clicks_on_Login_Menu() {
        on(MainPageForUnsignedInUser.class)
                .getFullscreenHeaderUnlogged()
                .getLoginMenuItem().click();
        on(LoginForm.class).getCreateAccountLink().click();
    }

    @Then("user should be on Registration Form")
    public void user_should_be_on_Registration_Form() {
        verify.verifyText("We are not on Create Account Page", on(CreateAccountPage.class).getUrl().toString(), "/create");
    }

}
