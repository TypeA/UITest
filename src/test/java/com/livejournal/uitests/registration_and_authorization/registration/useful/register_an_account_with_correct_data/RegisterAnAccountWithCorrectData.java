package com.livejournal.uitests.registration_and_authorization.registration.useful.register_an_account_with_correct_data;

import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.utility.date.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class RegisterAnAccountWithCorrectData extends LJTest {

    //Scenario: Successfull registration(1/3)
    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        open(CreateAccountPage.class);
        addCookie("langpref", "en_LJ");
        open(CreateAccountPage.class);
    }

    //Scenario: Successfull registration(2/3)
    @When("user enter correct data: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender and clicks Create Account")
    public void user_enter_data_and_clicks_Create_Account(String name, String email, String password, String day, String month, String year, String gender) {
        onOpened(CreateAccountPage.class)
                .createAccountData(utility().random().getRandomName(name),
                        email,
                        password,
                        Date.parceDayOrGetCurrent(day).toString(),
                        Date.parceMonthOrGetCurrent(month).toString(),
                        Date.parceYearOrGetCurrent(year).toString(),
                        gender)
                .clickOnCreateAccountButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RegisterAnAccountWithCorrectData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Scenario: Successfull registration(3/3)
    @Then("user in correct page $page")
    public void user_go_to_Finish_Registration_Form_and_see_message(String page) {
        verify().thatIsOn((Class<? extends Page>) this.getPageClassByName(page))
                .finish();

    }

}
