package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import java.util.ArrayList;
import java.util.List;
import org.jbehave.core.annotations.Given;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() throws InterruptedException {

        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");
        String user = "testautotest";
        
        
        System.out.println("!!!!!!!!!!!!!!!!!!!! test1");
        
        
        System.out.println(this.getDBDate().userData().getUserPassword(user));
        
        System.out.println("!!!!!!!!!!!!!!!!!!!! test2");
        String select1 = "select u.user, u.userid, f.friendid from user u "
                + "left join friends f on u.userid = f.userid "
                + "where u.user = '" + user
                + "' and f.friendid>100;";
        String select2 = "SELECT * "
                + "FROM user "
                + "WHERE user='"
                + user
                + "';";
        List<ArrayList<String>> ans = this.workWithDB()
                .conect()
                .select(select1, "friendid")
                .select(select2, "clusterid, userid")
                .finish();
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.println(ans.get(i).get(j));
            }
        }

        
        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");

    }

}
