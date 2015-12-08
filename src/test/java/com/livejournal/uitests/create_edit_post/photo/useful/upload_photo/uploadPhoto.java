package com.livejournal.uitests.create_edit_post.photo.useful.upload_photo;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class uploadPhoto extends LJTest {
//не реализованы эти тесты
    //Scenario: upload photo to post with different privacy(1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name);
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: upload photo to post with different privacy(2/3)
    @When("upload photo to post with privacy $privacy")
    public void upload_photo_to_post_with_privacy(String privacy) {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .useHTMLEditor()
                .uploadPhotoToPostWithPrivacy("dsada", privacy);//не работает
               // .postEntry();
    }
    
    //Scenario: upload photo to post with different privacy(3/3)
    @Then("post contains photo with privacy $privacy")
    public void post_contains_photo_with_privacy(){

    }
}
