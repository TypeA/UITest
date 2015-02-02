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

     //   ArrayList<String> ans = workWithDB().findFriendInGroup("testautotest", "Work");
        System.out.println(workWithDB().findFriendWithoutGroup("testautotest"));
        /*
         for (int j = 0; j < ans.size(); j++) {
         System.out.println(ans.get(j));
         }
         */
        System.out.println("!!!!!!!!!!!!! test stop");

    }
}
