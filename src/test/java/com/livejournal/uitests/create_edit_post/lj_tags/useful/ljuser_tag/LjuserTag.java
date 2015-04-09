package com.livejournal.uitests.create_edit_post.lj_tags.useful.ljuser_tag;

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

    //Logged user create new post with correct lj-user tag (1/3)
    //Logged user create new post with uncorrect lj-user tag (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) throws InterruptedException {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .defaultStyle(name);
        open(UpdateBmlPageLogged.class);
    }

    //Logged user create new post with correct lj-user tag (2/3)
    @When("user enter correct username $ljuser in ljuser bubble and create new post")
    public void user_ener_correct_username_in_ljuser_bubble_and_create_new_post(String ljuser) {
        String postText = RandomText.getRandomText(30) + " ";
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost("", "html", postText)
                .openLJUserBubble()
                .onDisplayed(LJUserBubble.class)
                .enterCorrectUsername(ljuser);
        onOpened(UpdateBmlPageLogged.class)
                .postEntry();
    }

    //Logged user create new post with uncorrect lj-user tag (2/3)
    @When("user enter incorrect username $ljuser in ljuser bubble and try to post new entry")
    public void user_enter_incorrect_username_in_ljuser_bubble(String ljuser) {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost("", "html", "")
                .openLJUserBubble()
                .onDisplayed(LJUserBubble.class)
                .enterIncorrectUsername(ljuser);
    }

    //Logged user create new post with correct lj-user tag (3/3)
    @Then("the post is in journal and contains correct username $ljuser")
    public void post_is_in_journal_and_contains_correct_username(String ljuser) {
        verify().that(onOpened(EntryPage.class).containsLjUser(ljuser))
                .ifResultIsExpected("Username " + ljuser + " displaying correctly in post")
                .ifElse("Username " + ljuser + " displaying incorrectly in post")
                .finish();
    }

    //Logged user create new post with uncorrect lj-user tag (3/3)
    @Then("user see an error in header")
    public void user_see_an_error_in_header() {
        verify().that(onOpened(UpdateBmlPageLogged.class).getErrorStrip().getErrorText().toUpperCase().equals("INVALID USER"))
                .ifResultIsExpected("User see an error 'Invalid user'")
                .ifElse("User didn't see an error 'Invalid user'")
                .finish();
    }
}
