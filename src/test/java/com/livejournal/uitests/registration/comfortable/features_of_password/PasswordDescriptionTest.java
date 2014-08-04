package com.livejournal.uitests.registration.comfortable.features_of_password;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.PopupsBlock;
import com.livejournal.uitests.utility.Verificate;
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

    @When("user enter123 password $password")
    public void user_see_Password_Bubble_In_Registration_Page(String password) {
        on(CreateAccountPage.class).getCreateAccountForm().getPasswordBlock().getPasswordField().enter(password);

    }

    @Then("user see Password Bubble which contains text $text and URL $URL")
    public void password_Bubble_contains_text(String text, String URL) {
        verify.verifyStatus("Popup is not displyed!", on(PopupsBlock.class).isDisplayed());
        verify.verifyText("Incorrect text on Popup!", on(PopupsBlock.class).getPopupText().getText(), text);
        on(PopupsBlock.class).getLearnMoreLink().click();
        verify.verifyText("Incorrect URL!", getCurrentBrowser().getDriver().getTitle(), URL);
        // вытаскивает страницу, которыю он инициализировал, а не текущую
    }
}
