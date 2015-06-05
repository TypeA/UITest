package com.livejournal.uitests.create_edit_post.time.comfortable.additional_parameters;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.pages.service_pages.update.content.FinishPostForm;
import com.livejournal.uitests.utility.RandomText;
import com.livejournal.uitests.utility.date.PostTime;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class AdditionalParameters extends WebTest {

    //Scenario: Sticky post (1/3)
    //Scenario: Location, mood and music (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .defaultStyle(name);
        open(SheduledEntriesPage.class)
                .deleteAllSheduledEntries();
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: Sticky post (2/3)
    @When("user create new sheduied post sticky")
    public void user_create_new_sheduied_post_sticky() {
        String[] date = PostTime.getCorrectDate("hour", "1")
                .split(";");
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setDateAndTime(date[0], date[1])
                .useAdditionalContent()
                .setStickyPost()
                .usePostContent()
                .setPostText(post_text, "html")
                .usePage()
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text.trim());
    }

    //Scenario: Location, mood and music (2/3)
    @When("user create new sheduied post with right element $element")
    public void user_create_new_sheduied_post_with_right_element(String element) {
        String[] date = PostTime.getCorrectDate("hour", "1")
                .split(";");
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setDateAndTime(date[0], date[1])
                .useAdditionalContent()
                .setStickyPost()
                .usePostContent()
                .setPostText(post_text, "html")
                .usePage()
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text.trim());
    }

    //Scenario: Sticky post (3/3)
    @Then("the Sticky post is scheduled")
    public void sticky_post_is_scheduled() {
        Boolean sticky = onDisplayed(FinishPostForm.class)
                .clickToScheduledLink()
                .editSheduledEntryByText(ThucydidesUtils.getFromSession("post_text").toString())
                .useAdditionalContent()
                .getStickyPost();
        verify().that(sticky)
                .ifResultIsExpected("The Sticky post is scheduled")
                .ifElse("The Sticky post is not scheduled")
                .finish();

    }
}
