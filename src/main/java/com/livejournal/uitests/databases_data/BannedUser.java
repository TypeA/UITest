package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class BannedUser extends DatabasesData {
    
    public ArrayList<String> getAllUserNotInBannedList(String user) {
        String select1 = "Select userid from user where user='" + user + "'";
        String userid = workWithDB().conect()
                .select(select1, "userid")
                .finish()
                .get(0)
                .get(0);
        String select2 = "Select user from user "
                + "where user like '%test%' "
                + "and user !='" + user + "'"
                + "and status != 'N'"
                + "and userid not in"
                + "(select targetid from reluser where type !='B' "
                + "and userid =" + userid + ") "
                + "and statusvisdate >= adddate(now(), interval - 500 day) limit 100;";
        return workWithDB().conect()
                .select(select2, "user")
                .finish()
                .get(0);
    }

    public String getUserNotInBannedList(String user) {
        ArrayList<String> ans = getAllUserNotInBannedList(user) ;
        return ans.get(new Random().nextInt(ans.size()));
    }

    public ArrayList<String> getAllUserInBannedList(String user) {
        String select1 = "Select userid from user where user='" + user + "'";
        String userid = workWithDB().conect()
                .select(select1, "userid")
                .finish()
                .get(0)
                .get(0);
        String select2 = "select user from user where "
                + "status != 'N' and userid in"
                + "(select targetid from reluser where type='B' and userid=" + userid + ")";
        ArrayList<String> ans = workWithDB().conect()
                .select(select2, "user")
                .finish()
                .get(0);
        return ans;
    }

    public String getUserInBannedList(String user) {
        ArrayList<String> ans = getAllUserInBannedList(user);
        return ans.get(new Random().nextInt(ans.size()));
    }

}
