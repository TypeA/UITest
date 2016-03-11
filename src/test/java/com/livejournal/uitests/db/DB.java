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
        
//        System.out.println(parseUser("logged", "testautotest"));
//        System.out.println(parseUser("unlogged","testautotest"));
//        System.out.println(parseUser("friend", "testautotest"));
//        System.out.println(parseUser("not_friend", "testautotest"));
        testTests("try06");
        System.out.println("STOP TEST +++++++++++++++++++++++++++++++");

    }

    public void testTests(String username) {
        open(LoginPageUnlogged.class)
                        .authorizeBy(username, getDBDate().userData().getUserPassword(username))
                        .defaultLanguageLogged(username);
    }
    

    


}
