package com.livejournal.uitests.pages.service_pages.friends_feed_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.FeedBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.FiltersBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.OverallBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.SidebarBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.settings.SettingsBlock;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/feed")
public class FriendsFeedLogged extends ServicePageLogged {

    private OverallBlock overall;

    @StepGroup
    public boolean settingsIsDisplayed() {
        return overall.settingsIsDisplayed();
    }

    @StepGroup
    public ArrayList<String> getMainSettings() {
        return overall.getMainSettings();
    }

    @StepGroup
    public FiltersBlock openFilters() {
        return overall.openFilters();
    }

    @StepGroup
    public FriendsFeedLogged clickUpButton() {
        overall.clickUpButton();
        return this;
    }

    @StepGroup
    public boolean upIsDisplayed() {
        return overall.upIsDisplayed();
    }

    @FindBy(css = ".l-flatslide-settingslink-open")
    private Button settingsButton;

    @FindBy(css = "a .l-flatslide-settingslink-close svg")
    private Button closeSettingsButton;

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

    @FindBy(css = ".b-pager-link--prev")
    public Button previousButton;

    @FindBy(css = ".b-pager-link--next")
    public Button nextButton;

    @StepGroup
    public FriendsFeedLogged openPreviousPage() {
        previousButton.click();
        return this;
    }

    @StepGroup
    public FriendsFeedLogged openNextPage() {
        nextButton.click();
        return this;
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
