package com.livejournal.uitests.IN_PROGRESS.profile.useful.school_settings;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageLogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.edit_profile.EditProfilePageLogged;
import com.livejournal.uitests.pages.service_pages.settings.school.SchoolsDirectory;
import com.livejournal.uitests.utility.date.Date;
import com.livejournal.uitests.utility.date.RandomDate;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author p.kulich
 */
public class SchoolSettings extends LJTest {

    //Scenario: School privacy (1/4)
    @Given("logged user $user on Profile page")
    public void logged_user_on_edit_profile_page_school(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .setDefault().defaultLanguageLogged(user);
    }

    //Scenario: School privacy (2/4)
    @When("user $user set school setting $setting")
    public void user_set_school_setting(String setting, String user) {
        setting = String.valueOf(setting.charAt(0));
        addSchool(user);
        open(EditProfilePageLogged.class)
                .setSchoolPrivacy(setting)
                .saveSettings()
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
    }

    //Scenario: School privacy (3/4)
    @Then("user $user1 can see $user school")
    public void logged_user_can_see_school(String user1, String user, String setting) {
        getSchoolFromPageWithSecurity(setting, user1, user);
        verify().that(true)
                .ifResultIsExpected("Privacy works correctly, all schools are correct")
                .ifElse("Privacy works incorrect, schools from profile are not equal to" + "schools from DB :" + getDBDate().profile().getFullSchoolInfo(user))
                .finish();
    }

    private void addSchool(String user) {
        if (getDBDate().profile().getSchoolId(user).isEmpty()) {
            String year_start = RandomDate.setRandomYear();
            open(SchoolsDirectory.class, new Url().setPostfix("?year=&ctc=US&cc=Alabaster&sid=1531&sc=AL"))
                    .setSchool();
            open(SchoolsDirectory.class, new Url().setPostfix("manage.bml?ctc=US&cc=Alabaster&sid=1531&authas=" + user))
                    .setYearStart(year_start, "1999")
                    .setYearEnd(setEndYear(year_start), "1999")
                    .saveChanges();
        }
    }

    private void getSchoolFromPageWithSecurity(String setting, String user1, String user) {
        switch (setting) {
            case "Yeverybody": {
                setNeededUser(user, user1);
                ArrayList<String> schools = new ArrayList<String>();
                if (user1.equals("unlogged")) {
                    schools = onOpened(ProfilePageUnlogged.class).getSchoolList();
                } else {
                    schools = onOpened(ProfilePageLogged.class).getSchoolList();
                }
                System.out.println(schools);
                break;
            }
            case "Friends": {
                setNeededUser(user, user1);
                ArrayList<String> schools = onOpened(ProfilePageLogged.class).getSchoolList();
                System.out.println(schools);
                break;
            }
            case "Nobody": {
                setNeededUser(user, user1);
                ArrayList<String> schools = onOpened(ProfilePageLogged.class).getSchoolList();
                if (schools.isEmpty()) {
                    System.out.println("Nobody");
                }
                break;
            }
        }
    }

    private void setNeededUser(String user, String user1) {
        switch (user1) {
            case "unlogged": {
                console().restartVarnish();
                open(ProfilePageUnlogged.class, new Url().setPrefix(user + "."));
                break;
            }
            case "logged": {
                String notFriend = getDBDate().friends().friends().getNotFriend(user);
                open(LoginPageUnlogged.class).authorizeBy(notFriend, getDBDate().userData().getUserPassword(notFriend));
                open(ProfilePageLogged.class, new Url().setPrefix(user + "."));
                break;
            }
            case "friend": {
                String friend = getDBDate().friends().friends().getFriend(user);
                open(LoginPageUnlogged.class).authorizeBy(friend, getDBDate().userData().getUserPassword(friend));
                open(ProfilePageLogged.class, new Url().setPrefix(user + "."));
                break;
            }
            case "nobody": {
                open(LoginPageUnlogged.class).authorizeBy(user, getDBDate().userData().getUserPassword(user));
                open(ProfilePageLogged.class, new Url().setPrefix(user + "."));
                break;
            }
        }
    }
//
//    //Scenario: School privacy (4/4)
//    @Then("Then user $user2 can't see $user school")
//    public void logged_user_cant_see_school(String user2, String user) {
//        boolean isDBequalsPage;
//        ArrayList<String> schoolpg_list = new ArrayList<>();
//        getDBDate().profile().getFullSchoolInfo(user);
//        if (!user2.equals("nobody")) {
//            String username = parseUser(user2, user);
//
//            if (!user2.equals("unlogged")) {
//                open(LoginPageUnlogged.class)
//                        .authorizeBy(username, getDBDate().userData().getUserPassword(username))
//                        .defaultLanguageLogged(username);
//                schoolpg_list = open(ProfilePageLogged.class, new Url().setPrefix(user + "."))
//                        .getSchoolList();
//                isDBequalsPage = isSchoolsEqual(schoolpg_list, user);//сюда впихнуть метод сравнивающий школы
//
//                onOpened(ProfilePageLogged.class)
//                        .moveMouseOverMyJournalMenuItem().clickOnLogOut();
//            } else {
//                open(ProfilePageUnlogged.class, new Url().setPrefix(user + ".")).defaultLanguageUnlogged();
//                schoolpg_list = open(ProfilePageUnlogged.class, new Url().setPrefix(user + "."))
//                        .getSchoolList();
//                isDBequalsPage = isSchoolsEqual(schoolpg_list, user);//сюда вставить метод сравнивающий школы
//
//            }
//
//            verify().that(isDBequalsPage)
//                    .ifResultIsExpected("Privacy works correctly, cant see schools"
//                    )
//                    .ifElse("Privacy works incorrect, schools are shown" + getDBDate().profile()
//                            .getFullSchoolInfo(user)
//                    )
//                    .finish();
//        }
//    }
//    
//    
//    
//    //Scenario: Check incorrect school years (1/3)
//    @Given("logged user $user on Schools Directory page")
//    public void logged_user_on_schools_page(String user) {
//        open(LoginPageUnlogged.class)
//                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
//                .defaultLanguageLogged(user);
//    }
//
//    //Scenario: Check incorrect school years (2/3)
//    @When("user $user set start year $year_start and end year $year_end")
//    public void user_set_years(String user, String year_start, String year_end) {
//        open(SchoolsDirectory.class, new Url().setPostfix("manage.bml?ctc=US&cc=Alabaster&sid=1531&authas=" + user))
//                .setYearStart(parseYear(year_start), "1531")
//                .setYearEnd(setEndYear(parseYear(year_end)), "1531")
//                .saveChanges();
//    }
//
//    //Scenario: School privacy (3/3)
//    @Then("user $user2 can't see $user school")
//    public void user_cant_see_school(String user2, String user) {
//        if (!user2.equals("nobody")) {
//            String username = parseUser(user2, user);
//            if (!user2.equals("unlogged")) {
//                open(LoginPageUnlogged.class
//                )
//                        .authorizeBy(username, getDBDate().userData().getUserPassword(username))
//                        .defaultLanguageLogged(user);
//                verify().that(open(ProfilePageLogged.class, new Url().setPrefix(user + "."))
//                        .getSchoolInfo().equals(""))
//                        .ifResultIsExpected("User " + user2 + " can't see user "
//                                + user + " school")
//                        .ifElse("User " + user2 + " can see user "
//                                + user + " school")
//                        .finish();
//
//            } else {
//                open(ProfilePageLogged.class, new Url().setPrefix(user + ".")).defaultLanguageUnlogged();
//                verify().that(open(ProfilePageUnlogged.class, new Url().setPrefix(user + "."))
//                        .getSchoolInfo().equals(""))
//                        .ifResultIsExpected("Anonymous " + " can't see user "
//                                + user + " school")
//                        .ifElse("Anonymous" + " can see user "
//                                + user + " school")
//                        .finish();
//            }
//        }
//    }
//
//    //Scenario: Check incorrect school years (3/3)
//    @Then("user see alert $alert")
//    public void user_see_alert(String alert) {
//        final String ERR_MSG1 = "Did you really attend this school that long ago?";
//        final String ERR_MSG2 = "Your ending year cannot be earlier than your starting year.";
//        final String ERR_MSG3 = "If you currently attend this school,"
//                + " you should leave the end date field blank or enter \"now\".";
//        String page_alert = onOpened(SchoolsDirectory.class)
//                .getAlertMessage();
//        String error_msg = null;
//        switch (alert) {
//            case "alert_1":
//                error_msg = ERR_MSG1;
//                break;
//            case "alert_2":
//                error_msg = ERR_MSG2;
//                break;
//            case "alert_3":
//                error_msg = ERR_MSG3;
//                break;
//        }
//
//        verify().that(page_alert.equals(error_msg))
//                .ifResultIsExpected(page_alert + " is correct message")
//                .ifElse(error_msg + " is incorrect alert message")
//                .finish();
//    }

    public String setEndYear(String start_year) {
        final int MIN = Integer.valueOf(start_year);
        final int MAX = Date.getCurrentYear();

        int year = MIN + (int) (Math.random() * ((MAX - MIN) + 1));

        return String.valueOf(year);
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

    public String parseYear(String year) {
        final int min = 1900;
        int current_year = Date.getCurrentYear();
        switch (year) {
            case "less_min":
                return String.valueOf((int) (Math.random() * 1900));
            case "min":
                return String.valueOf(min);
            case "rnd_year":
                return RandomDate.setRandomYear();
            case "current_more":
                return String.valueOf(current_year + 1);
            default:
                Assert.fail("Incorrect argument " + year + " when I parsed year from story");
                return "error";
        }
    }

    public String parseSchoolDB(ArrayList<String> school_list) {//преобразовывает список в строку нужного формата
        String school = school_list.get(0) + " - " + school_list.get(1) + ", " + school_list.get(2);
        if (school_list.size() > 3) {
            if (school_list.get(4) != null) {
                school += " ("
                        + school_list.get(3) + " - " + school_list.get(4) + ")";
            } else if (school_list.get(3) != null) {
                school += " ("
                        + school_list.get(3) + " present)";
            }
        }
        return school;
    }

    public boolean isSchoolsEqual(ArrayList<String> schoolpg_list, String user) {

        ArrayList<String> interval_db = new ArrayList<>();
        ArrayList<String> interval_list = new ArrayList<>();
        interval_db = getDBDate().profile().getYearInterval(user);
        interval_list.add(null);
        interval_list.add(null);
        for (int i = 0, j = i; i < 5; i++, j += 2) {
            interval_list.set(0, interval_db.get(j));
            interval_list.set(1, interval_db.get(j + 1));
            if (schoolpg_list.get(i).equals(parseSchoolDB(joinLists(getDBDate().profile()
                    .getSchoolNames(user).get(i), interval_list)))) {
            } else {
                return false;
            }
        }
        return true;
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
