package com.livejournal.uitests.friends.useful;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageFriendsPage;
import static com.livejournal.uitests.utility.ParseString.getParsedString;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author IKasatkin
 */
public class AddFriend extends WebTest {

    @Given("logged user (name $name) on ManageFriendsPage")
    public void logged_user_on_ManageFriendsPage(String name) {
        ThucydidesUtils.putToSession("user", name);
        open(LoginPageUnlogged.class)
                .authorizeBy(name, workWithDB().getUserPassword(name));
        open(ManageFriendsPage.class);
    }

    @When("user type user $users and save changes")
    public void user_type_user_and_save_changes(String users) {
        onOpened(ManageFriendsPage.class).typeName(getParsedString(users, ";"))
                .clickSaveChangesButton();
    }

    @Then("user $users should be added as a friend")
    public void user_should_be_added_as_a_friend(String users) {
        boolean flag=this.workWithDB().findAllFriends(ThucydidesUtils.getFromSession("user").toString()).containsAll(getParsedString(users,";"));
        System.out.println("======================= "+flag);
        
        
    }
}
