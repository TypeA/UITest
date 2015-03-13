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
        System.out.println(getDBDate().userData().getUserPassword(name));
        System.out.println("!!!!!!!!!!!!! test stop");
    }

    /*   private String defoultStyle(String user) {

     ArrayList<ArrayList<String>> user_atr = (ArrayList<ArrayList<String>>) workWithDB().conect()
     .select("select * from user where user = 'testautotest';", "userid")
     .select("select * from user where user = 'testautotest';", "clusterid")
     .finish();
        
     System.out.println("========== userid " + user_atr.get(0).get(0));
     System.out.println("========== clusterid " + user_atr.get(1).get(0));

     String script1 = "select * from lj_c" + user_atr.get(1).get(0) + ".userproplite2 "
     + "where userid = '" + user_atr.get(0).get(0) + "'"
     + "and upropid = (select upropid from userproplist where name = 's2_style');";
        
     String styleid = workWithDB().conect()
     .select(script1, "value")
     .finish()
     .get(0)
     .get(0);

     System.out.println("========== userid " + user_atr.get(0).get(0));
     System.out.println("========== styleid " + styleid);

     String script2 = "select name from s2styles "
     + "where userid= '" + user_atr.get(0).get(0)
     + "' and styleid = '" + styleid + "';";
        
     String style = workWithDB().conect()
     .select(script2, "name")
     .finish()
     .get(0)
     .get(0);

     System.out.println("========== " + style);
     return style;
     }*/
}
