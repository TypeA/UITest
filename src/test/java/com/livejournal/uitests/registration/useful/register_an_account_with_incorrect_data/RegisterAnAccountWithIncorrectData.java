package com.livejournal.uitests.registration.useful.register_an_account_with_incorrect_data;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.PopupsBlock;
import com.livejournal.uitests.pages.service_pages.create_account_pages.finish_form.UnsuccessfulFinishForm;
import com.livejournal.uitests.utility.Date;
import com.livejournal.uitests.utility.NumberOfSymbols;
import com.livejournal.uitests.utility.RandomName;
import com.livejournal.uitests.utility.VerifyText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class RegisterAnAccountWithIncorrectData extends WebTest {

    //Scenario: Register an account with incorrect name(1/3)
    //Scenario: Register an account with incorrect email(1/3)
    //Scenario: Register an account with incorrect password(1/3)
    //Scenario: Register an account with incorrect age(1/3)
    //Scenario: Register an account with empty name(1/3)
    //Scenario: Register an account with empty email(1/3)
    //Scenario: Register an account with empty password(1/3)
    //Scenario: Register an account with empty age(1/3)
    //Scenario: Register an account with long name(1/3)
    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        open(CreateAccountPage.class);
    }

    //Scenario: Register an account with empty age(2/3)
    @When("user enter correct data leave one age field empty: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_leave_one_age_field_empty(String name, String email, String password, String day, String month, String year, String gender) {
        onOpened(CreateAccountPage.class)
                .createAccountData(new RandomName(name).get(),
                        email,
                        password,
                        day,
                        month,
                        year,
                        gender)
                .clickOnAgeField();

    }

    //Scenario: Register an account with incorrect age(2/3)
    @When("user enter correct data except for the age: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_correct_data_except_for_the_age(String name, String email, String password, String day, String month, String year, String gender) {
        onOpened(CreateAccountPage.class)
                .createAccountData(new RandomName(name).get(),
                        email,
                        password,
                        day,
                        month,
                        year,
                        gender)
                .clickOnCreateAccountButton();
    }

    //Scenario: Register an account with incorrect email(2/3)
    //Scenario: Register an account with empty email(2/3)
    @When("user enter correct data except for the email: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_correct_data_except_for_the_email(String name, String email, String password, String day, String month, String year, String gender) {
        onOpened(CreateAccountPage.class)
                .createAccountData(new RandomName(name).get(),
                        NumberOfSymbols.get(email, 30),
                        password,
                        Date.parceDayOrGetCurrent(day).toString(),
                        Date.parceMonthOrGetCurrent(month).toString(),
                        Date.parceYearOrGetCurrent(year).toString(),
                        gender)
                .clickOnEmailField();

    }

    //Scenario: Register an account with incorrect name(2/3)
    //Scenario: Register an account with empty name(2/3)
    //Scenario: Register an account with long name(2/3)
    @When("user enter correct data except for the name: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_correct_data_except_for_the_name(String name, String email, String password, String day, String month, String year, String gender) {
        onOpened(CreateAccountPage.class)
                .createAccountData(NumberOfSymbols.get(new RandomName(name).get(), 30),
                        email,
                        password,
                        Date.parceDayOrGetCurrent(day).toString(),
                        Date.parceMonthOrGetCurrent(month).toString(),
                        Date.parceYearOrGetCurrent(year).toString(),
                        gender)
                .clickOnUserNameField();

    }

    //Scenario: Register an account with incorrect password(2/3)
    //Scenario: Register an account with empty password(2/3)
    @When("user enter correct data except for the password: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_correct_data_except_for_the_password(String name, String email, String password, String day, String month, String year, String gender) {
        onOpened(CreateAccountPage.class)
                .createAccountData(new RandomName(name).get(),
                        email,
                        NumberOfSymbols.get(password, 30),
                        Date.parceDayOrGetCurrent(day).toString(),
                        Date.parceMonthOrGetCurrent(month).toString(),
                        Date.parceYearOrGetCurrent(year).toString(),
                        gender)
                .clickOnPasswordField();

    }

    //Scenario: Register an account with incorrect name(3/3)
    //Scenario: Register an account with incorrect email(3/3)
    //Scenario: Register an account with incorrect password(3/3)
    //Scenario: Register an account with empty name(3/3)
    //Scenario: Register an account with empty email(3/3)
    //Scenario: Register an account with empty password(3/3)
    //Scenario: Register an account with empty age(3/3)
    @Then("in Popup user see message $message and button Create Account is not active")
    public void in_Popup_user_see_message_and_button_Create_Account_is_not_active(String message) {
        verify().that(onDisplayed(PopupsBlock.class).displayingPopupBlock())
                .ifResultIsExpected("Popup is displyed")
                .ifElse("Popup is not displyed!")
                .and()
                .that(onDisplayed(PopupsBlock.class).getPopupText().contains(message))
                .ifResultIsExpected(VerifyText.okTextForMessage(message))
                .ifElse(VerifyText.errorTextForMessage(onDisplayed(PopupsBlock.class).getPopupText()))
                .and()
                .that(!onOpened(CreateAccountPage.class).createAccountButtonState())
                .ifResultIsExpected("Create account Button is disabled")
                .ifElse("Button is enabled!")
                .finish();

    }

    //Scenario: Register an account with long name(3/3)
    @Then("there is $symbols symbols in name field")
    public void there_is_symbols_in_name_field(String symbols) {
        verify().that(onOpened(CreateAccountPage.class).getNOSinName().equals(Integer.parseInt(symbols)))
                .ifResultIsExpected("The number of symbolsame in name is correct")
                .ifElse("The number of symbolsame in name is incorrect!");

    }

    //Scenario: Register an account with incorrect age(3/3)
    @Then("user go to Finish Registration Form and see message $message")
    public void user_go_to_Finish_Registration_Form_and_see_message(String message) {
        verify().that(onDisplayed(UnsuccessfulFinishForm.class).getFinishText().contains(message))
                .ifResultIsExpected(VerifyText.okTextForMessage(message))
                .ifElse(VerifyText.errorTextForMessage(onDisplayed(UnsuccessfulFinishForm.class).getFinishText()))
                .finish();

    }

}
