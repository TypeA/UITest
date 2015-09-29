package com.livejournal.uitests.db;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws InterruptedException {

        System.out.println("!!!!!!!!!!!!!!!!!!!! start test");
        String name = "testautotest";
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
        System.out.println("===" + open(UpdateBmlPageLogged.class)
                .closeDraft()
                .useAdditionalContent()
                .setRightBlockContent("music", "maxa")
                .getRightBlockContent("music"));
        System.out.println("!!!!!!!!!!!!!!!!!!!! finish test");

    }

}
