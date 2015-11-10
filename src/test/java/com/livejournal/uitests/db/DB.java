package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.feed.personal.settings.Settings;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jbehave.core.annotations.Given;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() throws InterruptedException {

        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");
        String user = "testmaxatest";
       
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));


        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");
        
    }  

}
