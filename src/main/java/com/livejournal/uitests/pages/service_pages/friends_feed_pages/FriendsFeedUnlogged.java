package com.livejournal.uitests.pages.service_pages.friends_feed_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.FeedBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.SidebarBlock;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/feed")
public class FriendsFeedUnlogged extends ServicePageUnlogged {

    @FindBy(css = "button[ng-class*='filters']")
    private Button filtersButton;

    @FindBy(css = ".l-flatslide-settingslink-open")
    private Button settingsButton;

    @StepGroup
    public boolean filtersIsDisplayed() {
        try {
            return filtersButton.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    @StepGroup
    public boolean settingsIsDisplayed() {
        try {
            return settingsButton.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
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
