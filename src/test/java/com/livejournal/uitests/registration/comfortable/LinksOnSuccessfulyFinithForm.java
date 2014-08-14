package com.livejournal.uitests.registration.comfortable;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.utility.Date;
import com.livejournal.uitests.utility.RandomName;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class LinksOnSuccessfulyFinithForm extends WebTest {

    @Given("new user on Finish Form (data: name $name, email $email, password $password, day $day, month $month, year $year, gender $gender)")
    public void new_user_on_Finish_Form(String name, String email, String password, String day, String month, String year, String gender) {
        on(CreateAccountPage.class).createAccountData(new RandomName(name).get(),
                email,
                password,
                Date.parceDayOrGetCurrent(day).toString(),
                Date.parceMonthOrGetCurrent(month).toString(),
                Date.parceYearOrGetCurrent(year).toString(),
                gender);
        verify().expectedResult("Create Account Button is enabled", on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().isEnabled())
                .showMessageIfVerificationFailed("Button is disabled!").finish();
        on(CreateAccountPage.class).getCreateAccountForm().getCreateAccountButton().click();

    }

    @When("user click Edit Profile Link")
    public void user_click_Edit_Profile_Link() {
        on(CreateAccountPage.class).getSuccessfulFinishForm().getEditProfile().click();

    }

    @When("user click Find Friends Link")
    public void user_click_Find_Friends_Link() {
        on(CreateAccountPage.class).getSuccessfulFinishForm().getFindFiends().click();

    }

    @When("user click Validate Email Link")
    public void user_click_Validate_Email_Link() {
        on(CreateAccountPage.class).getSuccessfulFinishForm().getValidateEmail().click();

    }

    @When("user click Сhange Email Link")
    public void user_click_Сhange_Email_Link() {
        on(CreateAccountPage.class).getSuccessfulFinishForm().getChangeEmail().click();

    }

    @When("user click Select Journal Style Link")
    public void user_click_Select_Journal_Link() {
        on(CreateAccountPage.class).getSuccessfulFinishForm().getCustomizeJournal().click();

    }

    @When("user click Friends Feed Link")
    public void user_click_Friends_Feed_Link() {
        on(CreateAccountPage.class).getSuccessfulFinishForm().getFrendsFeed().click();

    }

    @When("user click Ratings Link")
    public void user_click_Ratings_Link() {
        on(CreateAccountPage.class).getSuccessfulFinishForm().getRatings().click();

    }

    @Then("user in correct page $page with URL $URL")
    public void user_in_Edit_Profile_Page(String page, String URL) {
        verify().expectedResult("You are in Edit Profile Page.\nURL contains: /manage/profile", getCurrentUrl().contains("/manage/profile"))
                .showMessageIfVerificationFailed("You are not in Edit Profile Page!\nCurrent URL: " + getCurrentUrl() + "\nCorrect URL contains: /manage/profile").finish();
    }
}
