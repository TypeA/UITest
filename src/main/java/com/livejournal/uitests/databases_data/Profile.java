package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author p.kulich
 */
public class Profile extends DatabasesData {

    public String getBirthdayPrivacyValue(String user) {
        String select = "select *from userproplist where name='opt_sharebday'";
        String propid = workWithDB().conect()
                .select(select, "upropid")
                .finish()
                .get(0)
                .get(0);
        select = "select * from lj_c" + userData().getUserClusterId(user) + ".userproplite2 where userid = "
                + userData().getUserId(user) + " and upropid = " + propid;
        return workWithDB().conect()
                .select(select, "value")
                .finish()
                .get(0)
                .get(0);

    }

    public String getShowBDate(String user) {
        String select = "select *from userproplist where name='opt_showbday'";
        String propid = workWithDB().conect()
                .select(select, "upropid")
                .finish()
                .get(0)
                .get(0);
        select = "select * from lj_c" + userData().getUserClusterId(user) + ".userproplite2 where userid = "
                + userData().getUserId(user) + " and upropid = " + propid;
        return workWithDB().conect()
                .select(select, "value")
                .finish()
                .get(0)
                .get(0);
    }

    public String getBirthday(String user) {
        String select = "select* from user where user='" + user + "'";
        return workWithDB().conect()
                .select(select, "bdate")
                .finish()
                .get(0)
                .get(0);
    }

    public List<ArrayList<String>> getSchoolNames(String user) {
        String select = "select * from schools sc inner join lj_c"
                + userData().getUserClusterId(user) + ".user_schools us on " + "us.schoolid=sc.schoolid where userid=" + userData().getUserId(user)
                + " order by year_start";
        return workWithDB().conect()
                .select(select, "name")
                .finish();
    }

    public ArrayList<String> getYearInterval(String user) {
        ArrayList<String> year_interval = new ArrayList<String>();
        String select = "select userid from user where user='" + user + "'";
        String userid = workWithDB().conect()
                .select(select, "userid")
                .finish()
                .get(0)
                .get(0);
        select = "select* from lj_c" + userData().getUserClusterId(user) + ".user_schools where userid=" + userid
                + " order by year_start";

        year_interval = workWithDB().conect()
                .select(select, "year_start, year_end")
                .finish()
                .get(0);
        return year_interval;
    }

    public List<ArrayList<String>> getFullSchoolInfo(String user) {
        String select = "select userid from user where user='" + user + "'";
        String userid = workWithDB().conect()
                .select(select, "userid")
                .finish()
                .get(0)
                .get(0);
        select = "select *  from schools sc inner join lj_c"
                + userData().getUserClusterId(user) + ".user_schools us on  "
                + "us.schoolid=sc.schoolid where userid=" + userid
                + " order by year_start";
        return workWithDB().conect()
                .select(select, "name, country, state, city, year_start, year_end")
                .finish();
    }

    public ArrayList<String> getRandomSchoolList() {
        String select = "select * from schools where country='US' and city = 'New York' limit 10";
        return workWithDB().conect()
                .select(select, "schoolid")
                .finish()
                .get(0);
    }

    public ArrayList<String> getSchoolId(String user) {
        String select = "select userid from user where user='" + user + "'";
        String userid = workWithDB().conect()
                .select(select, "userid")
                .finish()
                .get(0)
                .get(0);
        select = "select* from lj_c" + userData().getUserClusterId(user) + ".user_schools where userid=" + userid
                + " order by year_start";
        return workWithDB().conect()
                .select(select, "schoolid")
                .finish()
                .get(0);
    }

}
