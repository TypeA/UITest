package com.livejournal.uitests.pages.service_pages.friends_feed_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.SettingsBlock;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(css = "a:not(.l-flatslide-settingslink-opened).l-flatslide-settingslink")
    public Button settingsButton;

    @FindBy(css = ".b-pager-prev")
    private Button previousButton;

    @FindBy(css = ".b-pager-next")
    private Button nextButton;

    ////////////FEED
    @FindBy(css = ".l-flatslide-intro-heads .b-lenta-head-title")
    private TextBlock feedTitle;

    @FindBy(css = ".l-flatslide-intro-heads .i-ljuser-type-P a:not([href*='profile'])")
    public Link userName;

    @StepGroup
    public SettingsBlock openSettings() {
        settingsButton.click();
        return on(SettingsBlock.class);
    }

    @StepGroup
    public String getFeedTitle() {
        return feedTitle.getText();
    }

    @StepGroup
    public Link getUserName() {
        return userName;
    }

    @StepGroup
    public boolean displaySwitchPagesButtons() {
        try {
            return previousButton.isDisplayed() && nextButton.isDisplayed();

        } catch (NoSuchElementException ex) {
            return false;
        }
    }

}
