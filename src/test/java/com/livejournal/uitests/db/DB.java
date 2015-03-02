package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.utility.date.Date;
import java.sql.SQLException;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws SQLException, InterruptedException {

        String name = "testautotest";
        System.out.println("!!!!!!!!!!!!!!!!!!!! start");
        open(LoginPageUnlogged.class)
                .authorizeBy(name, workWithDB().getUserPassword(name))
                .defoultLanguage(name);
        open(SheduledEntriesPage.class)
                .deleteAllSheduledEntries();
        System.out.println("!!!!!!!!!!!!! test stop");
    }

}
