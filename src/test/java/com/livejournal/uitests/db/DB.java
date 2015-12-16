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

         List<ArrayList<String>> ans = getDBDate()
                 .community()
                 .targetIdWithParams("test_comm", "A");
         for (int i=0; i<ans.get(0).size(); i++){
         System.out.println(ans.get(0).get(i) + " " + ans.get(1).get(i));}

    }

    @Then("table is displayed")
    public void table_is_displayed() {

        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");
    }

}
