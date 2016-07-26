package com.livejournal.uitests.profile.useful.user_can_see_another_profile;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageLogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.edit_profile.EditProfilePageLogged;
import com.livejournal.uitests.utility.date.Date;
import com.livejournal.uitests.utility.date.RandomDate;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

/**
 *
 * @author p.kulich
 */
public class UserCanSeeAnotherProfile extends LJTest {

    //Scenario: Birthday privacy (1/3)
    @Given("logged user $user on Profile page with setting $setting")
    public void logged_user_on_profile_with_setting(String user, String setting) {
        setting = String.valueOf(setting.charAt(0));
        boolean isEqual = getDBDate().profile().getBirthdayPrivacyValue("testautotest").equals(setting);
        boolean isFullPrivacy = getDBDate().profile().getShowBDate(user).equals("F");
        if (!isEqual || !isFullPrivacy || (Date.parseDate(getDBDate().profile()
                .getBirthday(user)).equals("not_full"))) {
            open(LoginPageUnlogged.class)
                    .authorizeBy(user, getDBDate().userData().getUserPassword(user));
            open(EditProfilePageLogged.class)
                    .setBirthday(RandomDate.setRandomYear(), RandomDate.setRandomMonth(),
                            RandomDate.setRandomDay())
                    .setBirthdayPrivacy(setting)
                    .setShowBirthdayPrivacy("F")
                    .setShowBDate("F")
                    .saveSettings()
                    .moveMouseOverMyJournalMenuItem()
                    .clickOnLogOut();
        }
    }

//Scenario: Birthday privacy (2/3)
    @Then("user $user1 can see another user $user birthday")
    public void user_can_see_birthday(String user1, String user) {
        String db_date = Date.parseDate(getDBDate().profile().getBirthday(user))
                .trim();
        String page_date = null;
        boolean isDBequalsPage;
        if (!user1.equals("nobody")) {
            String username = parseUser(user1, user);

            if (!user1.equals("unlogged")) {
                open(LoginPageUnlogged.class)
                        .authorizeBy(username, getDBDate().userData().getUserPassword(username))
                        .defaultLanguageLogged(username);
                page_date = open(ProfilePageLogged.class, new Url().setPrefix(user + "."))
                        .getProfileBirthday()
                        .trim();
                isDBequalsPage = db_date
                        .equals(page_date);
                onOpened(ProfilePageLogged.class)
                        .moveMouseOverMyJournalMenuItem().clickOnLogOut();
            } else {
                console().restartVarnish();
                open(ProfilePageUnlogged.class, new Url().setPrefix(user + ".")).defaultLanguageUnlogged();
                page_date = open(ProfilePageUnlogged.class, new Url().setPrefix(user + "."))
                        .getProfileBirthday()
                        .trim();
                isDBequalsPage = db_date
                        .equals(page_date);
            }

            verify().that(isDBequalsPage)
                    .ifResultIsExpected("Privacy works correctly, birthday is : " + db_date)
                    .ifElse("Privacy works correctly, birthday is : " + page_date)
                    .finish();
        }
    }

    //Scenario: Birthday privacy (3/3)
    @Then("user $user2 can't see another user $user birthday")
    public void user_cant_see_birthday(String user2, String user) {
        boolean isExist = false;
        if (!user2.equals("nobody")) {
            String username = parseUser(user2, user);
            if (!user2.equals("unlogged")) {
                open(LoginPageUnlogged.class
                )
                        .authorizeBy(username, getDBDate().userData().getUserPassword(username))
                        .defaultLanguageLogged(user);
                isExist = !(open(ProfilePageLogged.class, new Url().setPrefix(user + "."))
                        .getBirthdayLabel().equals("Birthdate"));
                verify().that(isExist)
                        .ifResultIsExpected("User " + user2 + " can't see user " + user + " birthday")
                        .ifElse("User " + user2 + " can see user " + user + " birthday")
                        .finish();

            } else {
                console().restartVarnish();
                open(ProfilePageLogged.class, new Url().setPrefix(user + ".")).defaultLanguageUnlogged();
                isExist = !(open(ProfilePageUnlogged.class, new Url().setPrefix(user + "."))
                        .getBirthdayLabel().equals("Birthdate"));
                verify().that(isExist)
                        .ifResultIsExpected("Anonymous " + " can't see user " + user + " birthday")
                        .ifElse("Anonymous" + " can see user " + user + " birthday")
                        .finish();
            }
        }
    }

    public String parseUser(String user, String main_user) {
        switch (user) {
            case "logged":
                return getDBDate().friends().getNotFriend(main_user);
            case "not_friend":
                return getDBDate().friends().getNotFriend(main_user);
            case "friend":
                return getDBDate().friends().getFriend(main_user);
            case "unlogged":
                return "unlogged";
            default:
                Assert.fail("Incorrect argument " + user + " when I parsed user from story");
                return "nobody";
        }
    }

}
