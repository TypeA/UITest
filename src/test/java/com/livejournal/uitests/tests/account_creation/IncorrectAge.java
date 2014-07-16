
package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.tests.utility.RandomName;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author m.prytkova
 */
public class IncorrectAge extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user enter correct data except for the age: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender")
    public void user_enter_data(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                day,
                month,
                year,
                gender);
        on(CreateAccountPage.class).createAccountForm.createAccountButton.click();
    }

    @Then("user go to Finish Registration Form and see message $message")
    public void user_go_to_Finish_Registration_Form(String message) {
        String finishText = on(CreateAccountPage.class).finishForm.finishText.getText();
        Assert.assertTrue("Incorrect text!", finishText.contains(message));
        on(CreateAccountPage.class).finishForm.createFirstPostButton.click();
    }

}
