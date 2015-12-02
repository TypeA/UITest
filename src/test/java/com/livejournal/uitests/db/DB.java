package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.logging.Level;
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
        
        for (String error : warningerr) {
            System.out.println(error);
        }

      //  ArrayList<String> errors = new ArrayList<String>();
        //   ArrayList<String> severe = new ArrayList<String>();
        //  ArrayList<String> warning = new ArrayList<String>();
        //  for (LogEntry logEntry : getCurrentBrowser().getDriver().manage().logs().get("browser").getAll()) {
        // if (logEntry.getLevel().toString().equals("SEVERE")) {
        //          errors.add("[" + logEntry.getLevel() + "] " + logEntry.getMessage());
          /*  }
         if (logEntry.getLevel().toString().equals("WARNING")) {
         warning.add("[" + logEntry.getLevel() + "] " + logEntry.getMessage());
         }*/
        //}
        /*    System.out.println("!!!!!!!!!!!!!!!!!!!!");
         for (LogEntry logEntry : getCurrentBrowser().getDriver().manage().logs().get("browser")
         .filter(Level.WARNING)) {
         System.out.println(logEntry);
         }*/
        //  for (int i = 0; i < errors.size(); i++) {
        //      System.out.println(errors.get(i));
        //  }
     /*   System.out.println("!!!!!!!!!!!!!!!!!!!!");
         for (int i = 0; i < warning.size(); i++) {
         System.out.println(warning.get(i));
         }*/
        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");

    }

}
