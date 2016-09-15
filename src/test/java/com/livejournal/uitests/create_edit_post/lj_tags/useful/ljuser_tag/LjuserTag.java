package com.livejournal.uitests.create_edit_post.lj_tags.useful.ljuser_tag;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author s.savinykh
 */
public class LjuserTag extends LJTest {

    //Scenario: Logged user create new post with correct lj-user tag (1/3)
    //Scenario: Logged user create new post with uncorrect lj-user tag (1/3)
    //Scenario: User can use autocomplete for lj-user tag (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault()
                .defaultLanguageLogged(name)
                .setDefault()
                .defaultStyle(name);
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: Logged user create new post with correct lj-user tag (2/3)
    @When("user enter correct username $ljuser in ljuser bubble and create new post")
    public void user_ener_correct_username_in_ljuser_bubble_and_create_new_post(String ljuser) {
        String postText = utility().random().getRandomText(30) + " ";
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .useHTMLEditor()
                .setPostText(postText)
                .setUsername(ljuser, true)
                .usePage()
                .postEntry();
    }

    //Scenario: Logged user create new post with uncorrect lj-user tag (2/3)
    @When("user enter incorrect username $ljuser in ljuser bubble and try to post new entry")
    public void user_enter_incorrect_username_in_ljuser_bubble(String ljuser) {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .useHTMLEditor()
                .setPostText("")
                .setUsername(ljuser, false);
    }

    //Scenario: User can use autocomplete for lj-user tag (1/3)
    @When("user $name enter few symbols of his friend username and choose his name and save post")
    public void user_enter_few_symbols_of_his_friend_username(String name) {
        ArrayList<String> allFriends = getDBDate().friends().getAllFriends(name);
        String ljuser = allFriends.get((int) (Math.random() * allFriends.size()));
        ThucydidesUtils.putToSession("ljuser", ljuser);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .useHTMLEditor()
                .setPostText("Hello, ")
                .setUserNameByAutocomplete(ljuser)
                .usePage()
                .postEntry();

    }

    //Scenario: Logged user create new post with correct lj-user tag (3/3)
    @Then("the post is in journal and contains correct username $ljuser")
    public void post_is_in_journal_and_contains_correct_username(String ljuser) {
        verify().that(onOpened(EntryPageLogged.class).Entry().getLJUser().equals(ljuser.toLowerCase()))
                .ifResultIsExpected("Username " + ljuser + " displaying correctly in post")
                .ifElse("Username " + ljuser + " displaying incorrectly in post")
                .finish();
    }

    //Scenario: Logged user create new post with uncorrect lj-user tag (3/3)
    @Then("user see an error in header")
    public void user_see_an_error_in_header() {
        verify().that(onOpened(UpdateBmlPageLogged.class).getErrorStrip().getErrorText().toUpperCase().equals("INVALID USER"))
                .ifResultIsExpected("User see an error 'Invalid user'")
                .ifElse("User didn't see an error 'Invalid user'")
                .finish();
    }

    //Scenario: Logged user create new post with correct lj-user tag (3/3)
    @Then("the post is in journal and contains correct username")
    public void post_contains_correct_username() {
        String correctName = ThucydidesUtils.getFromSession("ljuser").toString();
        verify().that(onOpened(EntryPageLogged.class).Entry().getLJUser().equals(correctName.toLowerCase()))
                .ifResultIsExpected("Username " + correctName + " displaying correctly in post")
                .ifElse("Username " + correctName + " displaying incorrectly in post.")
                .finish();
    }
}
