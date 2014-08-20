package com.livejournal.uitests.pages.service_pages.friends_feed_pages;

import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.SettingsBlock;
import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/feed")
public class FriendsFeedLogged extends ServicePageLogged {

    private SupportButtonBlock supportButtonBlock;
    private SettingsBlock settingsBlock;

    public SupportButtonBlock getSupportButtonBlock() {
        return supportButtonBlock;
    }

    public SettingsBlock getSettingsBlock() {
        return settingsBlock;
    }
}
