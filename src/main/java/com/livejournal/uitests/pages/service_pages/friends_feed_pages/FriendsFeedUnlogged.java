package com.livejournal.uitests.pages.service_pages.friends_feed_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.FeedBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.OverallBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.SidebarBlock;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/feed")
public class FriendsFeedUnlogged extends ServicePageUnlogged {

    private OverallBlock overall;

    @StepGroup
    public SidebarBlock sidebar() {
        return onDisplayed(SidebarBlock.class);
    }

    @StepGroup
    public FeedBlock feed() {
        return onDisplayed(FeedBlock.class);
    }

    public boolean filtersIsDisplayed() {
        return overall.filtersIsDisplayed();
    }

    @StepGroup
    public boolean settingsIsDisplayed() {
        return overall.settingsIsDisplayed();
    }

    @StepGroup
    public ArrayList<String> getMainSettings() {
        return overall.getMainSettings();
    }

}
