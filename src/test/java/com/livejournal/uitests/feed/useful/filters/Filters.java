package com.livejournal.uitests.feed.useful.filters;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageGroupsPage;
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
    @Given("logged user $user with friends on Friends Feed")
    public void logged_user_with_friends_on_Feed(String user) {
        Assert.assertTrue("Incorrect user " + user + ": without friends", userWithFriends(user));
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."));
    }

    //Scenario: Default view (1/2)
    //Scenario: Friends group(1/3)
    @Given("logged user $user with group $filter on Friends Feed")
    public void logged_user_with_group_on_Feed(String user, String filter) {
        ThucydidesUtils.putToSession("user", user);
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        ArrayList<String> groups = getDBDate().friends().getAllGroups(user);
        if (!groups.contains(filter)) {
            open(ManageGroupsPage.class)
                    .createNewGroup(filter)
                    .moveUserInByIndex(5)
                    .moveUserInByIndex(4)
                    .moveUserInByIndex(3)
                    .moveUserInByIndex(2)
                    .moveUserInByIndex(1)
                    .saveChangesForGroup();
        }
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."));
    }

    //Scenario: Edit Filters (1/3)
    @Given("logged user $user on Friends Feed")
    public void logged_user_on_Feed(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."));
    }

    //Scenario: Default friends filters (2/3)
    //Scenario: Friends group(2/3)
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

    //Scenario: Default friends filters (3/3)
    @Then("user see Friends Feed by filter $filter")
    public void user_see_feed_by_filter(String filter) {
        ArrayList<String> autors = onOpened(FriendsFeedLogged.class)
                .feed()
                .getAutors();
        verify().that(verifyAutors(autors).equals(filter))
                .ifResultIsExpected("User see friends feed by correct filter " + filter)
                .ifElse("Filter " + filter + " does not work")
                .and()
                .that(getCurrentUrl().contains("/feed/view/" + filter))
                .ifResultIsExpected("Url is correct: " + getCurrentUrl())
                .ifElse("Url is incorrect: " + getCurrentUrl())
                .finish();
    }

    //Scenario: Default View (2/2)
    //Scenario: Friends group(3/3)
    @Then("user see Friends Feed by group $filter")
    public void user_see_feed_by_group(String filter) {
        ArrayList<String> autors = onOpened(FriendsFeedLogged.class)
                .feed()
                .getAutors();
        ArrayList<String> okAutors = getDBDate()
                .friends()
                .getAllFriendsInGroup(ThucydidesUtils.getFromSession("user").toString(), filter);
        verify().that(okAutors.containsAll(autors))
                .ifResultIsExpected("There are only correct autors on the feed")
                .ifElse("There are incorrect autors on the feed")
                .finish();
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

    private String verifyAutors(ArrayList<String> autors) {
        boolean flagJ = false;
        boolean flagC = false;

        for (int i = 0; i < autors.size(); i++) {
            if (getDBDate().userData().getUserType(autors.get(i)).equals("journal")) {
                flagJ = true;
            }
            if (getDBDate().userData().getUserType(autors.get(i)).equals("community")) {
                flagC = true;
            }
        }

        if (flagJ && flagC) {
            return "all";
        } else {
            if (flagJ && !flagC) {
                return "journals";
            } else {
                if (!flagJ && flagC) {
                    return "communities";
                } else {
                    return "nothing";
                }
            }
        }
    }

}
