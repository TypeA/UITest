package com.livejournal.uitests.DB;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

public class DB extends LJTest {

    @Given("data from DB")
    public void db() {
        System.out.println("START TEST +++++++++++++++++++++++++++++++");
        open(LoginPageUnlogged.class)
                .moveMouseOverLangSwitch()
                .switchLang("EN");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("STOP TEST +++++++++++++++++++++++++++++++ ");

    }

    @Then("table is displayed")
    public void table_is_displayed() {

    }

}
