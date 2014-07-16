
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

    @When("user enter correct data except for the age: <name>,<email>,<password>,<day>,<month>,<year>,<gender> and clicks Create Account")
    public void user_enter_data(@Named("name") String name,
            @Named("email") String email,
            @Named("password") String password,
            @Named("day") String day,
            @Named("month") String month,
            @Named("year") String year,
            @Named("gender") String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                day,
                month,
                year,
                gender);
        on(CreateAccountPage.class).createAccountForm.createAccountButton.click();
    }

    @Then("user go to Finish Registration Form and see message <message>")
    public void user_go_to_Finish_Registration_Form(@Named("message") String message) {
        String finishText = on(CreateAccountPage.class).finishForm.finishText.getText();
        Assert.assertTrue("Incorrect text!", finishText.contains(message));
        on(CreateAccountPage.class).finishForm.createFirstPostButton.click();
    }

}
