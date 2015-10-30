package com.livejournal.uitests.feed.useful.filters;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
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
    @Given("logged user $user on Friends Feed")
    public void logged_user_on_Friends_Feed(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."));
    }

    //Scenario: Default friends filters (2/3)
    @When("user set filter $filter")
    public void user_set_filter(String filter) {
        onOpened(FriendsFeedLogged.class)
                .openFilters();
                
    }

    //Scenario: Edit Filters (2/2)
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

}
