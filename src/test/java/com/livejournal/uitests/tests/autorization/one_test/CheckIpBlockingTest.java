package com.livejournal.uitests.tests.autorization.one_test;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;

/**
 *
 * @author m.prytkova
 */
public class CheckIpBlockingTest extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        on(LoginPage.class);

    }
    
   
}
