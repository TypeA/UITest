/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.Popups;
import com.livejournal.uitests.tests.utility.Date;
import com.livejournal.uitests.tests.utility.RandomName;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class EmptyNameTest extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
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
    }

    @Then("in Name Popup user see message $message and button Create Account is not active")
    public void user_see_message_on_popup(String message) {
        on(CreateAccountPage.class).getCreateAccountForm().getUserNameField().click();
        verify.verifyStatus("Popup is not displyed!", on(Popups.class).getPopupBlock().isDisplayed());
        verify.verifyText("Incorrect text on Popup!", on(Popups.class).getPopupText().getText(), message);
        verify.verifyStatus("Button is enabled!", !on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().isEnabled());

    }

}
