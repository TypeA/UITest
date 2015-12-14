package com.livejournal.uitests.pages.service_pages.update.content.editors;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.update.bubbles.BubblesUpdateBml;
import com.livejournal.uitests.pages.service_pages.update.content.UpdateBmlBlockes;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.panferova
 */
@Block(
        @FindBy(css = ".b-updatepage-event"))
public class HTMLEditor extends UpdateBmlBlockes {
    
    @FindBy(css = ".b-updatepage-tab-html")
    private Button htmlEditButton;

    @FindBy(css = ".b-updateform-textarea")
    private TextField postHtmlField;

    @FindBy(css = ".b-updateform-button.b-updateform-button-user")
    private BubbleButton ljUserButton;

    @FindBy(css = ".b-updateform-button-cut")
    private BubbleButton ljCutButton;

    @FindBy(css = ".b-updateform-button-spoiler")
    private BubbleButton spoiler;

    @FindBy(css = ".b-updateform-button.b-updateform-button-photo")
    private BubbleButton photoButton;

    @StepGroup
    public HTMLEditor setPostText(String text) {
        postHtmlField.enter(text);
        return this;
    }
    
    @StepGroup
    public HTMLEditor setUsername(String ljuser, Boolean isCorrectUser) {
        ljUserButton.click()
                .userBubble()
                .enterUsername(ljuser, isCorrectUser);
        return this;
    }
    
    @StepGroup
    public HTMLEditor setUserNameByAutocomplete(String ljuser) {
        ljUserButton.click()
                .userBubble()
                .enterUsernameUsingAutocomplete(ljuser);
        return this;
    }
    
    @StepGroup
    public HTMLEditor setLJCut(String ljcut) {
        ljCutButton.click()
                .cutBubble()
                .useLJCut(ljcut);
        return this;
    }
    
    @StepGroup
    public HTMLEditor setSpoiler(String spoilerText) {
        spoiler.click()
                .spoilerBubble()
                .useSpoiler(spoilerText);
        return this;
    }
    
    @StepGroup
    public HTMLEditor putTextBetweenTags(String before, String text, String after) {
        String postText = startScript("return jQuery('.b-updateform-textarea').val()").toString();
        postText = postText.replace("></", "> " + text + " </");
        postText = before + " " + postText + " " + after;
        startScript("jQuery('.b-updateform-textarea').val('" + postText + "')");
        return this;
    }
    
    @StepGroup
    public void uploadPhotoToPostWithPrivacy(String adress, String privacy) {
        photoButton.click()
                .photoBubble().uploadPhotoWithPrivacy(adress, privacy);
    }
    
    @StepGroup
    public HTMLEditor addPhotoByUrlToPost(String photoUrl, String link, String size) {
        photoButton.click()
                .photoBubble()
                .enterPhotoByUrl(photoUrl, link, size);
        return this;
    }
    
    @StepGroup
    public HTMLEditor addPhotoFromAlbumToPost(String album, String photoIdInUrl, String link, String size) {
        photoButton.click()
                .photoBubble()
                .enterPhotoFromAlbum(album, photoIdInUrl, link, size);
        return this;
    }

    public static class BubbleButton extends Button {

        public BubbleButton(WebElement wrappedElement) {
            super(wrappedElement);
        }

        @Override
        public BubblesUpdateBml click() {
            super.click();
            return onDisplayed(BubblesUpdateBml.class);
        }

    
    @StepGroup
    public HTMLEditor addVideoByUrl(String video) {
        clickButtonVideo().enterVideoByUrl(video);
        return this;
    }
    
    private PhotoBubble clickButtonPhoto() {
        photoButton.click();
        return onDisplayed(PhotoBubble.class);
    }
    
    private VideoBubble clickButtonVideo() {
        videoButton.click();
        return onDisplayed(VideoBubble.class);
    }
    
    @WhenPageOpens
    public void switchToHTMLEditor() {
        htmlEditButton.click();
    }
    
}
