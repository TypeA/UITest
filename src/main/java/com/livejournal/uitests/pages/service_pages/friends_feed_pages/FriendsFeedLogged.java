package com.livejournal.uitests.pages.service_pages.friends_feed_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.SettingsBlock;
import net.thucydides.core.annotations.DefaultUrl;
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

    @FindBy(css = "a.l-flatslide-settingslink")
    private Button settingsButton;

    ////////////FEED
    @FindBy(css = ".l-flatslide-intro-heads .b-lenta-head-title")
    private TextBlock feedTitle;

    @FindBy(css = ".l-flatslide-intro-heads .i-ljuser-type-P a:not([href*='profile'])")
    public Link userName;

    
    
    public synchronized SettingsBlock openSettings() {
        settingsButton.click();
        return on(SettingsBlock.class);
    }

    public synchronized String getFeedTitle() {
        return feedTitle.getText();
    }

    public synchronized Link getUserName() {
        return userName;
    }

}
