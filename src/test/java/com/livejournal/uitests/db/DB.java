package com.livejournal.uitests.db;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import com.livejournal.uitests.pages.service_pages.update.EditJournalbml;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import static com.livejournal.uitests.utility.ParseString.getParsedString;
import com.livejournal.uitests.utility.iterations.EqualityOfArrayLists;
import static com.livejournal.uitests.utility.iterations.EqualityOfArrayLists.isEqual;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class DB extends WebTest {

    @Given("data from DB")
    public void db() throws SQLException, InterruptedException {
        System.out.println("!!!!!!!!!!!!!!!!!!!! start");
        String name = "testautotest";
        open(LoginPageUnlogged.class)
                .authorizeBy(name, workWithDB().getUserPassword(name))
                .defoultLanguage(name);
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."));
        Thread.sleep(10000);
        System.out.println(startScript("return jQuery('.js-elem-bordercolor').css('borderTopColor')").toString());

       // String color = startScript("return jQuery('.js-elem-bordercolor').css('backgroundColor')").toString();
        //  System.out.println("==" + color);
        System.out.println("!!!!!!!!!!!!! test stop");

    }
}
