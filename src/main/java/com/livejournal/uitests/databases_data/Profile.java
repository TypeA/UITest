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

    public List<ArrayList<String>> getSchool(String user) {// создает список школьных айдишников для одного юзера

        ArrayList<String> school_id = getSchoolId(user);
        List<ArrayList<String>> school_list = new ArrayList<ArrayList<String>>();
        
        String select = null;

        for (int i = 0; i < school_id.size(); i++) {
            select = "select * from schools where schoolid=" + school_id.get(i);
           school_list.add(workWithDB().conect()
                .select(select, "name, city, state")
                .finish()
                .get(0));
        }
        /*
        select = "select * from schools where schoolid=" + school_id;
        return workWithDB().conect()
                .select(select, "name, city, state")
                .finish()
                .get(0);
        */
        return school_list;
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
//                .get(0);

    }

    public ArrayList<String>getYearInterval(String user) {
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
        /*if (year_interval.get(0).equals("")) {
            return null;
        } else {
            return year_interval;
        }*/
    }
}
