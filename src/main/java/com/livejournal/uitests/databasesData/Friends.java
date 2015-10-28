package com.livejournal.uitests.databasesData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class Friends extends DatabasesData {

    public ArrayList<String> findAllFriends(String user) {
        String select1 = "select u.user, u.userid, f.friendid from user u "
                + "left join friends f on u.userid = f.userid "
                + "where u.user = '" + user + "';";
        ArrayList<String> friendid = workWithDB().conect()
                .select(select1, "friendid")
                .finish()
                .get(0);
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

    public String findFriend(String user) {
        ArrayList<String> ans = findAllFriends(user);
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

    public ArrayList<String> findNotFriends(String user, Integer limit) {
        String select1 = "select u.user, u.userid, f.friendid from user u "
                + "left join friends f on u.userid = f.userid "
                + "where u.user = '" + user + "';";
        ArrayList<String> friendid = workWithDB().conect()
                .select(select1, "friendid")
                .finish()
                .get(0);
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

    public String findNotFriend(String user) {
        ArrayList<String> ans = findNotFriends(user, 100);
        return ans.get(new Random().nextInt(ans.size()));
    }

    public List<ArrayList<String>> findAllFriendsInGroups(String user) {

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

        String dop_script = "select clusterid, user from user "
                + "where user = '" + user + "';";
        String clusterid = workWithDB().conect()
                .select(dop_script, "clusterid")
                .finish()
                .get(0)
                .get(0);

        for (int j = 0; j < ans.get(1).size(); j++) {
            char[] myCharArray = Integer
                    .toBinaryString(Integer.valueOf(ans.get(1).get(j)))
                    .toCharArray();

            String groupsid = "";
            for (int i = 1; i < myCharArray.length; i++) {
                if (myCharArray[i] == '1') {
                    String select3 = "select groupname from lj_c" + clusterid + ".friendgroup2 "
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

    public String findFriendInGroup(String user) {
        String ans = "";
        ArrayList<String> answer = findAllFriendsInGroups(user).get(0);
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

    public ArrayList<String> findFriendInGroup(String user, String group) {
        ArrayList<String> ans = new ArrayList<String>();
        List<ArrayList<String>> answer = findAllFriendsInGroups(user);
        for (int i = 0; i < answer.get(0).size(); i++) {
            if (answer.get(1).get(i).contains(group)) {
                ans.add(answer.get(0).get(i));
            }
        }
        return ans;
    }

    public String findFriendWithoutGroup(String user) {
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

}
