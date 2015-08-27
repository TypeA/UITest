package com.livejournal.uitests.create_edit_post.time.useful.scheduled_post;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.pages.service_pages.update.content.FinishPostForm;
import com.livejournal.uitests.utility.RandomName;
import com.livejournal.uitests.utility.RandomText;
import com.livejournal.uitests.utility.date.PostTime;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class ScheduledPost extends WebTest {

    //Scenario: Create scheduled post (1/3)
    //Scenario: Create scheduled post with several privacy (1/3)
    //Scenario: Publication of scheduled post (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .defaultStyle(name)
                .defaultMinSecurity(name);
        open(SheduledEntriesPage.class)
                .deleteAllSheduledEntries();
        open(UpdateBmlPageLogged.class);
        ThucydidesUtils.putToSession("user", name);
    }

    //Scenario: Edit scheduled post (1/3)
    //Scenario: Edit privacy in scheduled post (1/3)
    //Scenario: Delete scheduled post (1/3)
    @Given("logged user $name with scheduled post on Scheduled post Page")
    public void logged_user_with_scheduled_post_on_Scheduled_post_Page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .defaultStyle(name);
        open(SheduledEntriesPage.class)
                .deleteAllSheduledEntries();
        String[] date = PostTime.getCorrectDate("hour", "1")
                .split(";");
        String post_text = RandomText.getRandomText(10).trim();

        open(UpdateBmlPageLogged.class)
                .closeDraft()
                .setDateAndTime(date[0], date[1])
                .usePostContent()
                .setSubject("Sheduled post for deleting or editing")
                .setPostText(post_text, "html")
                .usePage()
                .postEntry();
        ThucydidesUtils.putToSession("number_of_entryes", open(SheduledEntriesPage.class).getNumberOfEntryes());
        ThucydidesUtils.putToSession("post_text", post_text);
    }

    //Scenario: Create scheduled post (2/3)
    //Scenario: Publication of scheduled post (2/3)
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
                .setDateAndTime(date[0], date[1])
                .usePostContent()
                .setSubject("New scheduled post")
                .setPostText(post_text, "html")
                .usePage()
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text.trim());
    }

    //Scenario: Create scheduled post with several privacy (2/3)
    @When("user create new scheduled post with privacy $privacy (group $group)")
    public void user_create_new_scheduled_post_with_privacy(String privacy, String group) {
        ArrayList<String> groups = new ArrayList<String>();
        groups.add(group);
        String[] date = PostTime.getCorrectDate("hour", "1")
                .split(";");
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setDateAndTime(date[0], date[1])
                .usePostContent()
                .setSubject("New scheduled post")
                .setPostText(post_text, "html")
                .setPrivacy(privacy, groups)
                .usePage()
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text.trim());
    }

    //Scenario: Edit scheduled post (2/3)
    //Scenario: Edit privacy in scheduled post (2/3)
    @When("user edit element $element by change $changes in the scheduled post")
    public void user_edit_the_scheduled_post(String element, String changes) {
        ThucydidesUtils.putToSession("changes", new RandomName(changes).get());
        onOpened(SheduledEntriesPage.class)
                .editSheduledEntryByText(element, ThucydidesUtils.getFromSession("changes").toString(), ThucydidesUtils.getFromSession("post_text").toString());
        if (element.toUpperCase().equals("TEXT")) {
            ThucydidesUtils.putToSession("post_text", ThucydidesUtils.getFromSession("changes").toString());
        }
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

    //Scenario: Publication of scheduled post (3/3)
    @Then("the post is publicated in correct time")
    public void post_is_publicated_in_correct_time() throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            if (PostTime.getCurrentDate().equals(ThucydidesUtils.getFromSession("post_date"))) {
                i = 30;
                Thread.sleep(60000);
            } else {
                Thread.sleep(10000);
            }
        }
        open(MyJournalPage.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("user").toString() + "."));
        String post_time = onOpened(MyJournalPage.class)
                .openPostByText(ThucydidesUtils.getFromSession("post_text").toString())
                .getPostTime();
        verify().that(post_time.contains(PostTime.convertPostTime(ThucydidesUtils.getFromSession("post_date").toString(), "post")))
                .ifResultIsExpected("Post is injournal, whith correct date: "
                        + PostTime.convertPostTime(ThucydidesUtils.getFromSession("post_date").toString(), "post"))
                .ifElse("Incorrect post time " + post_time + " in journal")
                .finish();
    }

    //Scenario: Create scheduled post with several privacy (3/3)
    @Then("the post is scheduled with privacy $privacy")
    public void the_post_is_scheduled_with_privacy(String privacy) {
        String post_privacy = onDisplayed(FinishPostForm.class)
                .clickToScheduledLink()
                .getPrivacyByText(ThucydidesUtils.getFromSession("post_text").toString())
                .trim()
                .toUpperCase();
        verify().that(post_privacy.contains(privacy.toUpperCase()))
                .ifResultIsExpected("Post is scheduled, whis correct privacy: " + privacy)
                .ifElse("Post is scheduled, whis incorrect privacy: " + post_privacy)
                .finish();
    }

    //Scenario: Edit privacy in scheduled post (3/3)
    @Then("privacy $changes in the scheduled post is editing")
    public void privacy_in_the_scheduled_post_is_editing(String changes) {
        if (changes.contains("/")) {
            changes = changes.substring(0, changes.indexOf('/'));
        }
        String post_privacy = onDisplayed(FinishPostForm.class)
                .clickToScheduledLink()
                .getPrivacyByText(ThucydidesUtils.getFromSession("post_text").toString())
                .trim()
                .toUpperCase();
        verify().that(post_privacy.contains(changes.toUpperCase()))
                .ifResultIsExpected("Post is scheduled, whis correct privacy: " + changes)
                .ifElse("Post is scheduled, whis incorrect privacy: " + post_privacy)
                .finish();
    }

    //Scenario: Edit scheduled post (3/3)
    @Then("the scheduled post is editing")
    public void scheduled_post_is_editing() {
        Integer entries_number = open(SheduledEntriesPage.class)
                .getNumberOfEntryes();
        String entry_text = onOpened(SheduledEntriesPage.class)
                .getPostByText(ThucydidesUtils.getFromSession("post_text").toString())
                .trim();
        verify().that(entries_number.equals(ThucydidesUtils.getFromSession("number_of_entryes")))
                .ifResultIsExpected("The correct amount of scheduled posts: " + ThucydidesUtils.getFromSession("number_of_entryes"))
                .ifElse("The incorrect amount of scheduled posts: " + entries_number)
                .and()
                .that(entry_text.contains(ThucydidesUtils.getFromSession("post_text").toString()))
                .ifResultIsExpected("The post is editing by value: " + ThucydidesUtils.getFromSession("post_text"))
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
