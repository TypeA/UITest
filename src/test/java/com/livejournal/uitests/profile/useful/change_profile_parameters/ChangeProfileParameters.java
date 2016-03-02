package com.livejournal.uitests.profile.useful.change_profile_parameters;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageLogged;
import com.livejournal.uitests.pages.service_pages.settings.edit_profile.EditProfilePageLogged;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author p.kulich
 */
public class ChangeProfileParameters extends LJTest {

    //Scenario: Change name (1/3)
    //Scenario: Change gender (1/3)
    //Scenario: Change date of birth (1/3)
    @Given("logged user $user on Edit Profile page")
    public void logged_user_on_profile(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(EditProfilePageLogged.class);
    }

    //Scenario: Change name (2/3)
    @When("user enter another name $name on Edit profile page")
    public void user_enter_name(String name) {
        onOpened(EditProfilePageLogged.class)
                .setName(name)
                .saveSettings();
    }

    //Scenario: Change gender (2/3)
    @When("user enter another gender $gender on Edit profile page")
    public void user_enter_gender(String gender) {

    }

    //Scenario: Change date of birth (2/3)
    @When("user enter another day $day month $month year $year on Edit profile page")
    public void user_enter_birthday(String day, String month, String year) {

    }

    //Scenario: Change name (3/3)
    @Then("in Profile user see new name $name")
    public void user_see_new_name(String name) {
        System.out.println("---------------- STEP3");
        System.out.println("!!!!!!!!!!!!!!!!!" + this.startScript("return jQuery('.b-profile-group.b-profile-userinfo .b-profile-group-row .b-profile-group-body').eq(0).text()"));
        verify().that(onOpened(ProfilePageLogged.class).getName().equals(name))
                .ifResultIsExpected("Name " + name + " is correct")
                .ifElse("Name " + onOpened(ProfilePageLogged.class).getName() + " is not correct.")
                .finish();
        System.out.println("!!!!!!!!!!!!!!!!!" + ProfilePageLogged.class.getName());
        /*
                .and();
        
        verify().that(onOpened(EditProfilePageLogged.class).getName().equals(name))
                .ifResultIsExpected("Name " + name + " is correct")
                .ifElse("Name " + onOpened(EditProfilePageLogged.class).getName() + " is not correct.")
                .finish();
         */
    }

    //Scenario: Change gender (3/3)
    @Then("in Profile user see new gender $gender")
    public void user_see_new_gender(String gender) {

    }

    //Scenario: Change date of birth (3/3)
    @Then("in Profile user see new date of birth $day.$month.$year")
    public void user_see_new_birthday(String day, String month, String year) {

    }
}
