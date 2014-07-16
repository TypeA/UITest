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
public class IncorrectAgeTest extends WebTest{
    
        @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }
    
    @When ("user enter correct data except for the age: <name>,<email>,<password>,<day>,<monse>,<year>,<gender> and clicks Create Account")
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
                                                      day,
                                                      month,
                                                      year,
                                                      gender);
        on(CreateAccountPage.class).createAccountForm.createAccountButton.click();
    }
        
        @Then("user go to Finish Registration Form and see message <message> and create First Post")
    public void user_go_to_Finish_Registration_Form(@Named("message") String message) {
        String finishText = on(CreateAccountPage.class).finishForm.finishText.getText();
        Assert.assertTrue("Incorrect text!", finishText.contains(message));
        on(CreateAccountPage.class).finishForm.createFirstPostButton.click();
    }
    
}
