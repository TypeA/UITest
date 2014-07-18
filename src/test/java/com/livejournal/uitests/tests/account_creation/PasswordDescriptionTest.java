
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
public class PasswordDescriptionTest extends WebTest {
    
    private String password = "Test123";
    private String text = "Требования к паролю:";
    private String URL = "http://www.livejournal.com/support/faq/71.html";
    
    @Steps
    Verificate verify;

    @Ignore @Test
    public void password_description() {
        on(CreateAccountPage.class);
        on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordField.enter(password);
        on(CreateAccountPage.class).createAccountForm.passwordBlock.passwordField.click();
        //Assert.assertTrue("Popup is not displyed!", on(Popups.class).isDisplayed());
        //String correctText = on(CreateAccountPage.class).createAccountForm.popups.popupText.getText();
        //Assert.assertTrue("Incorrect text!", correctText.contains(text));
        //       on(CreateAccountPage.class).createAccountForm.popups.learnMoreLink.click();
//        on(Popups.class).learnMoreLink.click();
        //String correctURL = this.getCurrentBrowser().getDriver().getCurrentUrl();
        //verify.verifyText("Incorrect URL!", correctURL, learnMoreUrl);
    }

}
