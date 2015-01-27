package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws SQLException {

        System.out.println("!!!!!!!!!!!!! test start");
        String select1 = "select u.user, u.userid, f.friendid from user u "
                + "left join friends f on u.userid = f.userid "
                + "where u.user = 'testautotest';";
        List<ArrayList<String>> ans = this.workWithDB()
                .conect()
                .select(select1, "friendid")
                .finish();
        ArrayList<String> userid = ans.get(0);

        String select2 = "select user, userid from user "
                + "where userid = '" + userid.get(0) + "' ";
        for (int i = 1; i < userid.size(); i++) {
            select2 = select2 + " or userid = '" + userid.get(i) + "'";
        }
        select2 = select2 + " and user like '%test%';";
        System.out.println(select2);

        ArrayList<String> ans2 = this.workWithDB()
                .conect()
                .select(select2, "user")
                .finish()
                .get(0);
        for (int i = 0; i < ans2.size(); i++) {
            System.out.println(ans2.get(i));
        }
        System.out.println("!!!!!!!!!!!!! test stop");

    }
}
