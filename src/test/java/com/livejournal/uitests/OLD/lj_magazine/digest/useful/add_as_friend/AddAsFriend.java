package com.livejournal.uitests.OLD.lj_magazine.digest.useful.add_as_friend;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageLogged;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageUnlogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageFriendsPage;
import net.thucydides.core.annotations.StepGroup;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

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

    //Scenario: Logged user can add to friends author of the post(1/3)
    @Given("logged user $user on the post page")
    public void logged_user_on_the_post_page(String user) {
        open(LoginPageUnlogged.class).authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(LJMagazinePageLogged.class).openRandomPost("user");
    }

    //Scenario: Logged user cant add to friends ljEditor(1/2)
    @Given("logged user $user on the ljEditor post page")
    public void logged_user_on_the_ljEditor_post_page(String user) {
        open(LoginPageUnlogged.class).authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(LJMagazinePageLogged.class).openRandomPost("ljEditor");
    }

    //Scenario: Logged user can add to friends author of the post(2/3)
    @When("user $user click on the Add to friends button")
    public void user_click_on_the_add_to_friends_button(String user) {
        String author = onOpened(LJMagazinePageLogged.class).getAuthorOfThePost();
        ThucydidesUtils.putToSession("author", author);
        if (getDBDate().userData().friends().getAllFriends(user).contains(author)) {
            String postID = onOpened(LJMagazinePageLogged.class).getPostID();
            open(ManageFriendsPage.class).removeFriend(utility().convertation().stringToList(author + ";", ";"));
            open(LJMagazinePageLogged.class, new Url()
                    .setPostfix(postID)).addAsFriend();
        } else {
            onOpened(LJMagazinePageLogged.class).addAsFriend();
        }
    }

    //Scenario: Unlogged user cant see button Add to friends(2/2)
    @Then("unlogged user cant see button add to friends")
    public void unlogged_user_cant_see_button_add_to_friends() {
        verify().that(!addToFriendsButtonIsOnPage())
                .ifResultIsExpected("The \"Add to friends\" button is not avaliable for unlogged users")
                .ifElse("The \"Add to friends\" button is avaliable for unlogged users")
                .finish();
    }

    //Scenario: Logged user can add to friends author of the post(2/3)
    @Then("user $user have author of the post in his friends")
    public void user_have_author_of_the_post_in_his_friends(String user) {
        verify().that(getDBDate().userData().friends().getAllFriends(user).contains(ThucydidesUtils.getFromSession("author")))
                .ifResultIsExpected("User " + ThucydidesUtils.getFromSession("author") + " is friend in DB")
                .ifElse("User " + ThucydidesUtils.getFromSession("author") + " is not a friend in DB")
                .and()
                .that(onOpened(LJMagazinePageLogged.class).getStatusOfAddAsFriendButton().equals("disabled"))
                .ifResultIsExpected("The button is disabled")
                .ifElse("The button is enabled")
                .finish();

    }

    //Scenario: Logged user cant add to friends ljEditor(2/2)
    @Then("user cant see button add to friends")
    public void user_cant_see_button_add_to_friends() {
        verify().that(!addToFriendsButtonIsOnPage())
                .ifResultIsExpected("The \"Add to friends\" button is not avaliable for user in LJ Editor post page")
                .ifElse("The \"Add to friends\" button is avaliable for user in LJ Editor post pageF")
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
