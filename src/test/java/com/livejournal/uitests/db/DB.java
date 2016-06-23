package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {
        System.out.println("START TEST +++++++++++++++++++++++++++++++");
       getDBDate().profile().getFullSchoolInfo("testautotest");
        System.out.println("STOP TEST +++++++++++++++++++++++++++++++");

    }

    @Then("table is displayed")
    public void table_is_displayed() {
        
    }

}
