
package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.LJPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.Popups;
import com.livejournal.uitests.tests.utility.Verificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class PasswordDescriptionTest extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter password $password")
    public void user_see_Password_Bubble_In_Registration_Page(String password) {
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordField().enter(password);

    }

    @Then("user see Password Bubble which contains text $text and URL $URL")
    public void password_Bubble_contains_text(String text, String URL) {
        verify.verifyStatus("Popup is not displyed!", on(Popups.class).isDisplayed());
        verify.verifyText("Incorrect text on Popup!", on(Popups.class).getPopupText().getText(), text);
        on(Popups.class).getLearnMoreLink().click();
        verify.verifyText("Incorrect URL!", getCurrentBrowser().getDriver().getTitle(), URL);
        // вытаскивает страницу, которыю он инициализировал, а не текущую
    }
}
