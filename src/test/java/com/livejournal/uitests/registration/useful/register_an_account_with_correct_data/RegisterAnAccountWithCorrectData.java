package com.livejournal.uitests.registration.useful.register_an_account_with_correct_data;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageForUnsignedInUser;
import com.livejournal.uitests.utility.Date;
import com.livejournal.uitests.utility.RandomName;
import com.livejournal.uitests.utility.VerifyText;
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
        on(CreateAccountPage.class);
    }

    @When("user on Main Page clicks on Login Menu and clicks Create New Account")
    public void user_on_Main_Page_clicks_on_Login_Menu_and_clicks_Create_New_Account() {
        on(MainPageForUnsignedInUser.class)
                .getFullscreenHeaderUnlogged()
                .getLoginMenuItem().click();
        on(LoginForm.class).getCreateAccountLink().click();
    }

    @When("user enter correct data: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender and clicks Create Account")
    public void user_enter_data_and_clicks_Create_Account(String name, String email, String password, String day, String month, String year, String gender) {

        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        verify().expectedResult("Create Account Button is enabled", on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().isEnabled())
                .showMessageIfVerificationFailed("Button is disabled!").finish();
        on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().click();
    }

    @Then("user in correct page $page with URL $URL")
    public void user_in_correct_page_with_URL(String page, String URL) {
        verify().expectedResult(VerifyText.okTextForURL(page, URL), getCurrentUrl().contains(URL))
                .showMessageIfVerificationFailed(VerifyText.errorTextForURL(page, URL, getCurrentUrl())).finish();
     }

    @Then("user go to Finish Registration Form and see message &message and create First Post")
    public void user_go_to_Finish_Registration_Form_and_see_message_and_create_First_Post(String message) {
        verify().expectedResult(VerifyText.okTextForMessage(message), on(CreateAccountPage.class).getSuccessfulFinishForm().getFinishText().getText().contains(message))
                .showMessageIfVerificationFailed(VerifyText.errorTextForMessage(message, on(CreateAccountPage.class).getSuccessfulFinishForm().getFinishText().getText())).finish();
        on(CreateAccountPage.class).getSuccessfulFinishForm().getCreateFirstPostButton().click();
    }

}
