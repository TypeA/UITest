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
        getCurrentBrowser().clearCache();
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

    @Then("user in Edit Profile Page")
    public void user_in_Edit_Profile_Page() {
        verify().expectedResult("You are in Edit Profile Page.\nURL contains: /manage/profile", getCurrentBrowser().getDriver().getCurrentUrl().contains("/manage/profile"))
                .showMessageIfVerificationFailed("You are not in Edit Profile Page!\nCurrent URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + "\nCorrect URL contains: /manage/profile").finish();
    }

    @Then("user in Find Friends Page")
    public void user_in_Find_Friends_Page() {
        verify().expectedResult("You are in Find Friends Page.\nURL contains: /friends/find", getCurrentBrowser().getDriver().getCurrentUrl().contains("/friends/find"))
                .showMessageIfVerificationFailed("You are not in Find Friends Page!\nCurrent URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + "\nCorrect URL contains: /friends/find").finish();
    }

    @Then("user in Validate Email Page")
    public void user_in_Validate_Email_Page() {
        verify().expectedResult("You are in Validate Email Page.\nURL contains: /register.bml", getCurrentBrowser().getDriver().getCurrentUrl().contains("/register.bml"))
                .showMessageIfVerificationFailed("You are not in Validate Emai Page!\nCurrent URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + "\nCorrect URL contains: /register.bml").finish();

    }

    @Then("user in Сhange Email Page")
    public void user_in_Сhange_Email_Page() {
        verify().expectedResult("You are in Сhange Email Page.\nURL contains: /changeemail.bml", getCurrentBrowser().getDriver().getCurrentUrl().contains("/changeemail.bml"))
                .showMessageIfVerificationFailed("You are not in Сhange Email Page!\nCurrent URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + "\nCorrect URL contains: /changeemail.bml").finish();

    }

    @Then("user in Select Journal Style Page")
    public void user_in_Select_Journal_Page() {
        verify().expectedResult("You are in Select Journal Page.\nURL contains: /customize", getCurrentBrowser().getDriver().getCurrentUrl().contains("/customize"))
                .showMessageIfVerificationFailed("You are not in Select Journal Page!\nCurrent URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + "\nCorrect URL contains: /customize").finish();

    }

    @Then("user in Friends Feed Page")
    public void user_in_Friends_Feed_Page() {
        verify().expectedResult("You are in Friends Feed Page.\nURL contains: /feed", getCurrentBrowser().getDriver().getCurrentUrl().contains("/feed"))
                .showMessageIfVerificationFailed("You are not in Friends Feed Page!\nCurrent URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + "\nCorrect URL contains: /feed").finish();

    }

    @Then("user in Ratings Page")
    public void user_in_Ratings_Page() {
        verify().expectedResult("You are in Ratings Page.\nURL contains: /ratings", getCurrentBrowser().getDriver().getCurrentUrl().contains("/ratings"))
                .showMessageIfVerificationFailed("You are not in Ratings Page!\nCurrent URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + "\nCorrect URL contains: /ratings").finish();

    }
}
