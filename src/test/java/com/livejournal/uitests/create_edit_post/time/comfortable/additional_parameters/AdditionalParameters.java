package com.livejournal.uitests.create_edit_post.time.comfortable.additional_parameters;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.pages.service_pages.update.content.FinishPostForm;
import com.livejournal.uitests.utility.date.PostTime;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class AdditionalParameters extends LJTest {

    //Scenario: Sticky post (1/3)
    //Scenario: Location, mood and music (1/3)
    //Scenario: Check-boxes (1/3)
    //Scenario: Three posts(1/3)
    //Scenario: Drop-down menu (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultLanguageLogged(name)
                .setDefault().defaultStyle(name);
        open(SheduledEntriesPage.class)
                .deleteAllSheduledEntries();
        open(UpdateBmlPageLogged.class);
        String post_text = utility().random().getRandomText(30);
        ThucydidesUtils.putToSession("post_text", post_text.trim());
    }

    //Scenario: Sticky post (2/3)
    @When("user create new sheduied post sticky")
    public void user_create_new_sheduied_post_sticky() {
        String[] date = PostTime.getCorrectDate("hour", "5")
                .split(";");
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setDateAndTime(date[0], date[1])
                .useAdditionalContent()
                .setStickyPost()
                .usePostContent()
                .useHTMLEditor()
                .setPostText(ThucydidesUtils.getFromSession("post_text").toString())
                .usePage()
                .postEntry();
    }

    //Scenario: Location, mood and music (2/3)
    @When("user create new sheduied post with right element $element (content $content)")
    public void user_create_new_sheduied_post_with_right_element(String element, String content) {
        String[] date = PostTime.getCorrectDate("hour", "5")
                .split(";");
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setDateAndTime(date[0], date[1])
                .useAdditionalContent()
                .setRightBlockContent(element, content)
                .usePostContent()
                .useHTMLEditor()
                .setPostText(ThucydidesUtils.getFromSession("post_text").toString())
                .usePage()
                .postEntry();
    }

    //Scenario: Check-boxes (2/3)
    @When("user create new sheduied post with check-boxes $checkbox")
    public void user_create_new_sheduied_pos_wit_checkboxes(String checkbox) {
        String[] date = PostTime.getCorrectDate("hour", "5")
                .split(";");
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setDateAndTime(date[0], date[1])
                .useAdditionalContent()
                .setFoRIgnore(checkbox)
                .usePostContent()
                .useHTMLEditor()
                .setPostText(ThucydidesUtils.getFromSession("post_text").toString())
                .usePage()
                .postEntry();
    }

    //Scenario: Three posts (2/3)
    @When("user create new sheduied post with Three posts")
    public void user_create_new_sheduied_post_with_Three_posts() {
        String[] date = PostTime.getCorrectDate("hour", "5")
                .split(";");
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setDateAndTime(date[0], date[1])
                .useAdditionalContent()
                .setThreePosts()
                .usePostContent()
                .useHTMLEditor()
                .setPostText(ThucydidesUtils.getFromSession("post_text").toString())
                .usePage()
                .postEntry();
    }

    //Scenario: Drop-down menu (2/3)
    @When("user create new sheduied post with drop-down menu content $content")
    public void user_create_new_sheduied_post_with_dropdown_menu(String content) {
        String[] date = PostTime.getCorrectDate("hour", "5")
                .split(";");
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setDateAndTime(date[0], date[1])
                .useAdditionalContent()
                .setThreePosts()
                .usePostContent()
                .useHTMLEditor()
                .setPostText(ThucydidesUtils.getFromSession("post_text").toString())
                .usePage()
                .postEntry();
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

    //Scenario: Location, mood and music (3/3)
    @Then("the post is scheduled with right element $element (content $content)")
    public void post_is_scheduled_with_right_element(String element, String content) {
        String text = onDisplayed(FinishPostForm.class)
                .clickToScheduledLink()
                .editSheduledEntryByText(ThucydidesUtils.getFromSession("post_text").toString())
                .useAdditionalContent()
                .getRightBlockContent(element);
        verify().that(text.contains(content))
                .ifResultIsExpected("Content in " + element + " is correct: " + text)
                .ifElse("Content in " + element + "is incorrect: " + text + ". Correct content is '" + content + "'")
                .finish();
    }

    //Scenario: Check-boxes (3/3)
    @Then("the post is scheduled with check-boxes $checkbox")
    public void post_is_scheduled_with_checkboxes(String checkbox) {
        Boolean checkboxState = onDisplayed(FinishPostForm.class)
                .clickToScheduledLink()
                .editSheduledEntryByText(ThucydidesUtils.getFromSession("post_text").toString())
                .useAdditionalContent()
                .getFoRIgnore(checkbox);
        verify().that(checkboxState)
                .ifResultIsExpected("Check-box " + checkbox + " is set")
                .ifElse("Check-box " + checkbox + " is not set")
                .finish();
    }

    //Scenario: Three posts (3/3)
    @Then("the post is scheduled with Three posts")
    public void post_is_scheduled_with_Three_posts() {
        Boolean threePostsState = onDisplayed(FinishPostForm.class)
                .clickToScheduledLink()
                .editSheduledEntryByText(ThucydidesUtils.getFromSession("post_text").toString())
                .useAdditionalContent()
                .getThreePosts();
        verify().that(threePostsState)
                .ifResultIsExpected("Three posts is set")
                .ifElse("Three posts is not set")
                .finish();
    }
}
