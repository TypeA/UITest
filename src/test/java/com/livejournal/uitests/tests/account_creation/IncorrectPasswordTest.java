/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.tests.utility.Date;
import com.livejournal.uitests.tests.utility.RandomName;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author m.prytkova
 */
public class IncorrectPasswordTest extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter correct data except for the password: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender and clicks Create Account")
    public void user_enter_data(String name, String email, String password, String day, String month, String year, String gender){

        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
    }

    @Then("button Create Account is not active and user see message $message on popup")
    public void user_see_message_on_popup(String message) {
        on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordField.click();
        //Assert.assertTrue("Popup is not displyed!", on(Popups.class).isDisplayed());
        //String correctMessage = on(CreateAccountPage.class).createAccountForm.popups.popupText.getText();
        //Assert.assertTrue("Incorrect text!", correctMessage.contains(message));
        Assert.assertFalse("Button is enabled!", on(CreateAccountPage.class).createAccountForm.createAccountButton.isEnabled());
    }

}
