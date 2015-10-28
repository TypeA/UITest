package com.livejournal.uitests.databasesData;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class Community extends DatabasesData {

    private ArrayList<String> findUserInCommunity(String community, String type) {
        String select = "select r.targetid from user u left join reluser r on "
                + "u.userid=r.userid where u.user = '" + community + "' and r.type='" + type + "';";
        ArrayList<String> targetid = workWithDB().conect()
                .select(select, "targetid")
                .finish()
                .get(0);
        ArrayList<String> user = new ArrayList<String>();
        for (String targetid1 : targetid) {
            String select2 = "Select user from user where userid = " + targetid1;
            String ans = workWithDB().conect()
                    .select(select2, "user")
                    .finish()
                    .get(0)
                    .get(0);
            user.add(ans);
        }
        return user;
    }

    public String findMaintainerInComminuty(String community) {
        ArrayList<String> users = findUserInCommunity(community, "A");
        return users.get(new Random().nextInt(users.size()));
    }

    public ArrayList<String> findMembersInCommunity(String community) {
        String select = "select user from user where userid = "
                + "(select userid from friends where friendid = "
                + "(select userid as comm from user where user='" + community + "')and userid "
                + "not in (select targetid from reluser where userid =friendid))";
        return workWithDB().conect()
                .select(select, "user")
                .finish()
                .get(0);
    }

    public String findMemberInCommunityNotInGroup(String community) {
        String select = "select friendid from friends where userid="
                + "(select userid from user where user='" + community + "') and "
                + "friendid not in(select targetid from reluser where "
                + "userid=(select userid from user where user='" + community + "')) and groupmask=1";
        ArrayList<String> ans = workWithDB().conect()
                .select(select, "friendid")
                .finish()
                .get(0);
        ArrayList<String> users = new ArrayList<String>();
        for (String an : ans) {
            String select2 = "Select user from user where userid = " + an;
            String ans1 = workWithDB().conect()
                    .select(select2, "user")
                    .finish()
                    .get(0)
                    .get(0);
            users.add(ans1);
        }
        return users.get(new Random().nextInt(users.size()));
    }

}
