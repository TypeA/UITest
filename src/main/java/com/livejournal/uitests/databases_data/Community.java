package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class Community extends DatabasesData {
    
    public ArrayList<String> getAllMaintainers(String community) {
        String select = "select u.user, r.targetid, r.type from user u "
                + "left join reluser r on "
                + "u.userid=r.userid where u.user = '"
                + community + "' and r.type='A';";
        ArrayList<String> users = workWithDB().conect()
                .select(select, "targetid")
                .finish()
                .get(0);
        String dop = "";
        for (int i = 1; i < users.size(); i++) {
            dop = dop + " or userid=" + users.get(i);
        }
        String select2 = "select user from user"
                + " where (userid = "
                + users.get(0) + dop + ");";
        return workWithDB().conect()
                .select(select2, "user")
                .finish()
                .get(0);
    }
    
    public String getMaintainer(String community) {
        ArrayList<String> users = getAllMaintainers(community);
        return users.get(new Random().nextInt(users.size()));
    }
    
    public ArrayList<String> getAllMembers(String community) {
        return this.friends().getAllFriends(community);
    }
    
    public String getMember(String community) {
        ArrayList<String> allMembers = getAllMembers(community);
        ArrayList<String> allMaintainers = getAllMaintainers(community);
        allMembers.removeAll(allMaintainers);
        return allMembers.get(new Random().nextInt(allMembers.size()));
    }
    
    public String getNotMember(String community) {
        return this.friends().getNotFriend(community);
    }
    
    public String getMemberInGroup(String community, String group) {
        return this.friends().getFriendInGroup(community, group);
    }

    public String getMemberNotInGroup(String community) {
        return this.friends().getFriendWithoutGroup(community);
    }
    
}
