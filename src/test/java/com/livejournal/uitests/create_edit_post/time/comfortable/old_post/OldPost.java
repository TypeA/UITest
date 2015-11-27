package com.livejournal.uitests.create_edit_post.time.comfortable.old_post;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.utility.date.PostTime;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class OldPost extends LJTest {

    //Scenario: Create old post (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .setDefaultStyle(name);
        open(SheduledEntriesPage.class)
                .deleteAllSheduledEntries();
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: Create old post (2/3)
    @When("user create new post and change parameter $parameter by value $value")
    public void user_create_new_post_and_change_date(String parameter, String value) {
        ThucydidesUtils.putToSession("post_date", PostTime.getCorrectDate(parameter, value));
        String[] date = ThucydidesUtils
                .getFromSession("post_date")
                .toString()
                .split(";");
        String post_text = utility().random().getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setDateAndTime(date[0], date[1])
                .usePostContent()
                .setSubject("New old post")
                .setPostText(post_text, "html")
                .usePage()
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
    }

    //Scenario: Old post (3/3)
    @Then("the post is in journal")
    public void the_post_is_in_journal() {
        String post_text = onOpened(EntryPageLogged.class)
                .Entry()
                .getPostText().trim();
        String post_time = onOpened(EntryPageLogged.class)
                .Entry()
                .getPostTime();
        verify().that(post_time.contains(PostTime.convertPostTime(ThucydidesUtils.getFromSession("post_date").toString(), "post")))
                .ifResultIsExpected("Post is in journal, whis correct date: \n'" + PostTime.convertPostTime(ThucydidesUtils.getFromSession("post_date").toString(), "post") + "'")
                .ifElse("There is correct date \n'" + post_time + "'\n in post")
                .and()
                .that(post_text.contains(ThucydidesUtils.getFromSession("post_text").toString().trim()))
                .ifResultIsExpected("Post with text \n'" + ThucydidesUtils.getFromSession("post_text").toString() + "'\n is in journal")
                .ifElse("Post with incorrect text \n'" + post_text + "'\n is in journal")
                .finish();
    }

}
