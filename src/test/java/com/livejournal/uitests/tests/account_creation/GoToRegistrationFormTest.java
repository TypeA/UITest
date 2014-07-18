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
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author m.prytkova
 */
public class GoToRegistrationFormTest extends WebTest {

  //  @Steps
    //  Verificate verify;
    @Managed
    public WebDriver driver;

    @Test
    public void goToRegistrationFormTest() {

        on(MainPage.class).enterLink.click();
        on(LoginForm.class).createAccountLink.click();

        Url createAccountURL = on(CreateAccountPage.class).getUrl();
        //   verify.verifyText("We are not in Create Account Page", createAccountURL.toString(), "/create");

    }

}
