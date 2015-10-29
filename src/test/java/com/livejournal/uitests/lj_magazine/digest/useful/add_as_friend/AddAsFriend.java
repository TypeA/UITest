package com.livejournal.uitests.lj_magazine.digest.useful.add_as_friend;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageUnlogged;
import net.thucydides.core.annotations.StepGroup;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

/**
 *
 * @author s.savinykh
 */
public class AddAsFriend extends LJTest {

    //Scenario: Unlogged user cant see button Add to friends(1/2)
    @Given("unlogged user on the post page")
    public void unlogged_user_on_the_post_page() {
        open(LJMagazinePageUnlogged.class).openRandomPost("user");
    }

    //Scenario: Unlogged user cant see button Add to friends(2/2)
    @Then("unlogged user cant see button add to friends")
    public void unlogged_user_cant_see_button_add_to_friends() {
        verify().that(!addToFriendsButtonIsOnPage())
                .ifResultIsExpected("The \"Add to friends\" button is not avaliable for unlogged users")
                .ifElse("The \"Add to friends\" button is avaliable for unlogged users")
                .finish();
    }

    @StepGroup
    private Boolean addToFriendsButtonIsOnPage() {
        try {
            return !startScript("jQuery('.b-discoveryarticle-addfriend').text()").toString().isEmpty();

        } catch (Exception ex) {
            return false;
        }
    }

}
