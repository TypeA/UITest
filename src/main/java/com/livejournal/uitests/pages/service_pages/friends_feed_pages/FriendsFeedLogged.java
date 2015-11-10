package com.livejournal.uitests.pages.service_pages.friends_feed_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.FeedBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.FiltersBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.SidebarBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.settings.SettingsBlock;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/feed")
public class FriendsFeedLogged extends ServicePageLogged {

    @FindBy(css = "button[ng-class*='filters']")
    private Button filtersButton;

    @FindBy(css = ".l-flatslide-settingslink-open")
    public Button settingsButton;

    @FindBy(css = "a .l-flatslide-settingslink-close svg")
    public Button closeSettingsButton;

    @StepGroup
    public SettingsBlock openSettings() {
        settingsButton.click();
        return onDisplayed(SettingsBlock.class);
    }

    @StepGroup
    public FriendsFeedLogged closeSettings() {
        closeSettingsButton.moveMouseOver();
        return onDisplayed(SettingsBlock.class).waitThatSettingsBlockClose();
    }
    
        @StepGroup
    public FiltersBlock openFilters() {
        filtersButton.click();
        return onDisplayed(FiltersBlock.class);
    }

    @StepGroup
    public SidebarBlock sidebar() {
       return onDisplayed(SidebarBlock.class);
    }
    
        @StepGroup
    public FeedBlock feed() {
       return onDisplayed(FeedBlock.class);
    }
}
