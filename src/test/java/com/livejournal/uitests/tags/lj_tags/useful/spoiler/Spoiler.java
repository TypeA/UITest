package com.livejournal.uitests.tags.lj_tags.useful.spoiler;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
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
public class Spoiler extends LJTest {

    //Scenario: User can create new entry with spoiler (1/3)
    //Scenario: User can create new entry with custom title in spoiler (1/3)
    //Scenario: Spoiler works on feed (1/3)
    //Scenario: Spoiler with custom text on feed (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        ThucydidesUtils.putToSession("name", name);
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultStyle(name);
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: User can create new entry with spoiler (2/3)
    //Scenario: User can create new entry with custom title in spoiler (2/3)
    //Scenario: Spoiler works on feed (2/3)
    //Scenario: Spoiler with custom text on feed (2/3)
    @When("user use spoiler $spoiler and put some text in it")
    public void user_use_spoiler_and_put_some_information_in_it(String spoiler) {
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
                .setSpoiler(spoiler)
                .putTextBetweenTags(before, text, after)
                .usePage()
                .postEntry();
    }

    //Scenario: User can create new entry with spoiler (3/3)
    @Then("the post is in journal and contains spoiler with some information in it")
    public void post_in_journal_and_contains_ljcut_with_some_information_in_it() {
        verify().that(onOpened(EntryPageLogged.class).Entry().getTextSpoiler(ThucydidesUtils.getFromSession("text").toString()).equals(ThucydidesUtils.getFromSession("text").toString()))
                .ifResultIsExpected("The spoiler is working properly")
                .ifElse("The spoiler doesn't work properly")
                .finish();

    }

    //Scenario: User can create new entry with custom title in spoiler (3/3)
    @Then("the post is in journal and contains spoiler with custom title $spoiler")
    public void post_in_journal_and_contains_spoiler_with_custom_title(String spoiler) {
        verify().that(onOpened(EntryPageLogged.class).Entry().getSpoilerCustomText(ThucydidesUtils.getFromSession("text").toString()).equals(spoiler))
                .ifResultIsExpected("The spoiler title displaying correctly")
                .ifElse("The spoiler title displaying incorrect")
                .finish();
    }

    //Scenario: Spoiler works on feed (3/3)
    @Then("the post is on feed and contains spoiler with some information in it")
    public void post_on_feed_and_contains_ljcut_with_some_information_in_it(String name) {
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."));
        verify().that(onOpened(FriendsFeedLogged.class).feed().getTextSpoiler(ThucydidesUtils.getFromSession("text").toString()).equals(ThucydidesUtils.getFromSession("text").toString()))
                .ifResultIsExpected("The spoiler is working properly")
                .ifElse("The spoiler doesn't work properly")
                .finish();

    }

    //Scenario: Spoiler with custom text on feed (3/3)
    @Then("the post is on feed and contains spoiler with custom title $spoiler")
    public void post_on_feed_and_contains_spoiler_with_custom_title(String spoiler,String name) {
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."));
        verify().that(onOpened(FriendsFeedLogged.class).feed().getSpoilerCustomText(ThucydidesUtils.getFromSession("text").toString()).equals(spoiler))
                .ifResultIsExpected("The spoiler title displaying correctly")
                .ifElse("The spoiler title displaying incorrect")
                .finish();
    }
}
