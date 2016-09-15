package com.livejournal.uitests.create_edit_post.lj_tags.useful.ljlike;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import java.util.ArrayList;
import java.util.Arrays;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author s.savinykh
 */
public class Ljlike extends LJTest {

    //Scenario: User can make new post with lj-like tag(1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultStyle(name);
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: User can make new post with lj-like tag(2/3)
    @When("user create post with lj-like $likes tag")
    public void user_create_post_with_ljlike_tag(String likes) {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .useHTMLEditor()
                .setPostText(utility().random().getRandomText(30))
                .setLikes(utility().convertation().stringToList(likes, ";"))
                .usePage()
                .postEntry();
    }

    //Scenario: User can make new post with lj-like tag(3/3)
    @Then("the post is in journal and contains lj-like $likes buttons")
    public void post_contains_ljlike_tag(String likes) {
        verify().that(ljlikesVerification(onOpened(EntryPageLogged.class).Entry().getLJLikeButtons(), utility().convertation().stringToList(likes, ";")))
                .ifResultIsExpected("User see correct set of LJ Likes buttons:" + "\n" + likes)
                .ifElse("User see incorrect set of LJ Likes buttons:" + "\n " + onOpened(EntryPageLogged.class).Entry().getLJLikeButtons())
                .finish();

    }

    private Boolean ljlikesVerification(ArrayList<String> actual, ArrayList<String> expected) {

        if (expected.get(0).toLowerCase().equals("default")) {
            String exp[] = {"repost", "facebook", "twitter", "vkontakte", "google", "tumblr", "odnoklassniki"};
            expected.addAll(Arrays.asList(exp));
            expected.remove("default");
        }
        if (actual.size() == expected.size()) {
            Boolean flag = true;
            int i = 0;
            while ((i < actual.size()) && (flag)) {
                if (actual.get(i).equals(expected.get(i))) {
                    i++;
                } else {
                    flag = false;
                }
            }
            return flag;
        } else {
            return false;
        }
    }
}
