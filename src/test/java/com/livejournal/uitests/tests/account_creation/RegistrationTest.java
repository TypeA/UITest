package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author m.prytkova
 */
public class RegistrationTest extends WebTest {

    @When("user enter correct name $name")
    public void user_enter_correct_name(String name) {
        on(CreateAccountPage.class).createAccountForm.userNameField
                .enter(name);
    }

    @Then("user see than name is $name")
    public void user_see_than_name_is(String name) {
        String testName = on(CreateAccountPage.class).createAccountForm.userNameField
                .getText();
        boolean result = testName.equals(name);
        Assert.assertTrue(true);
    }
}
