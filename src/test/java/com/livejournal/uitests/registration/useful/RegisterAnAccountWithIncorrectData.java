package com.livejournal.uitests.registration.useful;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.PopupsBlock;
import com.livejournal.uitests.utility.Date;
import com.livejournal.uitests.utility.NumberOfSymbols;
import com.livejournal.uitests.utility.RandomName;
import com.livejournal.uitests.utility.VerifyText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author Maxa
 */
public class RegisterAnAccountWithIncorrectData extends WebTest {

    @Given("unlogged user on Registration Form1")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter correct data leave one age field empty: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_leave_one_age(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                day,
                month,
                year,
                gender);
        on(CreateAccountPage.class).getCreateAccountForm().getBirthDateForm().getYearDropDownMenu().getWrappedElement().click();

    }

    @When("user enter correct data leave email field empty: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_leave_email(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        on(CreateAccountPage.class).getCreateAccountForm().getEmailField().type("");
    }

    @When("user enter correct data leave name field empty: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_leave_name(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(name,
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        on(CreateAccountPage.class).getCreateAccountForm().getUserNameField().type("");

    }

    @When("user enter correct data leave password field empty: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_leave_password(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordField().type("");

    }

    @When("user enter correct data except for the age: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_except_age(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                day,
                month,
                year,
                gender);
        verify().expectedResult("Create account Button", on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().isEnabled())
                .showMessageIfVerificationFailed("Button is disabled!").finish();
        on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().click();
    }

    @When("user enter correct data except for the email: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_except_email(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                NumberOfSymbols.get(email, 30),
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        on(CreateAccountPage.class).getCreateAccountForm().getEmailField().type("");

    }

    @When("user enter correct data except for the name: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_except_name(String name, String email, String password, String day, String month, String year, String gender) {

        on(CreateAccountPage.class).createAccountData(NumberOfSymbols.get(new RandomName(name).get(), 30),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        on(CreateAccountPage.class).getCreateAccountForm().getUserNameField().type("");

    }

    @When("user enter correct data except for the password: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_except_password(String name, String email, String password, String day, String month, String year, String gender) {

        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                NumberOfSymbols.get(password, 30),
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordField().type("");

    }

    @Then("in Popup user see message $message and button Create Account is not active")
    public void user_see_message_on_age_popup(String message) {
        verify().expectedResult("Popup is displyed", on(PopupsBlock.class).getPopupBlock().isDisplayed())
                .showMessageIfVerificationFailed("Popup is not displyed!").and()
                .expectedResult(VerifyText.okTextForMessage(message), on(PopupsBlock.class).getPopupText().getText().contains(message))
                .showMessageIfVerificationFailed(VerifyText.errorTextForMessage(message, on(PopupsBlock.class).getPopupText().getText())).and()
                .expectedResult("Create account Button is disabled", !on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().isEnabled())
                .showMessageIfVerificationFailed("Button is enabled!").finish();

    }

    @Then("user go to Finish Registration Form and see message $message")
    public void user_go_to_Finish_Registration_Form(String message) {
        verify().expectedResult(VerifyText.okTextForMessage(message), on(CreateAccountPage.class).getUnsuccessfulFinishForm().getFinishText().getText().contains(message))
                .showMessageIfVerificationFailed(VerifyText.errorTextForMessage(message, on(CreateAccountPage.class).getUnsuccessfulFinishForm().getFinishText().getText())).finish();

    }

}
