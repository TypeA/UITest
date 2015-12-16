package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class Community extends DatabasesData {

    public String findMaintainerInComminuty(String community) {
        ArrayList<String> users = targetIdWithParams(community, "A").get(0);
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

    private List<ArrayList<String>>
            targetIdWithParams(String community, String type) {
        String select = "select r.targetid, r.type from user u left join reluser r on "
                + "u.userid=r.userid where u.user = '"
                + community + "' and r.type='" + type + "';";
        return workWithDB().conect()
                .select(select, "targetid")
                .finish();
    }

}
