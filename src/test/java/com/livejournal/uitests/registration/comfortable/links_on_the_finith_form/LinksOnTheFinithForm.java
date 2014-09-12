package com.livejournal.uitests.registration.comfortable.links_on_the_finith_form;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.finish_form.SuccessfulFinishForm;
import com.livejournal.uitests.pages.service_pages.create_account_pages.finish_form.UnsuccessfulFinishForm;
import com.livejournal.uitests.utility.Date;
import com.livejournal.uitests.utility.RandomName;
import com.livejournal.uitests.utility.VerifyText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class LinksOnTheFinithForm extends WebTest {

    //Scenario: Сhange Email link(1/3)
    //Scenario: Validate Email link(1/3)
    //Scenario: Edit Profile link(1/3)
    //Scenario: Find Friends link(1/3)
    //Scenario: Select Journal Style link(1/3)
    //Scenario: Friends Feed link(1/3)
    //Scenario: Ratings link(1/3)
    @Given("new user on Finish Form (data: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender)")
    public void new_user_on_Finish_Form(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        on(CreateAccountPage.class).clickOnCreateAccountButton();

    }

    //Scenario: Edit Profile link(2/3)
    @When("user click Edit Profile Link")
    public void user_click_Edit_Profile_Link() {
        on(SuccessfulFinishForm.class).clickOnEditProfileLink();

    }

    //Scenario: Find Friends link(2/3)
    @When("user click Find Friends Link")
    public void user_click_Find_Friends_Link() {
        on(SuccessfulFinishForm.class).clickOnFindFiendsLink();

    }

    //Scenario: Validate Email link(2/3)
    @When("user click Validate Email Link")
    public void user_click_Validate_Email_Link() {
        on(SuccessfulFinishForm.class).clickOnValidateEmailLink();

    }

    //Scenario: Сhange Email link(2/3)
    @When("user click Сhange Email Link")
    public void user_click_Сhange_Email_Link() {
        on(SuccessfulFinishForm.class).clickOnChangeEmailLink();

    }

    //Scenario: Select Journal Style link(2/3)
    @When("user click Select Journal Style Link")
    public void user_click_Select_Journal_Link() {
        on(SuccessfulFinishForm.class).clickOnCustomizeJournalLink();

    }

    //Scenario: Friends Feed link(2/3)
    @When("user click Friends Feed Link")
    public void user_click_Friends_Feed_Link() {
        on(SuccessfulFinishForm.class).clickOnFrendsFeedLink();

    }

    //Scenario: Ratings link(2/3)
    @When("user click Ratings Link")
    public void user_click_Ratings_Link() {
        on(SuccessfulFinishForm.class).clickOnRatingsLink();

    }

    //Scenario: Underage Account link(2/3)
    @When("user click Underage Account Link")
    public void user_click_Underage_Account_Link() {
        on(UnsuccessfulFinishForm.class).clickOnUnderageAccountLink();

    }

    //Scenario: LJ Anonymously link(2/3)
    @When("user click LJ Anonymously Link")
    public void user_click_LJ_Anonymously_Link() {
        on(UnsuccessfulFinishForm.class).clickOnLjAnonymouslyLink();

    }

    //Scenario: Сhange Email link(3/3)
    //Scenario: Validate Email link(3/3)
    //Scenario: Edit Profile link(3/3)
    //Scenario: Find Friends link(3/3)
    //Scenario: Select Journal Style link(3/3)
    //Scenario: Friends Feed link(3/3)
    //Scenario: Ratings link(3/3)
    @Then("user in correct page $page with URL $URL")
    public void user_in_correct_Page_with_URL(String page, String URL) {
        verify().that(getCurrentUrl().contains(URL))
                .ifResultIsExpected(VerifyText.okTextForURL(page, URL))
                .ifElse(VerifyText.errorTextForURL(page, URL, getCurrentUrl()))
                .finish();
    }
}
