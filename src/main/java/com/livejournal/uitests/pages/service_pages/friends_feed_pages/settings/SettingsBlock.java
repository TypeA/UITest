package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

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

    public FeedSettingsBlock getFeedSettingsBlock() {
        return feedSettingsBlock;
    }
}
