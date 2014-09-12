package com.livejournal.uitests.registration.useful.register_an_account_with_correct_data;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.finish_form.SuccessfulFinishForm;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
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

    //Scenario: Successfull registration(1/3)
    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    //Scenario: Go to registration form(1/2)
    @When("user on Main Page clicks on Login Menu and clicks Create New Account")
    public void user_on_Main_Page_clicks_on_Login_Menu_and_clicks_Create_New_Account() {
        on(MainPageUnlogged.class)
                .getFullscreenHeaderUnlogged()
                .getLoginMenuItem().click();
        on(LoginForm.class).getCreateAccountLink().click();
    }

    //Scenario: Successfull registration(2/3)
    @When("user enter correct data: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender and clicks Create Account")
    public void user_enter_data_and_clicks_Create_Account(String name, String email, String password, String day, String month, String year, String gender){
        on(CreateAccountPage.class)
                .createAccountData(new RandomName(name).get(),
                        email,
                        password,
                        Date.parceDayOrGetCurrent(day).toString(),
                        Date.parceMonthOrGetCurrent(month).toString(),
                        Date.parceYearOrGetCurrent(year).toString(),
                        gender)
                .clickOnCreateAccountButton();
    }

    //Scenario: Go to registration form(2/2)
    @Then("user in correct page $page with URL $URL")
    public void user_in_correct_page_with_URL(String page, String URL) {
        verify().that(getCurrentUrl().contains(URL))
                .ifResultIsExpected(VerifyText.okTextForURL(page, URL))
                .ifElse(VerifyText.errorTextForURL(page, URL, getCurrentUrl()))
                .finish();
    }

    //Scenario: Successfull registration(3/3)
    @Then("user go to Finish Registration Form and see message $message")
    public void user_go_to_Finish_Registration_Form_and_see_message_and_create_First_Post(String message) {

        verify().that(on(SuccessfulFinishForm.class).getFinishText().contains(message))
                .ifResultIsExpected(VerifyText.okTextForMessage(message))
                .ifElse(VerifyText.errorTextForMessage(message, on(SuccessfulFinishForm.class).getFinishText()))
                .finish();
        on(SuccessfulFinishForm.class).createFirstPost();
    }

}
