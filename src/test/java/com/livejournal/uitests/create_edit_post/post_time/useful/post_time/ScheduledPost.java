package com.livejournal.uitests.create_edit_post.post_time.useful.post_time;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.update.FinishPostForm;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.utility.RandomText;
import com.livejournal.uitests.utility.date.PostTime;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class ScheduledPost extends WebTest {

    //Scenario: Create scheduled post (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) throws InterruptedException {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .defaultStyle(name);
        open(SheduledEntriesPage.class)
                .deleteAllSheduledEntries();
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: Edit scheduled post (1/3)
    //Scenario: Delete scheduled post (1/3)
    @Given("logged user $name with scheduled post on Scheduled post Page")
    public void logged_user_with_scheduled_post_on_Scheduled_post_Page(String name) throws InterruptedException {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .defaultStyle(name);
        Integer number_of_entryes = open(SheduledEntriesPage.class)
                .getNumberOfEntryes();
        if (number_of_entryes < 1) {
            String[] date = PostTime.getCorrectDate("day", "1")
                    .split(";");
            open(UpdateBmlPageLogged.class)
                    .closeDraft()
                    .createPost("Sheduled post for deleting", "html", RandomText.getRandomText(30))
                    .setDateAndTime(date[0], date[1])
                    .postEntry();
            open(SheduledEntriesPage.class);
            number_of_entryes = number_of_entryes + 1;
        }
        ThucydidesUtils.putToSession("number_of_entryes", number_of_entryes);
    }

    //Scenario: Create scheduled post (2/3)
    @When("user create new post and change parameter $parameter by value $value")
    public void user_create_new_post_and_change_date(String parameter, String value) {
        ThucydidesUtils.putToSession("post_date", PostTime.getCorrectDate(parameter, value));
        String[] date = ThucydidesUtils
                .getFromSession("post_date")
                .toString()
                .split(";");
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost("New scheduled post", "html", post_text)
                .setDateAndTime(date[0], date[1])
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text.trim());
    }

    //Scenario: Edit scheduled post (1/3)
    @When("user edit element $element in the scheduled post")
    public void user_edit_the_scheduled_post(String element) throws InterruptedException {
        String post_text = RandomText.getRandomText(10); 
        ThucydidesUtils.putToSession("post_text", post_text.trim());
        onOpened(SheduledEntriesPage.class)
                .editFirstSheduledEntry(element, post_text);
    }

    //Scenario: Delete scheduled post (2/3)
    @When("user delete the scheduled post")
    public void user_delete_the_scheduled_post() {
        onOpened(SheduledEntriesPage.class)
                .deleteFirstSheduledEntry();
    }

    //Scenario: Create scheduled post (3/3)
    @Then("the post is scheduled")
    public void the_post_is_scheduled() {
        String post_text = onDisplayed(FinishPostForm.class)
                .clickToScheduledLink()
                .getPostByText(ThucydidesUtils.getFromSession("post_text").toString())
                .trim();
        verify().that(post_text.contains(PostTime.convertPostTime(ThucydidesUtils.getFromSession("post_date").toString(), "scheduled post")))
                .ifResultIsExpected("Post is scheduled, whis correct date: " + PostTime.convertPostTime(ThucydidesUtils.getFromSession("post_date").toString(), "scheduled post"))
                .ifElse("There is no post " + post_text + " in scheduled, with correct date")
                .finish();
    }

    //Scenario: Edit scheduled post (1/3)
    @Then("the scheduled post is editing")
    public void scheduled_post_is_editing() {
        Integer entries_number = open(SheduledEntriesPage.class)
                .getNumberOfEntryes();
        String entry_text = open(SheduledEntriesPage.class)
                .getFirstPostText()
                .trim();
        verify().that(entries_number.equals(ThucydidesUtils.getFromSession("number_of_entryes")))
                .ifResultIsExpected("The correct amount of scheduled posts: " + ThucydidesUtils.getFromSession("number_of_entryes"))
                .ifElse("The incorrect amount of scheduled posts: " + entries_number)
                .and()
                .that(entry_text.contains(ThucydidesUtils.getFromSession("post_text").toString()))
                .ifResultIsExpected("The post is editing by value: " + entry_text)
                .ifElse("The post is not editing by value: " + entry_text)
                .finish();
    }

    //Scenario: Delete scheduled post (3/3)
    @Then("the scheduled post is deleted")
    public void scheduled_post_is_deleted() {
        Integer number_of_entries = open(SheduledEntriesPage.class)
                .getNumberOfEntryes() + 1;
        verify().that(number_of_entries.equals(ThucydidesUtils.getFromSession("number_of_entryes")))
                .ifResultIsExpected("The scheduled post is deleted, I see " + ThucydidesUtils.getFromSession("number_of_entryes") + " scheduled posts")
                .ifElse("The scheduled post is not deleted, I see " + number_of_entries + " scheduled posts")
                .finish();
    }

}
