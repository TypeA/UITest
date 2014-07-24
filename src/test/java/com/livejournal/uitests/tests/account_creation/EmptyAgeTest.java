package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.PopupsBlock;
import com.livejournal.uitests.tests.utility.RandomName;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class EmptyAgeTest extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter correct data leave one age field empty: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data_leave_name(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                day,
                month,
                year,
                gender);
    }

    @Then("in Age Popup user see message $message and button Create Account is not active")
    public void user_see_message_on_popup(String message) {
        on(CreateAccountPage.class).getCreateAccountForm().getBirthDateForm().getYearDropDownMenu().getWrappedElement().click();
        verify.verifyStatus("Popup is not displyed!", on(PopupsBlock.class).getPopupBlock().isDisplayed());
        verify.verifyText("Incorrect text on Popup!", on(PopupsBlock.class).getPopupText().getText(), message);
        verify.verifyStatus("Button is enabled!", !on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().isEnabled());
        
    }

}
