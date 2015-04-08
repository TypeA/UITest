package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import java.sql.SQLException;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws SQLException, InterruptedException {

        String str = "http://www.lj-9.bulyon.local/img/icon_groups.gif?v=13546";
     //   String str = "icon_groups.gif?v=13546";
        System.out.println("!!!!!!!!!!!!!!!!!!!! start");

        System.out.println(str.substring(str.indexOf('_') + 1, str.indexOf('?')-4));
        
        System.out.println("!!!!!!!!!!!!! test stop");
    }

}
