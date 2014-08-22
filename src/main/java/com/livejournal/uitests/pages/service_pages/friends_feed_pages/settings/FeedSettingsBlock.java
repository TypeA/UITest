package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
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

    @FindBy(css = ".b-input-simple")
    private TextField title;

    @FindBy(css = ".b-feedsettings-action-bg-color")
    private Link backgroundColor;

    @FindBy(css = ".b-feedsettings-action-bg-image")
    private Link backgroundImage;

    @FindBy(css = ".b-feedsettings-action-fg-color")
    private Link foregroundColor;

    @FindBy(css = ".b-feedsettings-action-bg-sidebar")
    private Link sidebarBackground;

    @FindBy(css = ".b-feedsettings-action-head-color")
    private Link elementsBackground;

    @FindBy(css = "a[ng-style*='element_color']")
    private Link elementsColor;

    @FindBy(css = "a[ng-style*='element_background_color']")
    private Link bordersColor;

    public TextField getTitle() {
        return title;
    }

    public Link getBackgroundColor() {
        return backgroundColor;
    }

    public Link getBackgroundImage() {
        return backgroundImage;
    }

    public Link getForegroundColor() {
        return foregroundColor;
    }

    public Link getSidebarBackground() {
        return sidebarBackground;
    }

    public Link getElementsBackground() {
        return elementsBackground;
    }

    public Link getElementsColor() {
        return elementsColor;
    }

    public Link getBordersColor() {
        return bordersColor;
    }

}
