package com.livejournal.uitests.registration.useful.register_an_account_with_the_incorrect_data;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.PopupsBlock;
import com.livejournal.uitests.utility.Date;
import com.livejournal.uitests.utility.RandomName;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class EmptyEmailTest extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter correct data leave email field empty: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_leave_name(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
    }

    @Then("in Email Popup user see message $message and button Create Account is not active")
    public void user_see_message_on_popup(String message) {
        on(CreateAccountPage.class).getCreateAccountForm().getEmailField().type("");
        verify().expectedResult("Displyed popup", on(PopupsBlock.class).getPopupBlock().isDisplayed())
                .showMessageIfVerificationFailed("Popup is not displyed!").and()
                .expectedResult("Text on Popup", on(PopupsBlock.class).getPopupText().getText().contains(message))
                .showMessageIfVerificationFailed("Incorrect text on Popup! Current text: " + on(PopupsBlock.class).getPopupText().getText() + " Correct text: " + message).and()
                .expectedResult("Create account Button", !on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().isEnabled())
                .showMessageIfVerificationFailed("Button is enabled!").finish();

    }

}
