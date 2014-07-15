/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author m.prytkova
 */
public class PasswordDescriptionTest extends WebTest {

    @When("user see bubble Password Bubble In Registration Page")
    public void user_see_Password_Bubble_In_Registration_Page() {
        on(CreateAccountPage.class).createAccountForm.popups.getClass();
    }

    @Then("Then Password Bubble In Registration Page contains text <text>")
    public void password_Bubble_contains_text(@Named("text") String text) {
        String correctText = on(CreateAccountPage.class).createAccountForm.popups.popupText.getText();
        Assert.assertTrue("Incorrect text!", correctText.contains(text));
    }

    @Then("Password Bubble In Registration Page contains URL <URL>")
    public void password_Bubble_contains_URL(@Named("URL") String learnMoreUrl) {
        on(CreateAccountPage.class).createAccountForm.popups.learnMoreLink.click();
        String correctURL = this.getCurrentBrowser().getDriver().getCurrentUrl();
        Assert.assertTrue("Incorrect URL!", correctURL.contains(learnMoreUrl));
    }

}
