package com.livejournal.uitests.feed.personal.custom_friends_groups;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class CustomFriendsGroups extends WebTest {

    //Scenario: Go to Edit Custom Friends Groups (1/3)
    //Scenario: Replacement blocks (1/3)
    @Given("logged user (name $name, password $password) on Friends Feed")
    public void logged_user_on_Friends_Feed(String name, String password) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, password);
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."));
    }

    //Scenario: Go to Edit Custom Friends Groups (2/2)
    @When("user go to Edit Custom Friends Groups")
    public void user_go_to_Edit_Custom_Friends_Groups() {
        onOpened(FriendsFeedLogged.class)
                .openFilters()
                .clickOnManageFilters();
    }

    //Scenario: Replacement blocks (2/3)
    @When("user click on settings and filters icons")
    public void user_click_on_settings_and_filters_icons() {
        onOpened(FriendsFeedLogged.class)
                .openSettings();
        onOpened(FriendsFeedLogged.class)
                .openFilters();
    }

    //Scenario: Go to Edit Custom Friends Groups (3/3)
    @Then("user in correct page $page")
    public void user_in_correct_Page(String page) {
        verify().thatIsOn((Class<? extends Page>) this.getPageClassByName(page))
                .finish();
    }

    //Scenario: Replacement blocks (3/3)
    @Then("the blocks is changed")
    public void the_blocks_is_changed() {
        verify().that(onOpened(FriendsFeedLogged.class).filtersDisplaying())
                .ifResultIsExpected("Filters block is displayed")
                .ifElse("Filters block is not displayed")
                .finish();
    }
}
