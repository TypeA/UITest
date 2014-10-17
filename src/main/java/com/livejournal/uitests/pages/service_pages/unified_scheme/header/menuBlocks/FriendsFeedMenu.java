package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks;

import com.livejournal.uisteps.core.Url;
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

    @FindBy(css = ".s-nav-item-editgroups a")
    private Link mngGroups;

    @FindBy(css = ".s-nav-item-edit a")
    private Link mngFriends;

    @FindBy(css = ".s-nav-item-manage a")
    private Link mngCommunities;

    @FindBy(css = ".s-nav-item-banusers a")
    private Link bannedUsers;

    @StepGroup
    public void clickOnFriendsFeed() {
        friendsFeed.click();
      //return on(FriendsFeedLogged.class);//, new Url().setPrefix(name + "."));
    }

    @StepGroup
    public void clickOnMngGroups() {
        mngGroups.click();
       //return on(ManageGroupsPage.class);
    }

    @StepGroup
    public void clickOnMngFriends() {
        mngFriends.click();
       // return on(ManageFriendsPage.class);
    }

    @StepGroup
    public void clickOnMngCommunities() {
        mngCommunities.click();
       // return on(ManageCommunitiesPage.class);
    }

    @StepGroup
    public void clickOnBannedUsers() {
        bannedUsers.click();
        //return on(BannedUsersPage.class);
    }
}