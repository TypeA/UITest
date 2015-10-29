package com.livejournal.uitests.lj_magazine.digest.useful.add_as_friend;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageLogged;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageUnlogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
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

    //Scenario: Logged user can add to friends author of the post(1/3)
    @Given("logged user $user on the post page")
    public void logged_user_on_the_post_page(String user) {
        open(LoginPageUnlogged.class).authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(LJMagazinePageLogged.class).openRandomPost("user");
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
