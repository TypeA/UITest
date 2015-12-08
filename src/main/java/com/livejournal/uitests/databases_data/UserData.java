package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.prytkova
 */
public class UserData extends DatabasesData {

    public String getUserPassword(String user) {
        String select = "SELECT user.userid, user.user, password.password "
                + "FROM user "
                + "LEFT JOIN password "
                + "ON user.userid=password.userid "
                + "WHERE user.user = '" + user + "' ";
        return workWithDB().conect()
                .select(select, "password")
                .finish().get(0).get(0);
    }

    public Boolean getUserPaidType(String user) {
        String select1 = "SELECT caps & 1<<3 = 8 as paid, caps & 1<<4=16 as perm "
                + "FROM user "
                + "WHERE user='"
                + user
                + "';";
        List<ArrayList<String>> paid = workWithDB().conect()
                .select(select1, "paid, perm")
                .finish();
        return "1".equals(paid.get(0).get(0)) || "1".equals(paid.get(0).get(1));
    }

    public String getUserType(String user) {
        String select = "select user, journaltype from user where user='" + user + "';";
        String type = workWithDB().conect()
                .select(select, "journaltype")
                .finish()
                .get(0)
                .get(0);
        if (type.equals("P")) {
            return "journal";
        }
        if (type.equals("C")) {
            return "community";
        } else {
            return "unknown";
        }
    }

    public String getUserId(String user) {
        String select = "Select userid from user where user='" + user + "'";
        return workWithDB().conect()
                .select(select, "userid")
                .finish()
                .get(0)
                .get(0);
    }

    public String getUserClusterId(String user) {
        String select = "select clusterid from user where user='" + user + "'";
        return workWithDB().conect()
                .select(select, "clusterid")
                .finish().get(0).get(0);
    }

}
