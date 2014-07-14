/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.tests.utility.ActualDate;
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
public class RegistrationTest extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter correct data: <name>,<email>,<password>,<day>,<monse>,<year>,<gender>")
    public void user_enter_data(@Named("name") String name,
            @Named("email") String email,
            @Named("password") String password,
            @Named("day") String day,
            @Named("monse") String month,
            @Named("year") String year,
            @Named("gender") String gender) throws InterruptedException {
        
        
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                                                      email, 
                                                      password,
                                                      new ActualDate(day,month,year).getDay(day),
                                                      new ActualDate(day,month,year).getMonth(month),
                                                      new ActualDate(day,month,year).getYear(year),
                                                      gender);

    Thread.sleep(5000);
    }

    @When("user clicks Create Account")
    public void user_clicks_Create_Account() {
        on(CreateAccountPage.class).createAccountForm.createAccountButton.click();
    }

    @Then("user go to Finish Registration Form and see message <message>")
    public void user_go_to_Finish_Registration_Form(@Named("message") String message) {
        String finishTextT = on(CreateAccountPage.class).finishForm.finishText.getText();
        Assert.assertTrue("Incorrect text!", finishTextT.toString().contains(message));
    }

    @Then("user is registreted and create First Post")
    public void user_create_First_Post() {
        on(CreateAccountPage.class).finishForm.createFirstPostButton.click();
    }
    
}
