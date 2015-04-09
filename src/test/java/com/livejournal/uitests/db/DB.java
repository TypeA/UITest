package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.sql.SQLException;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws SQLException {

        System.out.println("!!!!!!!!!!!!!!!!!!!! start");
        ArrayList<String> maxa = new ArrayList<String>();
 
        System.out.println("!!!!!!!!!!!!! test stop");
    }

}
