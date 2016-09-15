package com.livejournal.uitests.create_edit_post.video.useful;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AddVideoFromAlbum extends LJTest {

    //Scenario: add video from album(1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultLanguageLogged(name)
                .setDefault().defaultStyle(name);
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: add video from album(2/3)
    @When("add video from album (user, $name)")
    public void add_video_from_album(String name) {
        String videoId = getDBDate().video().getVideoIdWithSecurity(name, "public");
        String videoName = getDBDate().video().getVideoName(name, videoId);
        String albumName = getDBDate().video().getVideoAlbumName(name, videoId);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .useHTMLEditor()
                .setPostText(utility().random().getRandomText(30))
                .addVideoFromAlbum(albumName, videoName)
                .usePage()
                .postEntry();
        ThucydidesUtils.putToSession("videoId", videoId);
    }

    //Scenario: add video from album(3/3)
    @Then("post contains video from album (user $name)")
    public void post_contains_video_from_album(String name) {
        String videoIdInDb = ThucydidesUtils.getFromSession("videoId").toString();
        String videoIdInUrl = getDBDate().video().getVideoIdInUrl(name, videoIdInDb);
        verify().that(onOpened(EntryPageLogged.class).postContainsVideoFromAlbum(videoIdInUrl))
                .ifResultIsExpected("Video with link=" + videoIdInUrl + " is displayed")
                .ifElse("Video with link=" + videoIdInUrl + " is not displayed")
                .finish();;
    }
}
