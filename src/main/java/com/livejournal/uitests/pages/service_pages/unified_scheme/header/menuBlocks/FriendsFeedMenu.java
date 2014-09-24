package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.settings.BannedUsersPage;
import com.livejournal.uitests.pages.service_pages.settings.ManageCommunitiesPage;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageFriendsPage;
import com.livejournal.uitests.pages.service_pages.settings.friends.ManageGroupsPage;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".s-nav-item-friends .s-drop"))
public class FriendsFeedMenu extends UIBlock {

    @FindBy(css = ".s-nav-rootlink-feed")
    private Link friendsFeed;

    @FindBy(css = ".s-nav-item-editgroups")
    private Link mngGroups;

    @FindBy(css = ".s-nav-item-edit")
    private Link mngFriends;

    @FindBy(css = ".s-nav-item-manage")
    private Link mngCommunities;

    @FindBy(css = ".s-nav-item-banusers")
    private Link bannedUsers;

    @StepGroup
    public FriendsFeedLogged clickOnFriendsFeed() {
        friendsFeed.click();
        return on(FriendsFeedLogged.class);
    }

    @StepGroup
    public ManageGroupsPage clickOnMngGroups() {
        mngGroups.click();
        return on(ManageGroupsPage.class);
    }

    @StepGroup
    public ManageFriendsPage clickOnMngFriends() {
        mngFriends.click();
        return on(ManageFriendsPage.class);
    }

    @StepGroup
    public ManageCommunitiesPage clickOnMngCommunities() {
        mngCommunities.click();
        return on(ManageCommunitiesPage.class);
    }

    @StepGroup
    public BannedUsersPage clickOnBannedUsers() {
        bannedUsers.click();
        return on(BannedUsersPage.class);
    }
}
