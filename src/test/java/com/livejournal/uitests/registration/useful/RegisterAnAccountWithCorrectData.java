package com.livejournal.uitests.registration.useful;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageForUnsignedInUser;
import com.livejournal.uitests.utility.Date;
import com.livejournal.uitests.utility.RandomName;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class RegisterAnAccountWithCorrectData extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        getCurrentBrowser().clearCache();
        on(CreateAccountPage.class);
    }

    @When("user on Main Page clicks on Login Menu and clicks Create New Account")
    public void user_on_Main_Page_clicks_on_Login_Menu() {
        on(MainPageForUnsignedInUser.class)
                .getFullscreenHeaderUnlogged()
                .getLoginMenuItem().click();
        on(LoginForm.class).getCreateAccountLink().click();
    }

    @When("user enter correct data: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender and clicks Create Account")
    public void user_enter_data(String name, String email, String password, String day, String month, String year, String gender) {

        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        verify().expectedResult("Create Account Button", on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().isEnabled())
                .showMessageIfVerificationFailed("Button is disabled!").finish();
        on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().click();
    }

    @Then("user should be on Registration Form")
    public void user_should_be_on_Registration_Form() {
        verify().expectedResult("Create Account link", getCurrentBrowser().getDriver().getCurrentUrl().contains("/create"))
                .showMessageIfVerificationFailed("You are not in Create Account Page! Current URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + " Correct URL contains: /create").finish();
    }

    @Then("user go to Finish Registration Form and see message $message")
    public void user_go_to_Finish_Registration_Form(String message) {
        verify().expectedResult("Text on Finish Registration Form", on(CreateAccountPage.class).getSuccessfulFinishForm().getFinishText().getText().contains(message))
                .showMessageIfVerificationFailed("Incorrect text on Finish Registration Form! Current text: " + getCurrentBrowser().getDriver().getCurrentUrl() + " Correct text contains: " + message).finish();
    }

}
