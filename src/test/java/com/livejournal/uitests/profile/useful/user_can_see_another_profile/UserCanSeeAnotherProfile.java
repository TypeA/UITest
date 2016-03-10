package com.livejournal.uitests.profile.useful.user_can_see_another_profile;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageLogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.edit_profile.EditProfilePageLogged;
import java.util.Calendar;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author p.kulich
 */
public class UserCanSeeAnotherProfile extends LJTest {

    //Scenario: Birthday privacy (1/3)
    //Scenario: School privacy (1/3)
    //Scenario: Show email (1/3)
    //Scenario: Show list of friends (1/3)
    @Given("logged user $user on Profile page with setting $setting")
    public void logged_user_on_profile_with_setting(String user, String setting) {
        boolean isEqual = getDBDate().profile().getBirthdayPrivacyValue("testautotest").equals(setting);
        boolean isFullPrivacy = getDBDate().profile().getShowBDate(user).equals("F");

        ThucydidesUtils.putToSession(String.valueOf(isEqual), "isEqual");
        if (!isEqual || !isFullPrivacy) {
            open(LoginPageUnlogged.class)
                    .authorizeBy(user, getDBDate().userData().getUserPassword(user));
            open(EditProfilePageLogged.class)
                    .setBirthdayPrivacy(setting)
                    .setShowBirthdayPrivacy("F")
                    .setShowBDate("F")
                    .saveSettings()
                    .moveMouseOverMyJournalMenuItem().clickOnLogOut();

        }

    }

    //Scenario: Birthday privacy (2/3)
    @Then("user $user1 can see another user $user birthday")
    public void user_can_see_birthday(String user1, String user) {
//        
        System.out.println("!!!!!!!!!!!!!! ENTER STEP 2");
//        
        if (!user1.equals("null")) {
            if (parseUser(user1)) {
                verify().that(parseDate(getDBDate().profile().getBirthday(user))
                        .equals(open(ProfilePageLogged.class, new Url().setPrefix(user)).getProfileBirthday()))
                        .ifResultIsExpected("Privacy work's correctly, birthday is : "
                                + parseDate(getDBDate().profile().getBirthday(user)))
                        .ifElse("Privacy work's correctly, birthday is : "
                                + open(ProfilePageLogged.class, new Url().setPrefix(user)).getProfileBirthday())
                        .finish();
            } else {
                verify().that(parseDate(getDBDate().profile().getBirthday(user))
                        .equals(open(ProfilePageUnlogged.class, new Url().setPrefix(user)).getProfileBirthday()))
                        .ifResultIsExpected("Privacy work's correctly, birthday is : "
                                + parseDate(getDBDate().profile().getBirthday(user)))
                        .ifElse("Privacy work's correctly, birthday is : "
                                + open(ProfilePageLogged.class, new Url().setPrefix(user)).getProfileBirthday())
                        .finish();
            }

        }

    }

    //Scenario: Birthday privacy (3/3)
    @Then("user $user2 can't see another user $user birthday")
    public void user_cant_see_birthday(String user2, String user) {
        //        
        System.out.println("!!!!!!!!!!!!!! ENTER STEP 3");
//        
        if (!user2.equals("null")) {
            if (parseUser(user2)) {
                verify().that(open(ProfilePageLogged.class, new Url().setPrefix(user))
                        .isBirthdayVisible())
                        .ifResultIsExpected("User " + user2 + " can't see user "
                                + user + " birthday")
                        .ifElse("User " + user2 + " can see user "
                                + user + " birthday")
                        .finish();

            } else {

                verify().that(open(ProfilePageUnlogged.class, new Url().setPrefix(user))
                        .isBirthdayVisible())
                        .ifResultIsExpected("Anonymous " + " can't see user "
                                + user + " birthday")
                        .ifElse("Anonymous" + " can see user "
                                + user + " birthday")
                        .finish();
            }
        }
    }

    public boolean parseUser(String user) { // True - logged, False - unlogged
        String username = null;
        System.out.println("-----------++++++++---+++++++ " + user);
        switch (user) {
            case "logged":
            case "not_friend":
                username = getDBDate().friends().getNotFriend(user);
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " +username
                + " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                break;
            case "unlogged":
//	    Nothing happens
                return false;
            case "friend":
                username = getDBDate().friends().getFriend(user);
                break;
            default:
                Assert.fail("Incorrect argument");

        }
        open(LoginPageUnlogged.class
        )
                .authorizeBy(username, getDBDate().userData().getUserPassword(username))
                .defaultLanguageLogged(user);
        return true;
    }

    public static String parseDate(String date) {
        String[] mas = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "December"};
        String[] buf = date.split("-");
        return buf[2] + " " + mas[Integer.valueOf(buf[1]) - 1] + " " + buf[0];
    }

}
