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
        @FindBy(css = ".b-feedsettings-block"))
public class LinksSettingsBlock extends UIBlock{

    @FindBy(css = "a[ng-style*='url_color']")
    private Link linkColor;

    @FindBy(css = "a[ng-style*='url_hover_color']")
    private Link onHoverColor;

    @FindBy(css = "a[ng-style*='url_visited_color']")
    private Link visitedLink;

    public Link getLinkColor() {
        return linkColor;
    }

    public void setLinkColor(Link linkColor) {
        this.linkColor = linkColor;
    }

    public Link getOnHoverColor() {
        return onHoverColor;
    }

    public Link getVisitedLink() {
        return visitedLink;
    }

}
