package com.livejournal.uitests.feed.useful.filters;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import java.util.ArrayList;
import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class Filters extends LJTest {

    //Scenario: Default friends filters (1/3)
    //Scenario: Edit Filters (1/3)
    @Given("logged user $user with friends on Friends Feed")
    public void logged_user_with_friends_on_Friends_Feed(String user) {
        Assert.assertTrue("Incorrect user: without friends", userWithFriends(user));
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."));
    }

    //Scenario: Default friends filters (2/3)
    @When("user set filter $filter")
    public void user_set_filter(String filter) {
        onOpened(FriendsFeedLogged.class)
                .openFilters()
                .openDefaultFilter(filter);
    }

    //Scenario: Edit Filters (2/3)
    @When("user go to Edit Custom Friends Groups")
    public void user_go_to_Edit_Custom_Friends_Groups() {
        onOpened(FriendsFeedLogged.class)
                .openFilters()
                .openManageFilters();
    }

    //Scenario: Edit Filters (3/3)
    @Then("user in correct page $page")
    public void user_in_correct_Page(String page) {
        verify().thatIsOn((Class<? extends Page>) this.getPageClassByName(page))
                .finish();
    }

    private boolean userWithFriends(String user) {
        ArrayList<String> allFriends = getDBDate()
                .friends()
                .getAllFriends(user);
        boolean flagJ = false;
        boolean flagC = false;

        for (String allFriend : allFriends) {
            if (getDBDate().userData().getUserType(allFriend).equals("journal")) {
                flagJ = true;
            }
            if (getDBDate().userData().getUserType(allFriend).equals("community")) {
                flagC = true;
            }
        }
        return flagC && flagJ;
    }

}
