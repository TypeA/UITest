package com.livejournal.uitests.create_edit_post.lj_tags.comfortable.ljuser_tag;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.pages.service_pages.update.bubbles.LJUserBubble;
import com.livejournal.uitests.utility.RandomText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author s.savinykh
 */
public class LjuserTag extends WebTest {

    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) throws InterruptedException {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .defaultStyle(name);
        open(UpdateBmlPageLogged.class);
        ThucydidesUtils.putToSession("user", name);
    }

    @When("user enter username $ljuser in ljuser bubble and create new post")
    public void user_ener_username_in_ljuser_bubble_and_create_new_post(String ljuser) throws InterruptedException {
        String postText = RandomText.getRandomText(30) + " ";
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost("", "html", postText)
                .openLJUserBubble()
                .onDisplayed(LJUserBubble.class)
                .enterUsername(ljuser)
                .clickSubmitButton();
        onOpened(UpdateBmlPageLogged.class)
                .postEntry();
    }

    @Then("the post is in journal and contains correct username $ljuser")
    public void post_is_in_journal_and_contains_correct_username(String ljuser) {
        verify().that(onOpened(EntryPage.class)
                .containsLjUser(ljuser))
                .ifResultIsExpected("Username " + ljuser + " displaying correctly in post")
                .ifElse("Username " + ljuser + " displaying incorrectly in post")
                .finish();
    }
}
