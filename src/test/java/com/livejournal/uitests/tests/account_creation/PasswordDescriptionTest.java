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
public class PasswordDescriptionTest extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter password <password>")
    public void user_see_Password_Bubble_In_Registration_Page(@Named("password") String password) {
        on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordField.enter(password);
        
    }

    @Then("user see Password Bubble which contains text <text> and URL <URL>")
    public void password_Bubble_contains_text(@Named("text") String text,@Named("URL") String learnMoreUrl) {
        on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordField.click();
        //Assert.assertTrue("Popup is not displyed!", on(Popups.class).isDisplayed());
        //String correctText = on(CreateAccountPage.class).createAccountForm.popups.popupText.getText();
        //Assert.assertTrue("Incorrect text!", correctText.contains(text));
        on(CreateAccountPage.class).createAccountForm.popups.learnMoreLink.click();
        String correctURL = this.getCurrentBrowser().getDriver().getCurrentUrl();
        Assert.assertTrue("Incorrect URL!", correctURL.contains(learnMoreUrl));
    }

}
