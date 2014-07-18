package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
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
@RunWith(ThucydidesRunner.class)
public class DisplaysPasswordTest extends WebTest {

    private String password = "Test123";
    
    @Steps
    Verificate verify;
    
   
    @Ignore @Test
    public void displays_Password() {
        
        on(CreateAccountPage.class);
        on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordField.enter(password);
        verify.verifyStatus("Incorrect icon display password!", on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkHide.isDisplayed());
        verify.verifyStatus("Incorrect icon display password!", !on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkShow.isDisplayed());
        on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkHide.click();
        verify.verifyStatus("Incorrect icon display password!", !on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkHide.isDisplayed());
        verify.verifyStatus("Incorrect icon display password!", on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordMappingLinkShow.isDisplayed());

    }

}
