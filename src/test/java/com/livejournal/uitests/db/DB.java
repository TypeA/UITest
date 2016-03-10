package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {
        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");
        
        System.out.println(parseUser("logged", "testautotest"));
        System.out.println(parseUser("unlogged","testautotest"));
        System.out.println(parseUser("friend", "testautotest"));
        System.out.println(parseUser("not_friend", "testautotest"));
        
        System.out.println("STOP TEST +++++++++++++++++++++++++++++++");

    }

    public String parseUser(String user, String main_user) { 
        String username = null;
        System.out.println(main_user);
        switch (user) {
            case "logged":
                return getDBDate().friends().getNotFriend(main_user);
            case "not_friend":
                return getDBDate().friends().getNotFriend(main_user);

            case "unlogged":
//	    Nothing happens
                return null;
            case "friend":
                return getDBDate().friends().getFriend(main_user);

            default:
                Assert.fail("Incorrect argument");
                return null;
        }
    }

}
