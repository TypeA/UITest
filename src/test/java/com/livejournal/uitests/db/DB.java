package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import net.thucydides.core.annotations.StepGroup;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.logging.LogEntry;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {
        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");

        open(MainPageUnlogged.class);

    }

    @Then("table is displayed")
    public void table_is_displayed() {
        System.out.println("!!!!!!!!!!!!!!!!!!!! step 2");
        ArrayList<String> loggs = getLoggs();

        addTable().pageOpen("MainPageUnlogged")
                .importantErrors(loggs.get(0))
                .otherErrors(loggs.get(1))
                .finish();
        /* this.verify().that(false)
         .ifResultIsExpected("Сообщение 1")
         .ifElse("Сообщение 2")
         .finish();*/
        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");
    }

    @StepGroup
    public ArrayList<String> getLoggs() {

        LinkedHashSet<String> severe = new LinkedHashSet<String>();
        LinkedHashSet<String> warningerr = new LinkedHashSet<String>();
        for (LogEntry logEntry : getCurrentBrowser().getDriver().manage().logs().get("browser").getAll()) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                severe.add(logEntry.getMessage());
            }
            if (logEntry.getLevel().toString().equals("WARNING")) {
                warningerr.add(logEntry.getMessage());
            }
        }

        String severe_logs = "";
        String warningerr_logs = "";
        int i = 1;
        for (String error : severe) {
            severe_logs += i + ". " + error + "\n";
            i++;
        }
        i = 1;
        for (String error : warningerr) {
            warningerr_logs += i + ". " + error + "\n";
            i++;
        }

        ArrayList<String> ans = new ArrayList<String>();
        ans.add(severe_logs);
        ans.add(warningerr_logs);

        return ans;
    }

}
