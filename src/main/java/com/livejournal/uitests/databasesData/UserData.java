package com.livejournal.uitests.databasesData;

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

        public Boolean isPaid(String user) {
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
    
}
