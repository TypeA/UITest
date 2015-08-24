package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() {

        System.out.println("!!!!!!!!!!!!!!!!!!!! start");
        this.openUrl("http://softlakecity.ru/browsers/firefox/kak-izmenit-user-agent-v-mozilla-firefox");
        try {
            Thread.sleep(300000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!! finish");

    }

}
