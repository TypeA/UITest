package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.logging.LogEntry;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {

        open(MainPageUnlogged.class);
        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");
        LinkedHashSet <String> severe = new LinkedHashSet <String>();
        LinkedHashSet <String> warningerr = new LinkedHashSet <String>();
        for (LogEntry logEntry : getCurrentBrowser().getDriver().manage().logs().get("browser").getAll()) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                severe.add(logEntry.getLevel() + " " + logEntry.getMessage());
            }
            if (logEntry.getLevel().toString().equals("WARNING")) {
                warningerr.add(logEntry.getLevel() + " " + logEntry.getMessage());
            }
        }
        for (String error : severe) {
            System.out.println(error);
        }
        
        
     //   for (String error : warningerr) {
       //     System.out.println(error);
      //  }

        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");


    }

}
