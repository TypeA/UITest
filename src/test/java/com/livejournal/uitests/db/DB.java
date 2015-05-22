package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() {

        System.out.println("!!!!!!!!!!!!!!!!!!!! start");
        System.out.println( "test " + this.getSystemConfiguration().getBaseUrl());
        System.out.println("!!!!!!!!!!!!!!!!!!!! getUrlInPage");
        System.out.println("!!!!!!!!!!!!! test stop");
    }

}
