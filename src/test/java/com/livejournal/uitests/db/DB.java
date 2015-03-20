package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.utility.date.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws SQLException, InterruptedException {

        String name = "testautotest";
        System.out.println("!!!!!!!!!!!!!!!!!!!! start");
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defoultLanguage(name)
                .defoultStyle(name);
        open(SheduledEntriesPage.class)
                .deleteAllSheduledEntries();
        System.out.println("!!!!!!!!!!!!! test stop");
    }

    public static String convertPostTime(String time) {

        if (time.length() < 16) {
            time = time.replaceAll(";", ";0");
        }
       
        time = time.substring(6, 10) + "-"
                + time.substring(3, 5) + "-"
                + time.substring(0, 2) + " "
                + time.substring(11, 16) + ":00";

        return time;
        //time.replaceAll("/", "-").replaceAll(";", " ") + ":00";
    }
}
