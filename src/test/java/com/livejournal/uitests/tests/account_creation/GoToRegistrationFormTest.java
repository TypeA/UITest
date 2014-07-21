/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.LoginForm;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPage;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class GoToRegistrationFormTest extends WebTest {

    @Steps
    Verificate verify;

    @When("user on Main Page clicks on Login Menu and clicks Create New Account")
    public void user_on_Main_Page_clicks_on_Login_Menu() {
        on(MainPage.class).enterLink.click();
        on(LoginForm.class).createAccountLink.click();
    }

    @Then("user should be on Registration Form")
    public void user_should_be_on_Registration_Form() throws InterruptedException {
        verify.verifyText("We are not on Create Account Page", on(CreateAccountPage.class).getUrl().toString(), "/create");
    }

}
