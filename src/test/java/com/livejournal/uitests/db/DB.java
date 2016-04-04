package com.livejournal.uitests.db;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageLogged;
import static com.livejournal.uitests.profile.useful.school_settings.SchoolSettings.joinLists;
import com.livejournal.uitests.utility.date.Date;
import java.util.ArrayList;
import java.util.Random;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {
        System.out.println("START TEST +++++++++++++++++++++++++++++++");
       getDBDate().profile().getFullSchoolInfo("testautotest");
        System.out.println("STOP TEST +++++++++++++++++++++++++++++++");

    }

    public boolean isSchoolsEqual(String user) {
        ArrayList<String> schoolpg_list = new ArrayList<>();
        schoolpg_list = open(ProfilePageLogged.class, new Url().setPrefix(user + "."))
                .getSchoolList();
        ArrayList<String> interval_db = new ArrayList<>();
        ArrayList<String> interval_list = new ArrayList<>();
        interval_db = getDBDate().profile().getYearInterval(user);
        interval_list.add(null);
        interval_list.add(null);
        for (int i = 0, j = i; i < 5; i++, j += 2) {
            interval_list.set(0, interval_db.get(j));
            interval_list.set(1, interval_db.get(j + 1));
            if (schoolpg_list.get(i).equals(parseSchoolDB(joinLists(getDBDate().profile()
                    .getSchool(user).get(i), interval_list)))) {
                System.out.println("TRUEEE");
            } else {
                System.out.println("FAAALSEEEE");
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> get4UsSchools(ArrayList<String> list) {//возвращаю список в котором 4 рандомных schoolid
        ArrayList<String> new_list = new ArrayList<>();
        Random random = new Random();
        System.out.println(list);
        int index = 0;
        for (int i = 0; i < 4; i++) {
            index = random.nextInt(list.size());
            System.out.println(index);
            new_list.add(list.get(index));
            list.remove(index);
        }
        return new_list;
    }

    public String setEndYear(String start_year) {
        final int MIN = Integer.valueOf(start_year);
        final int MAX = Date.getCurrentYear();

        int year = MIN + (int) (Math.random() * ((MAX - MIN) + 1));

        return String.valueOf(year);
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

}
