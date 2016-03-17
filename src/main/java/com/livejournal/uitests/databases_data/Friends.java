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
        select = select + ")"
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
        return answer.get(new Random().nextInt(answer.size()));
    }

    public ArrayList<String> getAllNotFriends(String user, Integer limit) {
        ArrayList<String> friendid = getFriendsId(user);
        String select2 = "select user from user "
                + "where (userid != '" + friendid.get(0) + "' ";
        for (int i = 1; i < friendid.size(); i++) {
            select2 = select2 + " and userid != '" + friendid.get(i) + "'";
        }
        select2 = select2 + ")"
                + "and statusvis = 'V'"
                + "and journaltype = 'P'"
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
        ArrayList<String> ans = getAllNotFriends(user, 100);
        return ans.get(new Random().nextInt(ans.size()));
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
        return answer.get(new Random().nextInt(answer.size()));
    }

    public ArrayList<String> getAllGroups(String user) {
        return getAllGroupsWithParams(user).get(0);
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

    public ArrayList<String> getAllPublicGroups(String user) {
        List<ArrayList<String>> all_groups = getAllGroupsWithParams(user);
        ArrayList<String> groups = new ArrayList<String>();
        for (int i = 0; i < all_groups.get(0).size(); i++) {
            if (Integer.valueOf(all_groups.get(2).get(i)) == 1) {
                groups.add(all_groups.get(0).get(i));
            }
        }
        return groups;
    }

    public ArrayList<String> getAllFriendsInGroup(String user, String group) {
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

    public String getFriendInGroup(String user, String group) {
        String ans = "";
        ArrayList<String> answer = getAllFriendsInGroup(user, group);
        int fl = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).contains("test")) {
                fl = i;
                String pass = getUserPassword(user);
                if (!pass.contains("md5:")) {
                    ans = answer.get(i);
                    i = answer.size();
                }
            }
        }
        if (ans.isEmpty()) {
            ans = answer.get(fl);
        }
        return ans;
    }

    public ArrayList<String> getAllFllowers(String user) {
        String select = "select u.user, f.userid, f.friendid from friends f "
                + "left join user u "
                + "on f.userid=u.userid "
                + "where f.friendid = (select userid from user where user = '"
                + user + "');";
        return workWithDB().conect()
                .select(select, "user")
                .finish()
                .get(0);
    }

    public String getFollower(String user) {
        String select = "select u.user, p.password, f.userid, f.friendid "
                + "from friends f "
                + "left join user u "
                + "on f.userid=u.userid "
                + "left join password p "
                + "on u.userid = p.userid "
                + "where f.friendid = (select userid from user where user = '"
                + user + "') "
                + "and p.password != '' "
                + "and p.password not like 'md5:%' "
                + "and u.user != '" + user + "'"
                + "and u.user like '%test%';";
        return workWithDB().conect()
                .select(select, "user")
                .finish()
                .get(0)
                .get(0);
    }

    public String getNotFollower(String user) {
        String select1 = "select u.user from user u "
                + "left join password p on u.userid = p.userid "
                + "where p.password != ''"
                + "and p.password not like 'md5:%' "
                + "and u.user != '" + user + "'  "
                + "and u.statusvis = 'V' "
                + "and u.journaltype = 'P' "
                + "and u.statusvisdate >= adddate(now(), interval - 500 day)";
        ArrayList<String> all_users = workWithDB().conect()
                .select(select1, "user")
                .finish()
                .get(0);
        all_users.removeAll(getAllFllowers(user));
        return all_users.get(0);
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

    private String getUserPassword(String user) {
        String select = "SELECT user.userid, user.user, password.password "
                + "FROM user "
                + "LEFT JOIN password "
                + "ON user.userid=password.userid "
                + "WHERE user.user = '" + user + "' ";
        return workWithDB().conect()
                .select(select, "password")
                .finish().get(0).get(0);
    }

}
