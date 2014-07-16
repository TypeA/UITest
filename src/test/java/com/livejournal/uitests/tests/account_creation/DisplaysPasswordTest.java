/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author m.prytkova
 */
public class DisplaysPasswordTest extends WebTest{
    
    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }
    
    @When ("user enter password $password")
    public void user_enter_password (String password){
        on(CreateAccountPage.class)
                .createAccountForm
                .passwordBlock
                .passwordField.enter(password);
    }
    
    @Then ("the password is hidden")
     public void the_password_is_hidden(){
         Assert.assertTrue(on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkHide.isDisplayed());
         Assert.assertFalse(on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkShow.isDisplayed());
     }
    
     @When ("user clicks Mapping Button")
     public void user_clicks_Mapping_Button(){
         on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkHide.click();
     }
     
     @Then ("the password is displayed")
     public void the_password_is_displayed (){
         Assert.assertFalse(on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkHide.isDisplayed());
         Assert.assertTrue(on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkShow.isDisplayed());
     }
}
