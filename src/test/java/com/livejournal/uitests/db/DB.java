package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {
        System.out.println("START TEST +++++++++++++++++++++++++++++++");
        String name = "testautotest";
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultStyle(name);
        System.out.println("STOP TEST +++++++++++++++++++++++++++++++");

    }

    @Then("table is displayed")
    public void table_is_displayed() {

    }

}
