package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class Community extends DatabasesData {

    public String findMaintainerInComminuty(String community) {
        String select = "select r.targetid, r.type from user u left join reluser r on "
                + "u.userid=r.userid where u.user = '"
                + community + "' and r.type='A';";
        ArrayList<String> users = workWithDB().conect()
                .select(select, "targetid")
                .finish()
                .get(0);
        return users.get(new Random().nextInt(users.size()));
    }

    public ArrayList<String> findAllMembersInCommunity(String community) {
        String select = "select f.friendid, u.user from friends f"
                + "left join user u"
                + "on f.friendid = u.userid"
                + "where f.userid = "
                + "(select userid from user where user = '" + community + "');";
        return workWithDB().conect()
                .select(select, "user")
                .finish()
                .get(0);
    }

    public String findMemberInCommunityNotInGroup(String community) {
        String select = "select f.userid, f.friendid, u.user, f.groupmask "
                + "from friends f "
                + "left join user u on f.friendid = u.userid "
                + "where f.userid = "
                + "(select userid from user where user = '" + community + "') "
                + "and f.groupmask = 1;";
        ArrayList<String> users = workWithDB().conect()
                .select(select, "user")
                .finish()
                .get(0);
        return users.get(new Random().nextInt(users.size()));
    }

}
