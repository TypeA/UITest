package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-feedsettings-inner"))
public class SettingsBlock extends UIBlock {

    private FeedSettingsBlock feedSettingsBlock;
    private TextSettingsBlock textSettingsBlock;
    private LinksSettingsBlock linkSettingsBlock;
    private PangingTypeSettingsBlock pangingTypeSettingsBlock;

    @FindBy(css = ".b-feedsettings-save")
    private Button saveButton;

    @FindBy(css = ".b-feedsettings-cancel")
    private Button cancelButton;

    @FindBy(css = ".b-feedsettings-restore")
    private Button restoreButton;

    public FeedSettingsBlock getFeedSettingsBlock() {
        return feedSettingsBlock;
    }

    public TextSettingsBlock getTextSettingsBlock() {
        return textSettingsBlock;
    }

    public LinksSettingsBlock getLinkSettingsBlock() {
        return linkSettingsBlock;
    }

    public PangingTypeSettingsBlock getPangingTypeSettingsBlock() {
        return pangingTypeSettingsBlock;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getRestoreButton() {
        return restoreButton;
    }
}
