package com.livejournal.uitests.feed.comfortable.buttons;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.FiltersBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.settings.SettingsBlock;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeaderLogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author m.prytkova
 */
public class Buttons extends LJTest {

    //Scenario: Up button (1/3)
    //Scenario: Replacement blocks (1/3)
    @Given("logged user $user on Friends Feed")
    public void logged_user_on_Friends_Feed(String user) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(FriendsFeedLogged.class, new Url().setPrefix(user + "."));
    }

    //Scenario: Up button (2/3)
    @When("user scroll Feed down")
    public void user_scroll_Feed_down() {
        try {
            Thread.sleep(1000);
            this.startScript("window.scrollBy(0,10000000)");
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Assert.assertNull(open(FriendsFeedLogged.class));
        }
    }

    //Scenario: Replacement blocks (2/3)
    @When("user click on settings and filters icons")
    public void user_click_on_settings_and_filters_icons() {
        onOpened(FriendsFeedLogged.class)
                .openSettings();
        verify().that(onDisplayed(SettingsBlock.class).isDisplayed())
                .ifResultIsExpected("Settings block is displayed")
                .ifElse("Settings block is not displayed")
                .finish();
        onOpened(FriendsFeedLogged.class)
                .openFilters();
    }

    //Scenario: Up button (3/3)
    @Then("Up button is visible and can return Feed up")
    public void up_button_is_visible_and_return_Feed_up() {
        verify().that(onOpened(FriendsFeedLogged.class).upIsDisplayed())
                .ifResultIsExpected("Up button is displayed")
                .ifElse("Up button  is not displayed")
                .finish();
        onOpened(FriendsFeedLogged.class).clickUpButton();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Assert.assertNull(open(FriendsFeedLogged.class));
        }
        onDisplayed(FullscreenHeaderLogged.class).clickOnLogo();
        verify().that(!onOpened(FriendsFeedLogged.class).upIsDisplayed())
                .ifResultIsExpected("Up button is displayed")
                .ifElse("Up button  is not displayed")
                .finish();
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
