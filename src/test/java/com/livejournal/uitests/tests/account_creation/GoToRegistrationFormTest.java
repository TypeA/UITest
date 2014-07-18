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
import net.thucydides.junit.runners.ThucydidesRunner;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author m.prytkova
 */
@RunWith(ThucydidesRunner.class)
public class GoToRegistrationFormTest extends WebTest {

        @Test
    public void user_on_Main_Page_clicks_on_Login_Menu_Test() {
        on(MainPage.class).enterLink.click();
        on(LoginForm.class).createAccountLink.click();
        Url createAccountURL = on(CreateAccountPage.class).getUrl();
        Assert.assertTrue("We are not in Create Account Page", createAccountURL.toString().contains("/create"));
    }



}
