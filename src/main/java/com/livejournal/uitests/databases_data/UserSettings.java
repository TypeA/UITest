package com.livejournal.uitests.databases_data;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author m.prytkova
 */
public class UserSettings extends DatabasesData {

    public String getCyrSetting(String user) {
        String select1 = "SELECT caps "
                + "FROM user "
                + "WHERE user='"
                + user
                + "';";
        String caps = workWithDB().conect()
                .select(select1, "caps")
                .finish()
                .get(0)
                .get(0);
        switch (Integer.valueOf(caps) & 1024) {
            case 0:
                return "NONCYR";
            case 1024:
                return "CYR";
            default:
                Assert.assertTrue("Unknown user type", false);
                return "Unknown user type";
        }
    }

    public Boolean getAdaptiveSetting(String user) {
        String select1 = "SELECT * "
                + "FROM user "
                + "WHERE user='"
                + user
                + "';";
        List<ArrayList<String>> user_atr = workWithDB().conect()
                .select(select1, "clusterid, userid")
                .finish();
        String select2 = "SELECT value "
                + "FROM lj_c"
                + user_atr.get(0).get(0)
                + ".userproplite2 "
                + "WHERE upropid = (select upropid from userproplist where name =''cust_mobile_adaptive') and userid='"
                + user_atr.get(0).get(1)
                + "';";
        try {
            return "1".equals(workWithDB().conect()
                    .select(select2, "value")
                    .finish()
                    .get(0)
                    .get(0));
        } catch (Exception ex) {
            return false;
        }
    }

    public String getStyle(String user) {
        String select1 = "SELECT * "
                + "FROM user "
                + "WHERE user='"
                + user
                + "';";
        List<ArrayList<String>> user_atr = workWithDB().conect()
                .select(select1, "clusterid, userid")
                .finish();
        String select2 = "SELECT * "
                + "FROM lj_c"
                + user_atr.get(0).get(0)
                + ".userproplite2 "
                + "WHERE upropid = (select upropid from userproplist where name ='s2_style') and userid = '"
                + user_atr.get(0).get(1)
                + "';";
        String styleid = workWithDB().conect()
                .select(select2, "value")
                .finish()
                .get(0)
                .get(0);
        String select3 = "SELECT name "
                + "FROM s2styles "
                + "WHERE userid= '"
                + user_atr.get(0).get(1)
                + "' and styleid = '" + styleid + "';";
        return workWithDB().conect()
                .select(select3, "name")
                .finish()
                .get(0)
                .get(0);
    }

    public boolean getInMyStyleSetting(String user) {
        String select1 = "SELECT * "
                + "FROM user "
                + "WHERE user='"
                + user
                + "';";
        List<ArrayList<String>> user_atr = workWithDB().conect()
                .select(select1, "clusterid, userid")
                .finish();
        String select2 = "SELECT value "
                + "FROM lj_c"
                + user_atr.get(0).get(0)
                + ".userproplite2 "
                + "WHERE upropid = (select upropid from userproplist where name = 'opt_stylealwaysmine') and userid='"
                + user_atr.get(0).get(1)
                + "';";
        try {
             String setting = workWithDB().conect()
                    .select(select2, "value")
                    .finish()
                    .get(0)
                    .get(0);
             return setting.equals("Y");
        } catch (Exception ex) {
            return false;
        }
    }

    public String getFeedPaging(String user, String setting) {
        String prop_name = "";
        if (setting.toUpperCase().equals("TYPE")) {
            prop_name = "friendsfeed_paging_type";
        }
        if (setting.toUpperCase().equals("SIZE")) {
            prop_name = "friendsfeed_page_size";
        }

        String select1 = "SELECT * "
                + "FROM user "
                + "WHERE user='"
                + user + "';";
        List<ArrayList<String>> user_atr = workWithDB().conect()
                .select(select1, "clusterid, userid")
                .finish();

        String select2 = "select * from lj_c" + user_atr.get(0).get(0) + ".userproplite2 "
                + "where upropid="
                + "(select upropid from userproplist "
                + "where name = '" + prop_name + "') "
                + "and userid = " + user_atr.get(0).get(1) + ";";

        return workWithDB().conect()
                .select(select2, "value")
                .finish()
                .get(0)
                .get(0);
    }

    public ArrayList<String> getUsersWithCustomFeed() {
        String select = "(select u.user, c.userid from lj_c2.userproplite2 c"
                + "left join user u on c.userid = u.userid"
                + "where c.upropid = (select upropid from userproplist where name='friendsfeed_style') "
                + "and c.value not like '%242F33%00A3D9%007399%0086B3%FFFFFF%242F33%7A9199%DAE3E6%F8F9FB%'"
                + "and u.statusvis = 'V')"
                + "UNION "
                + "(select u.user, c.userid from lj_c1.userproplite2 c"
                + "left join user u on c.userid = u.userid"
                + "where c.upropid = 327 "
                + "and c.value not like '%242F33%00A3D9%007399%0086B3%FFFFFF%242F33%7A9199%DAE3E6%F8F9FB%'"
                + "and u.statusvis = 'V' )";

        return workWithDB().conect()
                .select(select, "user")
                .finish()
                .get(0);
    }

    public boolean getAllowForMedius(String user) {
        String select = "select upropid from userproplist where name='allow_for_magazine";
        String idSetting = workWithDB().conect()
                .select(select, "upropid")
                .finish()
                .get(0)
                .get(0);
        String clusterid = userData().getUserClusterId(user);
        String userid = userData().getUserId(user);
        String select1 = "select value from lj_c" + clusterid + ".userproplite2 where upropid=" + idSetting + " and userid = " + userid;
        String valueSetting = workWithDB().conect()
                .select(select1, "value")
                .finish()
                .get(0)
                .get(0);
        if (valueSetting.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

}
