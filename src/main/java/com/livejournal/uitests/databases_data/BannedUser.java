package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class BannedUser extends DatabasesData {

    public String findUserNotInBannedList(String user) {
        String select1 = "Select userid from user where user='" + user + "'";
        String userid = workWithDB().conect()
                .select(select1, "userid")
                .finish()
                .get(0)
                .get(0);
        String select2 = "Select user from user where user like '%test%' and user !='" + user + "'"
                + "and userid not in(select targetid from reluser where type !='B' and userid =" + userid + ") "
                + "and statusvisdate >= adddate(now(), interval - 500 day) limit 100;";
        ArrayList<String> ans = workWithDB().conect()
                .select(select2, "user")
                .finish()
                .get(0);
        return ans.get(new Random().nextInt(ans.size()));
    }

    public String findUserInBannedList(String user) {

        String select1 = "Select userid from user where user='" + user + "'";
        String userid = workWithDB().conect()
                .select(select1, "userid")
                .finish()
                .get(0)
                .get(0);
        String select2 = "select user from user where userid "
                + "in(select targetid from reluser where type='B' and userid=" + userid + ")";
        ArrayList<String> ans = workWithDB().conect()
                .select(select2, "user")
                .finish()
                .get(0);
        return ans.get(new Random().nextInt(ans.size()));
    }

}
