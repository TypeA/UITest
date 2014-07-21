package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class DisplaysPassword extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter password $password")
    public void user_enter_password(String password) {
        on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordField.enter(password);
    }

    @Then("the password is hidden")
    public void the_password_is_hidden() {
        verify.verifyStatus("Incorrect icon display password!", on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkHide.isDisplayed());
        verify.verifyStatus("Incorrect icon display password!", !on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkShow.isDisplayed());
    }

    @When("user clicks Mapping Button")
    public void user_clicks_Mapping_Button() {
        on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkHide.click();
    }

    @Then("the password is displayed")
    public void the_password_is_displayed() {
        verify.verifyStatus("Incorrect icon display password!", !on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkHide.isDisplayed());
        verify.verifyStatus("Incorrect icon display password!", on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkShow.isDisplayed());
    }
}
