
package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.LoginForm;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPage;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author m.prytkova
 */
//@RunWith(ThucydidesRunner.class)
public class GoToRegistrationFormTest extends WebTest {

    @Steps
    Verificate verify;

    @Ignore @Test
    public void go_to_Registration_Form() {
        on(MainPage.class).enterLink.click();
        on(LoginForm.class).createAccountLink.click();
        Url createAccountURL = on(CreateAccountPage.class).getUrl();
        verify.verifyText("We are not in Create Account Page", createAccountURL.toString(), "/create");
    }

}
