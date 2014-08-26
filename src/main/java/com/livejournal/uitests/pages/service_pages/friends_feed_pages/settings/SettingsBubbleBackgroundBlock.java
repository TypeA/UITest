package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.core.FileLoader;
import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Select;

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

    @FindBy(css = "select[ng-model*='font_size']")
    private Select position;

    @FindBy(css = "input[ng-checked*='repeat_x']")
    private CheckBox horizontalRepeat;

    @FindBy(css = "input[ng-checked*='repeat_y']")
    private CheckBox verticalRepeat;

    public Link getUploadImage() {
        return uploadImage;
    }

    public Button getDeleteIcon() {
        return deleteIcon;
    }

    public Select getPosition() {
        return position;
    }

    public CheckBox getHorizontalRepeat() {
        return horizontalRepeat;
    }

    public CheckBox getVerticalRepeat() {
        return verticalRepeat;
    }

    public UIElement getBackgroundImageFileInput() {
        return backgroundImageFileInput;
    }

    @FindBy(css = "#pickfiles")
    private UIElement backgroundImageFileInput;


}
