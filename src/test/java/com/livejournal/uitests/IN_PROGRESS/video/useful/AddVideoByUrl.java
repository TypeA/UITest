package com.livejournal.uitests.IN_PROGRESS.video.useful;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AddVideoByUrl extends LJTest {

    //Scenario: add video by url(1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultLanguageLogged(name)
                .setDefault().defaultStyle(name);
        open(UpdateBmlPageLogged.class);
    }
       
    //Scenario: add video by url(2/3)
    @When("add video by url $video_url")
    public void add_video_by_url(String video_url) {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .useHTMLEditor()
                .setPostText(utility().random().getRandomText(30))
                .addVideoByUrl(video_url)
                .usePage()
                .postEntry();
    }
    
    //Scenario: add video by url(3/3)
    @Then("post contains video by url $video_url")
    public void post_contains_video_by_url(String video_url){
     verify().that(onOpened(EntryPageLogged.class).postWithVideoIsDisplayed(video_url))
             .ifResultIsExpected("Video with link="+video_url+" is displayed")
             .ifElse("Video with link="+video_url+" is not displayed")
             .finish();
    }
}
