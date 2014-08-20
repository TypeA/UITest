package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.core.FileLoader;
import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-bubble-background"))
public class SettingsBubbleBackgroundBlock extends UIBlock {

    @FindBy(css = ".b-feedsettings-upload")
    private Link uploadImage;

    @FindBy(css = ".b-feedsettings-delete-icon")
    private Button deleteIcon;

    @FindBy(css = "#pickfiles")
    private UIElement backgroundImageFileInput;
    
    
    public Link getUploadImage() {
        return uploadImage;
    }

    public Button getDeleteIcon() {
        return deleteIcon;
    }

    public void uploadBackgroundImage(String path) {
         FileLoader fileLoader = new FileLoader(); 
         fileLoader.upload(path, backgroundImageFileInput);
    }
}
