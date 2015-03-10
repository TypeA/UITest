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
        System.out.println(convertPostTime("03/12/2015;14:30", "12"));
        System.out.println("!!!!!!!!!!!!! test stop");
    }

    private String convertPostTime(String time, String format) {
        switch (format) {
            case "12":
                String hour = null;
                if (Integer.valueOf(time.substring(11, 13)) < 12) {
                    hour = time.substring(11, 16) + " am";
                } else {
                    hour = (Integer.valueOf(time.substring(11, 13)) - 12)
                            + time.substring(13, 16)
                            + " pm";
                }
                return Date.getManthByIndex(time.substring(0, 2))
                        + " " + time.substring(3, 5) + "th"
                        + ", " + time.substring(6, 10)
                        + ", " + hour;
            case "24":
                return Date.getManthByIndex(time.substring(0, 2))
                        + " " + time.substring(3, 5)
                        + ", " + time.substring(6, 10)
                        + ", " + time.substring(11, 16);
            default:
                return time;
        }

    }

}
