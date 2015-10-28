package com.livejournal.uitests.databasesData;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

/**
 *
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
                + "WHERE upropid = '402' and userid='"
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
                + "WHERE upropid = '96' and userid = '"
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

    public String getInMyStyleSetting(String user) {

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
                + "WHERE upropid = '175' and userid='"
                + user_atr.get(0).get(1)
                + "';";
        try {
            return workWithDB().conect()
                    .select(select2, "value")
                    .finish()
                    .get(0)
                    .get(0);
        } catch (Exception ex) {
            return "n";
        }
    }

}
