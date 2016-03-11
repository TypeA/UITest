package com.livejournal.uitests.databases_data;


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
        return  workWithDB().conect()
                .select(select, "bdate")
                .finish()
                .get(0)
                .get(0);
    }
}
