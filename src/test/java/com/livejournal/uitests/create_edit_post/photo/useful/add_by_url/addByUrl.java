package com.livejournal.uitests.create_edit_post.photo.useful.add_by_url;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import java.io.IOException;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class addByUrl extends LJTest {

    //Scenario: add photo by url with different size(1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultLanguageLogged(name)
                .setDefault().defaultStyle(name);
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: add photo by url with different size(2/3)
    @When("add photo by url $photo_url with size $size and with link $link")
    public void add_photo_by_url_with_size_and_with_link(String name, String photo_url, String link, String size) throws IOException {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .useHTMLEditor()
                .setPostText(utility().random().getRandomText(30))
                .addPhotoByUrlToPost(photo_url, link, size)
                .usePage()
                .postEntry();
    }

    //Scenario: add photo by url with different size(3/3)
    @Then("post contains photo by url $photo_url and size $size and link $link")
    public void post_contains_photo_by_url_and_size_and_link(String photo_url, String link, String size) {
        verify().that(onOpened(EntryPageLogged.class).postWithImageIsDisplayed(photo_url, link, size))
                .ifResultIsExpected("Post is displayed with url " + photo_url)
                .ifElse("Post isn't displayed with url " + photo_url)
                .finish();
    }
}
