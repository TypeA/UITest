package com.livejournal.uitests.create_edit_post.create_post.useful.create_post;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.utility.RandomText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class CreatePost extends WebTest {

    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defoultLanguage(name);
        open(UpdateBmlPageLogged.class);
    }

    @When("user create new post")
    public void user_create_new_post_and_change_date(String parameter, String value) {
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost("New post", "html", post_text)
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
    }

    @Then("the post is in journal")
    public void the_post_is_in_journal() {
        String post_text = onOpened(EntryPage.class)
                .getPostText().trim();
        verify().that(post_text.contains(ThucydidesUtils.getFromSession("post_text").toString().trim()))
                .ifResultIsExpected("Post with text \n'" + ThucydidesUtils.getFromSession("post_text").toString() + "'\n is in journal")
                .ifElse("Post with incorrect text \n'" + post_text + "'\n is in journal")
                .finish();
    }

}
