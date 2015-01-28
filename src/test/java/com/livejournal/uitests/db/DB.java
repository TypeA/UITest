/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.db;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.EditJournalbml;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import static com.livejournal.uitests.utility.ParseString.getParsedString;
import com.livejournal.uitests.utility.iterations.EqualityOfArrayLists;
import static com.livejournal.uitests.utility.iterations.EqualityOfArrayLists.isEqual;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jbehave.core.annotations.Given;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws SQLException {
        System.out.println("!!!!!!!!!!!!!!!!!!!! start");
        open(LoginPageUnlogged.class)
                .authorizeBy("test001", getUserPassword("test001"));
        open(EntryPage.class, new Url()
                .setPrefix("test001.")
                .setPostfix("29731.html"));
        onOpened(EntryPage.class).clickOnEditButton();
        ArrayList<String> privacyParsed = getParsedString(onOpened(EditJournalbml.class).getCurrentPrivacy(), "\\n");
        String privacy = "Custom";
        String group = "Online Friends;Work;Local Friends";
        String privacyStr = privacy + ";" + group;
        ArrayList<String> privacyIncoming = getParsedString(privacyStr, ";");

        boolean flag = isEqual(privacyParsed, privacyIncoming);
        for (int i = 0; i < privacyParsed.size(); i++) {
            System.out.println("<=== " + privacyParsed.get(i));
        }

        for (int i = 0; i < privacyIncoming.size(); i++) {
            System.out.println("===> " + privacyIncoming.get(i));
        }

        System.out.println("Flag = " + flag);
        System.out.println("!!!!!!!!!!!!!!!!!!!! stop");
    }
}
