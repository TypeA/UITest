package com.livejournal.uitests.friends.useful;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageFriendsPage;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

/**
 *
 * @author IKasatkin
 */
public class AddFriend extends WebTest{
    @Given ("logged user (name $name) on ManageFriendsPage")
    public void logged_user_on_ManageFriendsPage(String name){
    open(LoginPageUnlogged.class)
                .authorizeBy(name, workWithDB().getUserPassword(name));
    open(ManageFriendsPage.class);
    }
    
    @When ("user type user $users and save changes")
    public void user_type_user_and_save_changes(String users){
    //ArrayList<String> s1 = getParsedString(users);
      //  onOpened(ManageFriendsPage.class).
}
    //@Then ("user $users should be added as a friend")
}
