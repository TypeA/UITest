package com.livejournal.uitests.IN_PROGRESS.photo.useful.add_from_album;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class addFromAlbum extends LJTest {

    //Scenario: add photo to post from album(1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultLanguageLogged(name)
                .setDefault().defaultStyle(name);
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: add photo to post from album(2/3)
    @When("create post with photo from album with link $link and with size $size (user, $name)")
    public void create_post_with_photo_from_album_with_link_and_with_size(String name, String link, String size) throws InterruptedException {
        String phototIdInDb = getDBDate().photo().getRandomPhotoIdWithSizeAndSecurity(name, "public", size);
        String album = getDBDate().photo().getAlbumContainsPhotoId(phototIdInDb, name);
        String photoIdInUrl = getDBDate().photo().getPhotoIdInUrl(name, phototIdInDb);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .useHTMLEditor()
                .setPostText(utility().random().getRandomText(30))
                .addPhotoFromAlbumToPost(album, photoIdInUrl, link, size)
                .usePage()
                .postEntry();
        ThucydidesUtils.putToSession("photoByUrl", photoIdInUrl);
    }

    //Scenario: add photo to post from album(3/3)
    @Then("post contains photo with link $link and size $size (user, $name)")
    public void post_contains_photo_with_link_and_size(String name, String link, String size) {
        String photoId = ThucydidesUtils.getFromSession("photoByUrl").toString();
        String userId = getDBDate().userData().getUserId(name);
        String linkPhoto = name + "/" + userId + "/" + photoId+"/"+photoId+"_";
        if (Boolean.valueOf(link)) {
            link = linkPhoto+"original";
        } else {
            link = "";
        }
        verify().that(onOpened(EntryPageLogged.class).postWithImageIsDisplayed(linkPhoto+size.toLowerCase(), link, ""))
                .ifResultIsExpected("Post is displayed with url " + linkPhoto) 
                .ifElse("Post isn't displayed with url " + linkPhoto)
                .finish();

    }
}
