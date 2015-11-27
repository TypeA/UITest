package com.livejournal.uitests.databases_data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class Friends extends DatabasesData {

    public ArrayList<String> getAllFriends(String user) {
        ArrayList<String> friendid = getFriendsId(user);
        String select2 = "select user from user "
                + "where (userid = '" + friendid.get(0) + "' ";
        for (int i = 1; i < friendid.size(); i++) {
            select2 = select2 + " or userid = '" + friendid.get(i) + "'";
        }
        select2 = select2 + ");";
        return workWithDB().conect()
                .select(select2, "user")
                .finish()
                .get(0);
    }

    public String getFriend(String user) {
        ArrayList<String> ans = getAllFriends(user);
        String select = "select user from user "
                + "where (user = '" + ans.get(0) + "' ";
        for (int i = 1; i < ans.size(); i++) {
            select = select + " or user = '" + ans.get(i) + "'";
        }
        select = select + ") and user like '%test%' "
                + "and user !='" + user + "'"
                + "and statusvis = 'V'"
                + "and journaltype = 'P'";
        ans = workWithDB().conect()
                .select(select, "user")
                .finish()
                .get(0);
        ArrayList<String> answer = new ArrayList<String>();
        for (String an : ans) {
            if (!userData().getUserPassword(an).contains("md5:")) {
                answer.add(an);
            }
        }
        return answer.get(new Random().nextInt(ans.size()));
    }

    public ArrayList<String> getNotFriends(String user, Integer limit) {
        ArrayList<String> friendid = getFriendsId(user);
        String select2 = "select user from user "
                + "where (userid != '" + friendid.get(0) + "' ";
        for (int i = 1; i < friendid.size(); i++) {
            select2 = select2 + " and userid != '" + friendid.get(i) + "'";
        }
        select2 = select2 + ") and user like '%test%' "
                + "and statusvis = 'V'"
                + "and journaltype = 'P'"
                + "and statusvisdate >= adddate(now(), interval - 500 day) "
                + "and user !='" + user + "'"
                + "limit " + limit + ";";
        ArrayList<String> ans = workWithDB().conect()
                .select(select2, "user")
                .finish()
                .get(0);
        ArrayList<String> answer = new ArrayList<String>();
        for (String an : ans) {
            if (!userData().getUserPassword(an).contains("md5:")) {
                answer.add(an);
            }
        }
        return answer;
    }

    public String getNotFriend(String user) {
        ArrayList<String> ans = getNotFriends(user, 100);
        return ans.get(new Random().nextInt(ans.size()));
    }

    public List<ArrayList<String>> getAllFriendsInGroups(String user) {

        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        String select1 = "select * from friends "
                + "where userid = "
                + "(select userid from user where user = '" + user + "') "
                + "and groupmask > 1;";
        List<ArrayList<String>> table = workWithDB().conect()
                .select(select1, "friendid")
                .select(select1, "groupmask")
                .finish();
        ans.addAll(table);
        ArrayList<String> usernames = new ArrayList<String>();
        for (int j = 0; j < ans.get(0).size(); j++) {
            String dopselect = "select user from user where userid = '" + ans.get(0).get(j) + "';";
            String username = workWithDB().conect()
                    .select(dopselect, "user")
                    .finish()
                    .get(0)
                    .get(0);
            usernames.add(username);
        }
        ans.set(0, usernames);

        ArrayList<String> groups_list = new ArrayList<String>();

        for (int j = 0; j < ans.get(1).size(); j++) {
            char[] myCharArray = Integer
                    .toBinaryString(Integer.valueOf(ans.get(1).get(j)))
                    .toCharArray();

            String groupsid = "";
            for (int i = 1; i < myCharArray.length; i++) {
                if (myCharArray[i] == '1') {
                    String select3 = "select groupname from lj_c" + userData().getUserClusterId(user) + ".friendgroup2 "
                            + "where userid = (select userid from user where user = '" + user + "') "
                            + "and groupnum = '" + i + "';";
                    String groupname = workWithDB().conect()
                            .select(select3, "groupname")
                            .finish()
                            .get(0)
                            .get(0);
                    groupsid = groupsid + groupname + ";";
                }
            }
            groups_list.add(groupsid);
        }
        ans.set(1, groups_list);
        return ans;
    }

    public String getFriendInGroup(String user) {
        String ans = "";
        ArrayList<String> answer = getAllFriendsInGroups(user).get(0);
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).contains("test")) {
                ans = answer.get(i);
                i = answer.size();
            }
        }
        if (ans.isEmpty()) {
            ans = answer.get(0);
        }
        return ans;
    }

    public ArrayList<String> getFriendInGroup(String user, String group) {
        ArrayList<String> ans = new ArrayList<String>();
        List<ArrayList<String>> answer = getAllFriendsInGroups(user);
        for (int i = 0; i < answer.get(0).size(); i++) {
            if (answer.get(1).get(i).contains(group)) {
                ans.add(answer.get(0).get(i));
            }
        }
        return ans;
    }

    public String getFriendWithoutGroup(String user) {
        String select1 = "select u.user, u.userid, f.friendid from user u "
                + "left join friends f on u.userid = f.userid "
                + "where u.user = '" + user + "' and groupmask = '1';";
        ArrayList<String> friendid = workWithDB().conect()
                .select(select1, "friendid")
                .finish()
                .get(0);
        String select2 = "select user from user "
                + "where (userid = '" + friendid.get(0) + "' ";
        for (int i = 1; i < friendid.size(); i++) {
            select2 = select2 + " or userid = '" + friendid.get(i) + "'";
        }
        select2 = select2 + ") and user like '%test%' "
                + "and statusvis = 'V'"
                + "and journaltype = 'P'";
        ArrayList<String> ans = workWithDB().conect()
                .select(select2, "user")
                .finish()
                .get(0);
        ArrayList<String> answer = new ArrayList<String>();
        for (String an : ans) {
            if (!userData().getUserPassword(an).contains("md5:")) {
                answer.add(an);
            }
        }
        return answer.get(new Random().nextInt(ans.size()));
    }

    public List<ArrayList<String>> getAllGroupsWithParams(String user) {
        String select = "select * from lj_c" + userData().getUserClusterId(user)
                + ".friendgroup2 where userid = (select userid from user where user = '"
                + user + "');";
        return workWithDB().conect()
                .select(select, "groupname")
                .select(select, "sortorder")
                .select(select, "is_public")
                .finish();
    }

    public ArrayList<String> getAllGroups(String user) {
        return getAllGroupsWithParams(user).get(0);
    }

    public ArrayList<String> getPublicGroups(String user) {
        List<ArrayList<String>> all_groups = getAllGroupsWithParams(user);
        ArrayList<String> groups = new ArrayList<String>();
        for (int i = 0; i < all_groups.get(0).size(); i++) {
            if (Integer.valueOf(all_groups.get(2).get(i)) == 1) {
                groups.add(all_groups.get(0).get(i));
            }
        }
        return groups;
    }

    public ArrayList<String> getFriendsInGroup(String user, String group) {
        String select1 = "select * from lj_c" + userData().getUserClusterId(user)
                + ".friendgroup2 where userid = "
                + "(select userid from user where user = '" + user
                + "') and groupname = '" + group
                + "';";
        Integer groupNum = Integer.valueOf(workWithDB().conect()
                .select(select1, "groupnum")
                .finish()
                .get(0)
                .get(0));
        String select2 = "select u.user from friends f "
                + "left join user u on u.userid = f.friendid "
                + "where f.userid = "
                + "(select userid from user where user = '" + user
                + "') and (f.groupmask&1<<" + groupNum
                + "=" + Math.pow(2, groupNum) + ") =1 ;";
        return workWithDB().conect()
                .select(select2, "user")
                .finish()
                .get(0);
    }

    private ArrayList<String> getFriendsId(String user) {
        String select1 = "select u.user, u.userid, f.friendid from user u "
                + "left join friends f on u.userid = f.userid "
                + "where u.user = '" + user + "';";
        return workWithDB().conect()
                .select(select1, "friendid")
                .finish()
                .get(0);
    }

}
