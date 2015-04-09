package com.livejournal.uitests.create_edit_post.create_post.useful.post_subject;

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
 * @author s.savinykh
 */
public class PostSubject extends WebTest {

    //Logged user create new post with subject(1/3)
    //Logged user restore post with subject from draft(1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_create_post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultStyle(name);
    }

    //Logged user create new post with subject(2/3)  
    @When("user create new post with subject $subject")
    public void user_create_new_post_with_subject(String subject) {
        open(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost(subject, "HTML", RandomText.getRandomText(30))
                .postEntry();
    }

    //Logged user restore post with subject from draft(2/3)
    @When("user write new post with subject $subject")
    public void user_write_new_post_with_subject(String subject) {
        open(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost(subject, "HTML", RandomText.getRandomText(30));
    }

    //Logged user create new post with subject(3/3)
    @Then("the post in journal has correct subject $subject")
    public void the_post_in_journal_has_correct_subject(String subject) {
        verify().that(onOpened(EntryPage.class).getPostSubject().equals(subject))
                .ifResultIsExpected("User see correct post subject '" + subject + "'")
                .ifElse("User see incorrect post subject '" + onOpened(EntryPage.class).getPostSubject() + "'. Correct subject is '" + subject + "'")
                .finish();
    }

    //Logged user restore post with subject from draft(3/3)
    @Then("user can restore this post with subject $subject from draft")
    public void user_can_restore_this_post_with_subject_from_draft(String subject) throws InterruptedException {
        Thread.sleep(5000);
        open(UpdateBmlPageLogged.class)
                .restoreFromDraft();
        Thread.sleep(3000);
        verify().that(onOpened(UpdateBmlPageLogged.class).getPostSubject().equals(subject))
                .ifResultIsExpected("User see correct post subject in draft '" + subject + "'")
                .ifElse("User see incorrect post subject in draft '" + onOpened(UpdateBmlPageLogged.class).getPostSubject() + "'. Correct subject is '" + subject + "'")
                .finish();
    }

}
