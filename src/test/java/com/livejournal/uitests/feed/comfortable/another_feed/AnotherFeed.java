package com.livejournal.uitests.feed.comfortable.another_feed;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedUnlogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

/**
 *
 * @author m.prytkova
 */
public class AnotherFeed extends LJTest {

    //Scenario: Public filters (1/3)
    @Given("user $user on user2 $user2 Friends Feed")
    public void user_on_user2_Feed(String user, String user2) {
        ThucydidesUtils.putToSession("user", user2);
        Assert.assertTrue("Incorrect user: without groups", userWithGroups(user2));
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(FriendsFeedLogged.class, new Url().setPrefix(user2 + "."));

    }

    //Scenario: Default settings (1/3)
    @Given("user $user on custom Friends Feed")
    public void user_on_custom_Feed(String user) {
        ArrayList<String> users = getDBDate().userSettings().getUsersWithCustomFeed();
        String user_for_feed = "";
        for (int i = 0; i < users.size(); i++) {
            if (!users.get(i).equals(user) && users.get(i).contains("test")) {
                user_for_feed = users.get(i);
                i = users.size();
            }
        }
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(FriendsFeedLogged.class, new Url().setPrefix(user_for_feed + "."));
    }

    //Scenario: Public filters (2/3)
    @Then("user see only public filters")
    public void user_see_only_public_filters() {
        ArrayList<String> groups = onOpened(FriendsFeedLogged.class)
                .openFilters()
                .getAllGroups();
        ArrayList<String> okgroups = getDBDate().friends().getPublicGroups(ThucydidesUtils.getFromSession("user").toString());
        verify().that(okgroups.containsAll(groups))
                .ifResultIsExpected("Only public groups on the feed")
                .ifElse("Incorrect groups on the feed")
                .and()
                .that(okgroups.size() == groups.size())
                .ifResultIsExpected("Numers of groups is correct")
                .ifElse("Numers of groups is incorrect")
                .finish();

    }

    //Scenario: Public filters (3/3)
    @Then("unlogged user cannot see filters")
    public void unlogged_user_cannot_see_filters() {
        onOpened(FriendsFeedLogged.class).moveMouseOverMyJournalMenuItem().clickOnLogOut();
        verify().that(!onOpened(FriendsFeedUnlogged.class)
                .filtersIsDisplayed())
                .ifResultIsExpected("Unlogged user cannot see filters")
                .ifElse("Filters button is displayed")
                .finish();
    }

    //Scenario: Default settings (2/3)
    @Then("user see Feed on default settings")
    public void user_see_Feed_on_default_settings() {
        onOpened(FriendsFeedLogged.class);
    }

    private boolean userWithGroups(String user) {
        List<ArrayList<String>> groups = getDBDate().friends().getAllGroupsWithParams(user);
        int sum = 0;
        for (int i = 0; i < groups.get(2).size(); i++) {
            sum = sum + Integer.valueOf(groups.get(2).get(i));
        }
        return (sum > 1) && ((sum < groups.get(2).size()));
    }

    private ArrayList<String> defaultSettings() {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("ffffff");
        colors.add("ffffff");
        colors.add("ffffff");
        colors.add("f8f9fb");
        colors.add("7a9199");
        colors.add("dae3e6");
        colors.add("242f33");
        colors.add("242f33");
        colors.add("00a3d9");
        colors.add("0086b3");
        colors.add("007399");
        return colors;
    }

}
