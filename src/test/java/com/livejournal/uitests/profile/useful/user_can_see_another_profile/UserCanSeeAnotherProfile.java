package com.livejournal.uitests.profile.useful.user_can_see_another_profile;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageLogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.edit_profile.EditProfilePageLogged;
import com.livejournal.uitests.pages.service_pages.settings.school.SchoolsDirectory;
import com.livejournal.uitests.utility.date.Date;
import com.livejournal.uitests.utility.date.RandomDate;
import java.util.ArrayList;
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

    //Scenario: School privacy (1/3)
    @Given("logged user $user on Profile page with school setting $setting")
    public void logged_user_on_edit_profile_page_school(String user, String setting) {
        setting = String.valueOf(setting.charAt(0));
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .defaultLanguageLogged(user);
        try {
            getDBDate().profile().getSchoolId(user);
        } catch (Exception ex) {

            open(SchoolsDirectory.class, new Url().setPostfix("?year=&ctc=US&cc=Alabaster&sid=1531&sc=AL"))
                    .setSchool();
            open(SchoolsDirectory.class, new Url().setPostfix("manage.bml?ctc=US&cc=Alabaster&sid=1531&authas=" + user))
                    .setYearStart("1993", "1531")
                    .setYearEnd("2005", "1531")
                    .saveChanges();
        }
        open(EditProfilePageLogged.class)
                .setSchoolPrivacy(setting)
                .saveSettings()
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
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
                open(ProfilePageUnlogged.class, new Url().setPrefix(user + ".")).defaultLanguageUnlogged();
                page_date = open(ProfilePageUnlogged.class, new Url().setPrefix(user + "."))
                        .getProfileBirthday()
                        .trim();
                isDBequalsPage = db_date
                        .equals(page_date);
            }

            verify().that(isDBequalsPage)
                    .ifResultIsExpected("Privacy works correctly, birthday is : "
                            + db_date)
                    .ifElse("Privacy works correctly, birthday is : "
                            + page_date)
                    .finish();
        }
    }

    //Scenario: School privacy (2/3)
    @Then("user $user1 can see $user school")
    public void logged_user_can_see_school(String user1, String user) {
        ArrayList<String> yearlist;
        String school_page = null;
        boolean isDBequalsPage;
        try {
            yearlist = getDBDate().profile().getYearInterval("testautotest");
        } catch (NullPointerException ex) {
            yearlist = null;
        }
        String school_db = parseSchoolDB(joinLists(getDBDate().profile()
                .getSchool(user), yearlist));
        if (!user1.equals("nobody")) {
            String username = parseUser(user1, user);

            if (!user1.equals("unlogged")) {
                open(LoginPageUnlogged.class)
                        .authorizeBy(username, getDBDate().userData().getUserPassword(username))
                        .defaultLanguageLogged(username);
                school_page = open(ProfilePageUnlogged.class, new Url().setPrefix(user + "."))
                        .getSchoolInfo();
                isDBequalsPage = school_db
                        .equals(school_page);
                onOpened(ProfilePageLogged.class)
                        .moveMouseOverMyJournalMenuItem().clickOnLogOut();
            } else {
                open(ProfilePageUnlogged.class, new Url().setPrefix(user + ".")).defaultLanguageUnlogged();
                school_page = open(ProfilePageUnlogged.class, new Url().setPrefix(user + "."))
                        .getSchoolInfo();
                isDBequalsPage = school_db
                        .equals(school_page);
            }

            verify().that(isDBequalsPage)
                    .ifResultIsExpected("Privacy works correctly, school is : "
                            + school_db)
                    .ifElse("Privacy works incorrect, school is : "
                            + school_page)
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
                        .ifResultIsExpected("User " + user2 + " can't see user "
                                + user + " birthday")
                        .ifElse("User " + user2 + " can see user "
                                + user + " birthday")
                        .finish();

            } else {
                
                open(ProfilePageLogged.class, new Url().setPrefix(user + ".")).defaultLanguageUnlogged();
                isExist = !(open(ProfilePageUnlogged.class, new Url().setPrefix(user + "."))
                        .getBirthdayLabel().equals("Birthdate"));
                verify().that(isExist)
                        .ifResultIsExpected("Anonymous " + " can't see user "
                                + user + " birthday")
                        .ifElse("Anonymous" + " can see user "
                                + user + " birthday")
                        .finish();
            }
        }
    }

    //Scenario: School privacy (3/3)
    @Then("user $user2 can't see $user school")
    public void user_cant_see_school(String user2, String user) {
        if (!user2.equals("nobody")) {
            String username = parseUser(user2, user);
            if (!user2.equals("unlogged")) {
                open(LoginPageUnlogged.class
                )
                        .authorizeBy(username, getDBDate().userData().getUserPassword(username))
                        .defaultLanguageLogged(user);
                verify().that(open(ProfilePageLogged.class, new Url().setPrefix(user + "."))
                        .getSchoolInfo().equals(""))
                        .ifResultIsExpected("User " + user2 + " can't see user "
                                + user + " school")
                        .ifElse("User " + user2 + " can see user "
                                + user + " school")
                        .finish();

            } else {
                open(ProfilePageLogged.class, new Url().setPrefix(user + ".")).defaultLanguageUnlogged();
                verify().that(open(ProfilePageUnlogged.class, new Url().setPrefix(user + "."))
                        .getSchoolInfo().equals(""))
                        .ifResultIsExpected("Anonymous " + " can't see user "
                                + user + " school")
                        .ifElse("Anonymous" + " can see user "
                                + user + " school")
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

    public String parseSchoolDB(ArrayList<String> school_list) {//преобразовывает список в строку нужного формата
        String school = school_list.get(0) + " - " + school_list.get(1) + ", " + school_list.get(2);
        if (school_list.size() > 3) {
            school += "  ("
                    + school_list.get(3) + " - " + school_list.get(4) + ")";
        }
        return school;
    }

    public static ArrayList<String> joinLists(//объединение двух списков
            final ArrayList<String> listA,
            final ArrayList<String> listB) {

        boolean aEmpty = (listA == null) || listA.isEmpty();
        boolean bEmpty = (listB == null) || listB.isEmpty();
        //побитное И!
        if (aEmpty & bEmpty) {
            return new ArrayList<String>();
        } else if (aEmpty) {
            return new ArrayList<String>(listB);
        } else if (bEmpty) {
            return new ArrayList<String>(listA);
        } else {

            ArrayList<String> result = new ArrayList<String>(
                    listA.size() + listB.size());
            result.addAll(listA);
            result.addAll(listB);
            return result;
        }
    }

}
