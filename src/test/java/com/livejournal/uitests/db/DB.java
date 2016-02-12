package com.livejournal.uitests.db;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {
        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");
       System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
       System.out.println(System.getProperty("webdriver.firefox.bin"));
       
       open(LoginPageUnlogged.class);

    }

    @Then("table is displayed")
    public void table_is_displayed() {

        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");
    }

}
