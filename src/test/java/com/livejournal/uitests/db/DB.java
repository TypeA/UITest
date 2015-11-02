package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;

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
