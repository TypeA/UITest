package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-feedsettings-block"))
public class TextSettingsBlock extends UIBlock {

    @FindBy(css = "select[ng-model*='font_size']")
    private Select size;

    @FindBy(css = "select[ng-model*='font_family']")
    private Select font;

    @FindBy(css = "a[ng-style*='font_color']:not([ng-style*='sidebar'])")
    private Link mainTextColor;

    @FindBy(css = "a[ng-style*='sidebar_font_color']")
    private Link sidebarTextColor;

    public Select getFont() {
        return font;
    }

    public void setFont(Select font) {
        this.font = font;
    }

    public Link getMainTextColor() {
        return mainTextColor;
    }

    public Link getSidebarTextColor() {
        return sidebarTextColor;
    }

}
