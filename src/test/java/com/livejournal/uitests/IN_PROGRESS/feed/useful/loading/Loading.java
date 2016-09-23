package com.livejournal.uitests.IN_PROGRESS.feed.useful.loading;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.util.Objects;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author m.prytkova
 */
public class Loading extends LJTest {

    //Scenario: User's feed loading (1/3)
    @Given("user $user with paging type $type on the Friends Feed")
    public void user_with_underscope_in_name_on_Feed(String user, String type) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        ThucydidesUtils.putToSession("user", user);
        String user_paging_type = getDBDate().userSettings().getFeedPaging(user, "type");
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."));
        if (!user_paging_type.toUpperCase().equals(type)) {
            onOpened(FriendsFeedLogged.class)
                    .openSettings()
                    .setPaging(type)
                    .setSize(10)
                    .saveSettings();
            getCurrentBrowser().refreshCurrentPage();
        }
        ThucydidesUtils.putToSession("url", getCurrentUrl());
    }

    //Scenario: Another user feed loading (1/3)
    @Given("user $user on the user2 $user2 Friends Feed")
    public void user_on_user2_Feed(String user, String user2) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(FriendsFeedLogged.class, new Url().setPrefix(user2 + "."));
    }

    //Scenario: Feed loading by unlogged user (1/3)
    @Given("unlogged user on the user $user Friends Feed")
    public void unlogged_user_on_user_Feed(String user) {
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."));
    }

    //Scenario: User's feed loading (2/3)
    //Scenario: Another user feed loading (2/3)
    //Scenario: Feed loading by unlogged user (2/3)
    @When("user scroll Friends Feed down")
    public void user_scroll_Friends_Feed_down() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Assert.assertNull(open(FriendsFeedLogged.class));
        }
        this.startScript("window.scrollBy(0,10000000)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Assert.assertNull(open(FriendsFeedLogged.class));
        }
    }

    //Scenario: User's feed loading (3/3)
    //Scenario: Another user feed loading (3/3)
    //Scenario: Feed loading by unlogged user (3/3)
    @Then("more entries are loading on Friends Feed by type $type")
    public void more_entries_are_loading_on_Friends_Feed_by_type(String type) {
        Integer numOfPosts = onOpened(FriendsFeedLogged.class)
                .feed()
                .getNumberOfPosts();

        if (type.equals("ENDLESS")) {
            verify().that(numOfPosts > 20)
                    .ifResultIsExpected("Correct numbers of posts on the feed (type " + type + ")")
                    .ifElse("Incorrect numbers of posts on the feed = " + numOfPosts)
                    .finish();
        }

        if (type.equals("PAGES")) {
            Integer correctSize = Integer.valueOf(getDBDate().userSettings().getFeedPaging(ThucydidesUtils.getFromSession("user").toString(), "SIZE"));
            verify().that(Objects.equals(numOfPosts, correctSize))
                    .ifResultIsExpected("Correct numbers of posts on the feed (type " + type + ")")
                    .ifElse("Incorrect numbers of posts on the feed = " + numOfPosts)
                    .finish();
            onOpened(FriendsFeedLogged.class).openPreviousPage();
            verify().that(getCurrentUrl().equals(ThucydidesUtils.getFromSession("url") + "?skip=" + correctSize))
                    .ifResultIsExpected("Correct url " + ThucydidesUtils.getFromSession("url") + "?skip=" + correctSize)
                    .ifElse("Incorrect url " + getCurrentUrl())
                    .finish();
            onOpened(FriendsFeedLogged.class).openNextPage();
            verify().that(getCurrentUrl().equals(ThucydidesUtils.getFromSession("url")))
                    .ifResultIsExpected("Correct url " + ThucydidesUtils.getFromSession("url"))
                    .ifElse("Incorrect url " + getCurrentUrl())
                    .finish();
        }

    }

}
