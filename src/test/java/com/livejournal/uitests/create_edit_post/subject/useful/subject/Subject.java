package com.livejournal.uitests.create_edit_post.subject.useful.subject;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.EditJournalBml;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author s.savinykh
 */
public class Subject extends LJTest {

    //User create new post with subject(1/3)
    //User restore post with subject from draft(1/3)
    //Subject in editing(1/3)
    //User edit post with subject(1/3)
    //User create new post with long subject(1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_create_post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefaultStyle(name);
    }

    //User create new post with subject(2/3)
    //Subject in editing(2/3)
    //User edit post with subject(2/3)
    //User create new post with long subject(2/3)
    @When("user create new post with subject $subject")
    public void user_create_new_post_with_subject(String subject) {
        open(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .setSubject(subject)
                .setPostText(utility().random().getRandomText(30), "HTML")
                .usePage()
                .postEntry();
    }

    //User restore post with subject from draft(2/3)
    @When("user write new post with subject $subject")
    public void user_write_new_post_with_subject(String subject) {
        open(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .setSubject(subject)
                .setPostText(utility().random().getRandomText(30), "HTML");
    }

    //User create new post with subject(3/3)
    @Then("the post in journal has correct subject $subject")
    public void the_post_in_journal_has_correct_subject(String subject) {
        verify().that(onOpened(EntryPageLogged.class).Entry().getPostSubject().equals(subject))
                .ifResultIsExpected("User see correct post subject '" + subject + "'")
                .ifElse("User see incorrect post subject '" + onOpened(EntryPageLogged.class).Entry().getPostSubject() + "'. Correct subject is '" + subject + "'")
                .finish();
    }

    //User restore post with subject from draft(3/3)
    @Then("user can restore this post with subject $subject from draft")
    public void user_can_restore_this_post_with_subject_from_draft(String subject) throws InterruptedException {
        Thread.sleep(5000);
        open(UpdateBmlPageLogged.class)
                .restoreFromDraft();
        Thread.sleep(3000);
        verify().that(onOpened(UpdateBmlPageLogged.class).usePostContent().getSubject().equals(subject))
                .ifResultIsExpected("User see correct post subject in draft '" + subject + "'")
                .ifElse("User see incorrect post subject in draft '" + onOpened(UpdateBmlPageLogged.class).usePostContent().getSubject() + "'. Correct subject is '" + subject + "'")
                .finish();
    }

    //Subject in editing(3/3)
    @Then("user edit this post and see correct subject $subject")
    public void user_edit_this_post_and_see_correct_subject(String subject) {
        onOpened(EntryPageLogged.class)
                .Entry()
                .clickOnEditButton();
        verify().that(onOpened(EditJournalBml.class).usePostContent().getSubject().equals(subject))
                .ifResultIsExpected("User see correct post subject in editing '" + subject + "'")
                .ifElse("User see incorrect post subject in editing '" + onOpened(EditJournalBml.class).usePostContent().getSubject() + "'. Correct subject is '" + subject + "'")
                .finish();
    }

    //User edit post with subject(3/3)
    @Then("user edit this post with a new subject $newsubject and see correct subject in post")
    public void user_edit_this_post_with_a_new_subject_and_see_correct_subject_in_post(String newsubject) {
        onOpened(EntryPageLogged.class)
                .Entry()
                .clickOnEditButton()
                .usePostContent()
                .setSubject("")
                .setSubject(newsubject)
                .useEditingPage()
                .saveEntry();
        verify().that(onOpened(EntryPageLogged.class).Entry().getPostSubject().equals(newsubject))
                .ifResultIsExpected("User see correct post subject '" + newsubject + "'")
                .ifElse("User see incorrect post subject '" + onOpened(EntryPageLogged.class).Entry().getPostSubject() + "'. Correct subject is '" + newsubject + "'")
                .finish();
    }
    
    //User create new post with long subject(3/3)
    @Then("the post in journal has correct trimmed subject $subject")
    public void the_post_in_journal_has_correct_trimmed_subject(String subject) {
        subject = subject.substring(0,100);
        verify().that(onOpened(EntryPageLogged.class).Entry().getPostSubject().equals(subject))
                .ifResultIsExpected("User see correct post subject '" + subject + "'")
                .ifElse("User see incorrect post subject '" + onOpened(EntryPageLogged.class).Entry().getPostSubject() + "'. Correct subject is '" + subject + "'")
                .finish();
    }

}
