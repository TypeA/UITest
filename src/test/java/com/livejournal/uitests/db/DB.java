package com.livejournal.uitests.db;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.util.Set;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.Cookie;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {

        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");
        String user = "testautotest";
       
        System.out.println(getDBDate().userSettings().getFeedPaging(user, "type"));
        System.out.println(getDBDate().userSettings().getFeedPaging(user, "size"));
       


        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");
        
    }  

}
