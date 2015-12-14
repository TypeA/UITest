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
        List<ArrayList<String>> loggs = getLoggs();

        addTable().pageOpen("MainPageUnlogged")
                .importantErrors(loggs.get(0))
                .otherErrors(null)
                .and()
                .pageOpen("Page 2")
                .importantErrors(loggs.get(1))
                .otherErrors(loggs.get(0))
                .finish();

        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");
    }

}
