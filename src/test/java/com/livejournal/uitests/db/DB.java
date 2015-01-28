package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import java.sql.SQLException;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {
    
    @Given("data from DB")
    public void db() throws SQLException {
        
        System.out.println("!!!!!!!!!!!!! test start");
        System.out.println(workWithDB().findNotFriend("testautotest"));
        System.out.println(workWithDB().findNotFriend("testautotest"));
        System.out.println(workWithDB().findNotFriend("testautotest"));
        System.out.println(workWithDB().findNotFriend("testautotest"));
        System.out.println(workWithDB().findNotFriend("testautotest"));
        System.out.println(workWithDB().findNotFriend("testautotest"));
        System.out.println(workWithDB().findNotFriend("testautotest"));
        System.out.println(workWithDB().findNotFriend("testautotest"));
        System.out.println(workWithDB().findNotFriend("testautotest"));
        System.out.println(workWithDB().findNotFriend("testautotest"));
       // System.out.println("!!!!!!!!!!!!! test start");
        /*ArrayList<String> ans = workWithDB().findAllFriends("testautotest");
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }*/
        System.out.println("!!!!!!!!!!!!! test stop");
        
    }
}
