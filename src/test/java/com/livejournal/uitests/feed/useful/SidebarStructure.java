package com.livejournal.uitests.feed.useful;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.utility.AccountGenerator;
import com.livejournal.uitests.utility.RandomName;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class SidebarStructure extends WebTest {

    @Given("new user (name $name, password $password) with widget $widget in sidebar on Friends Feed")
    public void new_ser_with_widget_in_sidebar_on_Friends_Feed(String name, String password, String widget) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, password);
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."))
                .addWidget(widget);
    }

}
