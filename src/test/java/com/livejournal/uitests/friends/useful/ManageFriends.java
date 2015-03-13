package com.livejournal.uitests.friends.useful;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageFriendsPage;
import static com.livejournal.uitests.utility.ParseString.getParsedString;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author IKasatkin
 */
public class ManageFriends extends WebTest {

    //Scenario: Add friend (1/3)
    //Scenario: Delete friend(1/3)
    @Given("logged user (name $name) on ManageFriendsPage")
    public void logged_user_on_ManageFriendsPage(String name) {
        ThucydidesUtils.putToSession("user", name);
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
        open(ManageFriendsPage.class);
    }

    //Scenario: Add friend (2/3)
    @When("user type user $users and save changes")
    public void user_type_user_and_save_changes(String users) {
        onOpened(ManageFriendsPage.class).typeName(getParsedString(users, ";"))
                .clickSaveChangesButton();
    }

    //Scenario: Delete friend(2/3)
    @When("user disable checkbox for user $users and save changes")
    public void user_disable_checkbox_for_users_and_save_changes(String users) {
        onOpened(ManageFriendsPage.class).removeFriend(getParsedString(users, ";"));
    }

    //Scenario: Add friend (3/3)
    @Then("user $users should be added as a friend")
    public void user_should_be_added_as_a_friend(String users) {
        open(ManageFriendsPage.class);
        verify().that(getDBDate().friends().findAllFriends(ThucydidesUtils.getFromSession("user").toString()).containsAll(getParsedString(users, ";")))
                .ifResultIsExpected("Users " + users + " are successfuly added as a friends in DB")
                .ifElse("Users " + users + " are not successfuly added as a friends in DB")
                .and()
                .that(onPageVerification(users))
                .ifResultIsExpected("Users " + users + " are displayed on the page")
                .ifElse("Users " + users + " are not displayed on the page")
                .finish();
    }

    //Scenario: Delete friend(3/3)
    @Then("user $users should be removed from friends")
    public void users_should_be_removed_from_friends(String users) {
        open(ManageFriendsPage.class);
        verify().that(!getDBDate().friends().findAllFriends(ThucydidesUtils.getFromSession("user").toString()).containsAll(getParsedString(users, ";")))
                .ifResultIsExpected("Users " + users + " are successfuly deleted from a friends in DB")
                .ifElse("Users " + users + " are not successfully deleted from friends in DB")
                .and()
                .that(!onPageVerification(users))
                .ifResultIsExpected("Users " + users + " are not displayed on the page")
                .ifElse("Users " + users + " are displayed on the page")
                .finish();

    }

    private boolean onPageVerification(String users) {
        boolean flag = true;
        for (int i = 0; i < getParsedString(users, ";").size(); i++) {
            boolean f = onOpened(ManageFriendsPage.class).applyFilter(getParsedString(users, ";").get(i))
                    .getFriendsOnPage()
                    .contains(getParsedString(users, ";").get(i));
            flag = flag & f;
        }
        return flag;
    }
}
