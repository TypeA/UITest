package com.livejournal.uitests.databases_data;

import java.util.ArrayList;

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

    public ArrayList<String> getSchool(String user) {
        
        String school_id = getSchoolId(user);
        String select = "select * from schools where schoolid=" + school_id;
        return workWithDB().conect()
                .select(select, "name, city, state")
                .finish()
                .get(0);

    }
    
    public String getSchoolId(String user) {
        String select = "select userid from user where user='" + user + "'";
        String userid = workWithDB().conect()
                .select(select, "userid")
                .finish()
                .get(0)
                .get(0);
        select = "select* from lj_c" + userData().getUserClusterId(user) + ".user_schools where userid=" + userid;
        return workWithDB().conect()
                .select(select, "schoolid")
                .finish()
                .get(0)
                .get(0);
        
    }

    public ArrayList<String> getYearInterval(String user) {
        String select = "select userid from user where user='" + user + "'";
        String userid = workWithDB().conect()
                .select(select, "userid")
                .finish()
                .get(0)
                .get(0);
        select = "select* from lj_c" + userData().getUserClusterId(user) + ".user_schools where userid=" + userid;

        ArrayList<String> year_interval = workWithDB().conect()
                .select(select, "year_start, year_end")
                .finish()
                .get(0);
        System.out.println("+++++ " + year_interval.get(0));
        if (year_interval.get(0).equals("")) {
            return null;
        } else {
            return year_interval;
        }
    }
}
