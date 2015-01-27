package com.livejournal.uitests.post_privacy.useful.users_post;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.utility.RandomText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class UsersPost extends WebTest {

    //Scenario: Create post (1/4)
    //Scenario: Privacy in editing (1/3)
    //Scenario: Restore privacy from draft (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getUserPassword(name));
        open(UpdateBmlPageLogged.class);
        ThucydidesUtils.putToSession("user", name);
    }

    //Scenario: Create post (2/4)
    //Scenario: Privacy in editing(2/3)
    @When("user create new post with privacy $privacy (group $group)")
    public void user_create_new_post_with_privacy(String privacy, String group) {
        String postText = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost("", "html", postText)
                .setPrivacy(privacy, group)
                .postEntry();
        String postfix = getCurrentBrowser().getDriver().getCurrentUrl();
        postfix = postfix.replace("livejournal.ru/", "!");
        ThucydidesUtils.putToSession("post_link", postfix.substring(postfix.indexOf("!") + 1));
        ThucydidesUtils.putToSession("post_text", postText);
    }

    //Scenario: Restore privacy from draft (1/3)
    @When("user write new post with privacy $privacy (group $group)")
    public void user_write_new_post_with_privacy(String privacy, String group) {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setPrivacy(privacy, group);
    }

    //Scenario: Create post (3/4)
    @Then("user $name_1 can read the post")
    public void user_can_read_post(String name_1) throws InterruptedException {
        open(MainPageLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
        if (name_1.isEmpty()) {
        } else {
            open(LoginPageUnlogged.class)
                    .authorizeBy(name_1, getUserPassword(name_1));
        }
        open(EntryPage.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        String postText = ThucydidesUtils.getFromSession("post_text").toString();
        verify().that(postText.contains(onOpened(EntryPage.class).getPostText()))
                .ifResultIsExpected("User can see post '" + postText + "'")
                .ifElse("User cannot see post '" + postText + "', but see '" + onOpened(EntryPage.class).getPostText() + "'")
                .finish();
        open(MainPageLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
    }

    //Scenario: Create post (4/4)
    @Then("user $name_2 cannot read the post")
    public void user_cannot_read_post(String name_2) throws InterruptedException {
        if (name_2.isEmpty()) {
            verify().that(true)
                    .ifResultIsExpected("All user can see post")
                    .ifElse("")
                    .finish();
        } else {
            open(LoginPageUnlogged.class)
                    .authorizeBy(name_2, getUserPassword(name_2));
            open(MyJournalPage.class, new Url()
                    .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                    .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
            String error = getCurrentBrowser()
                    .getDriver()
                    .getTitle();
            verify().that(error.contains("Access is closed"))
                    .ifResultIsExpected("User can see error 'Access is closed'")
                    .ifElse("User cannot see error 'Access is closed!', but see '" + error + "'")
                    .finish();
        }
    }

    //Scenario: Privacy in editing(3/3)
    @Then("user see correct privacy &privacy when edit this post")
    public void user_see_correct_privacy_when_edit_this_post(String privacy) throws InterruptedException {
        open(EntryPage.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
    }

    //Scenario: Restore privacy from draft (3/3)
    @Then("user can restore this post with privacy <privacy> from draft")
    public void user_can_restore_this_post_with_privacy_from_draft() {
        onOpened(UpdateBmlPageLogged.class)
                .restoreFromDraft();
    }

}
