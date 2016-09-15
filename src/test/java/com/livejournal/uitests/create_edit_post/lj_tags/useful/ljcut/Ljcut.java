package com.livejournal.uitests.create_edit_post.lj_tags.useful.ljcut;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.journal_pages.journal.MyJournalPageLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author s.savinykh
 */
public class Ljcut extends LJTest {

    //Scenario: User can create new entry with lj-cut (1/3)
    //Scenario: User can create new entry with custom title in lj-cut (1/3)
    //Scenario: LJ-cut works on feed (1/3)
    //Scenario: LJ-cut with custom text on feed (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        ThucydidesUtils.putToSession("name", name);
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultStyle(name);
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: User can create new entry with lj-cut (2/3)
    //Scenario: User can create new entry with custom title in lj-cut (2/3)
    //Scenario: LJ-cut works on feed (2/3)
    //Scenario: LJ-cut with custom text on feed (2/3)
    @When("user use lj-cut $ljcut and put some text in it")
    public void user_use_ljcut_and_put_some_information_in_it(String ljcut) {
        String before = utility().random().getRandomText(10);
        ThucydidesUtils.putToSession("before", before);

        String after = utility().random().getRandomText(10);
        ThucydidesUtils.putToSession("after", after);

        String text = utility().random().getRandomText(10);
        ThucydidesUtils.putToSession("text", text);

        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .useHTMLEditor()
                .setLJCut(ljcut)
                .putTextBetweenTags(before, text, after)
                .usePage()
                .postEntry();
    }

    //Scenario: User can create new entry with lj-cut (3/3)
    @Then("the post is in journal and contains lj-cut with some information in it")
    public void post_in_journal_and_contains_ljcut_with_some_information_in_it() {
        open(MyJournalPageLogged.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("name").toString() + "."));
        verify().that(onOpened(MyJournalPageLogged.class).getTextFromLJCut(ThucydidesUtils.getFromSession("before").toString()).equals(ThucydidesUtils.getFromSession("text").toString()))
                .ifResultIsExpected("The CUT is working properly")
                .ifElse("The cut doesn't work properly")
                .finish();

    }

    //Scenario: User can create new entry with custom title in lj-cut (3/3)
    @Then("the post is in journal and contains lj-cut with custom title $ljcut")
    public void post_in_journal_and_contains_ljcut_with_custom_title(String ljcut) {
        open(MyJournalPageLogged.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("name").toString() + "."));
        verify().that(onOpened(MyJournalPageLogged.class).getLJCutCustomText(ThucydidesUtils.getFromSession("before").toString()).equals(ljcut))
                .ifResultIsExpected("The ljcut title displaying correctly")
                .ifElse("The ljcut title displaying incorrect")
                .finish();
    }

    //Scenario: LJ-cut works on feed (3/3)
    @Then("the post is on feed and contains lj-cut with some information in it")
    public void post_on_feed_and_contains_ljcut_with_some_information_in_it() {
        onOpened(EntryPageLogged.class).clickOnFriendsFeedMenuItem();
        verify().that(onOpened(FriendsFeedLogged.class).feed().getTextFromLJCut(ThucydidesUtils.getFromSession("before").toString()).equals(ThucydidesUtils.getFromSession("text").toString()))
                .ifResultIsExpected("The ljcut is working properly")
                .ifElse("The ljcut doesn't work properly")
                .finish();

    }

    //Scenario: LJ-cut with custom text on feed (3/3)
    @Then("the post is on feed and contains lj-cut with custom title $ljcut")
    public void post_on_feed_and_contains_spoiler_with_custom_title(String ljcut) {
        onOpened(EntryPageLogged.class).clickOnFriendsFeedMenuItem();
        verify().that(onOpened(FriendsFeedLogged.class).feed().getLJCutCustomText(ThucydidesUtils.getFromSession("before").toString()).equals(ljcut))
                .ifResultIsExpected("The ljcut title displaying correctly")
                .ifElse("The ljcut title displaying incorrect")
                .finish();
    }
}
