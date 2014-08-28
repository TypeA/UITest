package com.livejournal.uitests.pages.service_pages.friends_feed_pages;

import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.ColorSettings;
import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.SettingsBlock;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/feed")
public class FriendsFeedLogged extends ServicePageLogged {

    @FindBy(css = ".b-lenta-preview")
    public UIElement lentaPreview;

    //////////SUPPORT BUTTONS
    @FindBy(css = "a[ng-class*='filters']")
    private Button filtersButton;

    @FindBy(css = "a[href*='/customize/#feed']")
    private Button settingsButton;

    public SettingsBlock openSettings() {
        settingsButton.click();
        return on(SettingsBlock.class);
    }

    ////////////FEED
    @FindBy(css = ".l-flatslide-intro-heads .b-lenta-head-title")
    private TextBlock feedTitle;

    public String getFeedTitle() {
        return feedTitle.getText();
    }


}
