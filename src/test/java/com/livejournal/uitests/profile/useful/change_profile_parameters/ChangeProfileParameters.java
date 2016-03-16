package com.livejournal.uitests.profile.useful.change_profile_parameters;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageLogged;
import com.livejournal.uitests.pages.service_pages.settings.edit_profile.EditProfilePageLogged;
import com.livejournal.uitests.utility.date.RandomDate;
import java.util.ArrayList;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author p.kulich
 */
public class ChangeProfileParameters extends LJTest {

    //Scenario: Change name (1/3)
    //Scenario: Set null to name (1/3)
    //Scenario: Change gender (1/3)
    //Scenario: Change to correct date of birth (1/3)
    @Given("logged user $user on Edit Profile page")
    public void logged_user_on_profile(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(EditProfilePageLogged.class);
        ThucydidesUtils.putToSession("user", user);
    }

    //Scenario: Change name (2/3)
    //Scenario: Set null to name (2/3)
    @When("user enter another name $name on Edit profile page")
    public void user_enter_name(String name) {
        ThucydidesUtils.putToSession("before", onOpened(EditProfilePageLogged.class).getName());
        name = checkString(name);
        onOpened(EditProfilePageLogged.class)
                .setName(name)
                .saveSettings();
        ThucydidesUtils.putToSession("name", name);
    }

    //Scenario: Change gender (2/3)
    @When("user enter another gender $gender on Edit profile page")
    public void user_enter_gender(String gender) {
        gender = gender.substring(0, 1);
        onOpened(EditProfilePageLogged.class)
                .setGender(gender)
                .saveSettings();
    }

    //Scenario: Change to correct date of birth (2/3)
    @When("user $user enter another correct date of birth on Edit profile page")
    public void user_enter_birthday(String user) {

        ThucydidesUtils.putToSession("year", RandomDate.setRandomYear());
        ThucydidesUtils.putToSession("month", RandomDate.setRandomMonth());
        ThucydidesUtils.putToSession("day", RandomDate.setRandomDay());
        if ((getDBDate().profile().getBirthdayPrivacyValue(user)).equals("N")) {
            onOpened(EditProfilePageLogged.class)
                    .setBirthdayPrivacy("F");
        }

        onOpened(EditProfilePageLogged.class)
                .setBirthday(ThucydidesUtils.getFromSession("year").toString(),
                        ThucydidesUtils.getFromSession("month").toString(),
                        ThucydidesUtils.getFromSession("day").toString())
                .saveSettings();
    }

    //Scenario: Change name (3/3)
    @Then("in Profile user see new name $name")
    public void user_see_new_name(String name) {

        String edit_profile_name = onOpened(EditProfilePageLogged.class).getName();

        verify().that(edit_profile_name
                .equals(ThucydidesUtils.getFromSession("name")))
                .ifResultIsExpected("Name " + ThucydidesUtils.getFromSession("name") + " is correct")
                .ifElse("Name " + edit_profile_name + " is not correct.")
                .finish();

        String currentName = open(ProfilePageLogged.class, new Url().setPrefix(ThucydidesUtils
                .getFromSession("user") + "."))
                .getProfileName();
        verify().that(currentName.equals(ThucydidesUtils.getFromSession("name")))
                .ifResultIsExpected("Name " + ThucydidesUtils.getFromSession("name") + " is correct")
                .ifElse("Name " + currentName + " is not correct.")
                .finish();

    }

    //Scenario: Set null to name (3/3)
    @Then("in Profile user see Sticky Error")
    public void show_sticky_error() {
        final String ERROR_MSG = "Your name is a required field. At least provide your first name, or a "
                + "nickname or handle.";
        String edit_profile_name = onOpened(EditProfilePageLogged.class).getName();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        verify().that(onOpened(EditProfilePageLogged.class).getStickyError()
                .equals(ERROR_MSG))
                .ifResultIsExpected(onOpened(EditProfilePageLogged.class)
                        .getStickyError() + " appears")
                .ifElse(onOpened(EditProfilePageLogged.class)
                        .getStickyError() + " doesn't appear")
                .and()
                .that(edit_profile_name
                        .equals(ThucydidesUtils.getFromSession("before")))
                .ifResultIsExpected("Name " + edit_profile_name + " was restored")
                .ifElse("Name " + edit_profile_name + " wasn't restored")
                .finish();

    }

    //Scenario: Change gender (3/3)
    @Then("in Profile user see new gender $gender")
    public void user_see_new_gender(String gender) {
        verify().that(onOpened(EditProfilePageLogged.class).getGender().equals(gender))
                .ifResultIsExpected("Gender " + gender + " is correct")
                .ifElse("Gender " + onOpened(EditProfilePageLogged.class).getGender() + " is incorrect")
                .finish();
    }

    //Scenario: Change to correct date of birth (3/3)
    @Then("in Profile user see new date of birth")
    public void user_see_new_birthday() {
        ArrayList<String> birthday_list = onOpened(EditProfilePageLogged.class)
                .getBirthday();

        verify().that((birthday_list.get(0) + birthday_list.get(1) + birthday_list.get(2))
                .equals(ThucydidesUtils.getFromSession("year").toString()
                        + ThucydidesUtils.getFromSession("month").toString()
                        + ThucydidesUtils.getFromSession("day").toString()))
                .ifResultIsExpected(ThucydidesUtils.getFromSession("year").toString() + " "
                        + ThucydidesUtils.getFromSession("month").toString() + " "
                        + ThucydidesUtils.getFromSession("day").toString() + " is correct date")
                .ifElse(birthday_list.get(0) + " " + birthday_list.get(1) + " " + birthday_list.get(2)
                        + " is incorrect")
                .finish();

    }

    private String checkString(String name) {
        final int MAX_SIZE = 50;
        if (name.equals("rnd_max")) {
            return utility().random().getRandomText(MAX_SIZE);
        } else if (name.equals("rnd_border")) {
            return utility().random().getRandomText(MAX_SIZE - 1);
        } else {
            return name;
        }
    }
}
