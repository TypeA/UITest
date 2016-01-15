package com.livejournal.uitests.feed.comfortable.buttons;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.FiltersBlock;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class Buttons extends LJTest {

    //Scenario: Replacement blocks (1/3)
    @Given("logged user (name $name) on Friends Feed")
    public void logged_user_on_Friends_Feed(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."));
    }

    //Scenario: Replacement blocks (2/3)
    @When("user click on settings and filters icons")
    public void user_click_on_settings_and_filters_icons() {
        onOpened(FriendsFeedLogged.class)
                .openSettings();
        onOpened(FriendsFeedLogged.class)
                .openFilters();
    }

    //Scenario: Replacement blocks (3/3)
    @Then("the blocks is changed")
    public void the_blocks_is_changed() {
        verify().that(onDisplayed(FiltersBlock.class).isDisplayed())
                .ifResultIsExpected("Filters block is displayed")
                .ifElse("Filters block is not displayed")
                .finish();
    }
}
