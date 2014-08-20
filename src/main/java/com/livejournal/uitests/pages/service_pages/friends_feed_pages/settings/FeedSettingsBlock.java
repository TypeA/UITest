package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-feedsettings-block-feed"))
public class FeedSettingsBlock extends UIBlock {

    @FindBy(css = ".b-feedsettings-action-bg-image")
    private Link backgroundImage;

    public Link getBackgroundImage() {
        return backgroundImage;
    }

}
