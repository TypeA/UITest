package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws SQLException {

   /*     System.out.println("!!!!!!!!!!!!! test start");

        List<ArrayList<String>> ans = workWithDB().findAllFriendsInGroups("testautotest");

        for (int i = 0; i < ans.size(); i++) {
            ArrayList<String> dop = ans.get(i);
            for (int j = 0; j < dop.size(); j++) {
                System.out.println(dop.get(j));
            }
        }
        System.out.println("!!!!!!!!!!!!! test stop");*/
        
        //this.workWithDB().findNotFriend(DEFAULT_STORY_NAME)

    }
}
