package com.livejournal.uitests.create_edit_post.subject.comfortable.html_tags_in_subject;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class HtmlTagsInSubject extends LJTest {

    //Scenario: Subject with correct html tags (1/3)
    //Scenario: Subject with cropped html tags(1/3)
    //Scenario: Subject with incorrect html tags (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_create_post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultStyle(name);
    }

    //Scenario: Subject with correct html tags (2/3)
    //Scenario: Subject with cropped html tags(2/3)
    //Scenario: Subject with incorrect html tags (2/3)
    @When("user create new post with subject $subject")
    public void user_create_new_post_with_subject(String subject) {
        open(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .setSubject(subject)
                .useHTMLEditor()
                .setPostText(utility().random().getRandomText(30))
                .usePage()
                .postEntry();
    }

    //Scenario: Subject with correct html tags(3/3)
    @Then("the post in journal has subject $subject with correct tag")
    public void correct_tag(String subject) {
        verify().that(onOpened(EntryPageLogged.class)
                .Entry()
                .getPostSubject()
                .equals(cutSubject(subject)))
                .ifResultIsExpected("User see correct post subject '" + cutSubject(subject) + "'")
                .ifElse("User see incorrect post subject '" + onOpened(EntryPageLogged.class).Entry().getPostSubject())
                .and()
                .that(onOpened(EntryPageLogged.class)
                        .Entry()
                        .getTagsTextInSubject(cutTag(subject))
                        .contains(cutSubject(subject)))
                .ifResultIsExpected("Tag '" + cutTag(subject) + "' is worked")
                .ifElse("Tag '" + cutTag(subject) + "' is not worked")
                .finish();

    }

    //Scenario: Subject with cropped html tags(3/3)
    @Then("the post in journal has subject $subject with cropped tag")
    public void post_in_journal_has_subject_with_cropped_tag(String subject) {
        verify().that(onOpened(EntryPageLogged.class)
                .Entry()
                .getPostSubject()
                .equals(cutSubject(subject)))
                .ifResultIsExpected("User see correct post subject '" + cutSubject(subject) + "'")
                .ifElse("User see incorrect post subject '" + onOpened(EntryPageLogged.class).Entry().getPostSubject())
                .finish();
    }

    //Scenario: Subject with incorrect html tags (3/3)
    @Then("the post in journal has cultivated subject $cultivated_subject")
    public void post_in_journal_has_subject(String cultivated_subject) {
        verify().that(onOpened(EntryPageLogged.class).Entry().getPostSubject().equals(cultivated_subject))
                .ifResultIsExpected("User see correct post subject '" + cultivated_subject + "'")
                .ifElse("User see incorrect post subject '" + onOpened(EntryPageLogged.class).Entry().getPostSubject())
                .finish();
    }

    private String cutSubject(String subject) {
        String ans = subject.substring(subject.indexOf(">") + 1);
        return ans.substring(0, ans.indexOf("<"));
    }

    private String cutTag(String subject) {
        String tag = subject.substring(subject.indexOf("/") + 1);
        return tag.substring(0, tag.indexOf(">"));
    }

}
