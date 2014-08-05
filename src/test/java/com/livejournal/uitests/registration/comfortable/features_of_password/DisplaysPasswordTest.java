package com.livejournal.uitests.registration.comfortable.features_of_password;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class DisplaysPasswordTest extends WebTest {
    
    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter password $password")
    public void user_enter_password(String password) {
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordField().enter(password);
    }

    @Then("the password is hidden")
    public void the_password_is_hidden() {      
        verify().expectedResult("Display password", on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordMappingLinkHide().isDisplayed())
                .showMessageIfVerificationFailed("Incorrect icon display password!").and()
                .expectedResult("Display password", !on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordMappingLinkShow().isDisplayed())
                .showMessageIfVerificationFailed("Incorrect icon display password!").finish();
    }

    @When("user clicks Mapping Button")
    public void user_clicks_Mapping_Button() {
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordMappingLinkHide().click();
    }

    @Then("the password is displayed")
    public void the_password_is_displayed() {
        verify().expectedResult("Display password", !on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordMappingLinkHide().isDisplayed())
                .showMessageIfVerificationFailed("Incorrect icon display password!").and()
                .expectedResult("Display password", on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordMappingLinkShow().isDisplayed())
                .showMessageIfVerificationFailed("Incorrect icon display password!").finish();
    }
}
