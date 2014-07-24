
package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.tests.utility.Date;
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
public class SuccessfullyRegistrationTest extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter correct data: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender and clicks Create Account")
    public void user_enter_data(String name, String email, String password, String day, String month, String year, String gender) {

        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        verify.verifyStatus("Button is disabled!", on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().isEnabled());
        on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().click();   
    }

    @Then("user go to Finish Registration Form and see message $message")
    public void user_go_to_Finish_Registration_Form(String message) {
        String finishText = on(CreateAccountPage.class).getFinishForm().getFinishText().getText();
        verify.verifyText("Incorrect text on Finish Registration Form!", finishText, message);
    }

}
