package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.inbox_pages.InboxMainPage;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageLogged;
import com.livejournal.uitests.pages.service_pages.scrapbook.ScrapBookMainPage;
import com.livejournal.uitests.pages.service_pages.settings.ManageCommunitiesPage;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import com.livejournal.uitests.pages.service_pages.support_faq.logged.SupportMainPageLogged;
import com.livejournal.uitests.pages.service_pages.tools.RecentCommentsPage;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.tools.StatisticsMainPage;
import com.livejournal.uitests.pages.service_pages.video.VideoAlbumMainPage;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".s-header-user-menu"))
public class MyJournalMenu extends UIBlock {

    @FindBy(css = ".s-header-sub-list-item__link--profile")
    private Link profile;

    @FindBy(css = ".s-header-sub-list-item__link--statistics")
    private Link statistics;

    @FindBy(css = ".s-header-sub-list-item__link--photo")
    private Link scrapbook;

    @FindBy(css = ".s-header-sub-list-item__link--video")
    private Link video;

    @FindBy(css = ".s-header-sub-list-item__link--messages")
    private Link messages;

    @FindBy(css = ".s-header-sub-list-item__link--scheduled")
    private Link sheduledEntries;

    @FindBy(css = ".s-header-sub-list-item__link--comments")
    private Link recentComments;

    @FindBy(css = ".s-header-sub-list-item__link--manage-communities")
    private Link manageCommunities;

    @FindBy(css = ".s-header-sub-list-item__link--settings")
    private Link settings;

    @FindBy(css = ".s-header-sub-list-item__link--support")
    private Link support;

    @FindBy(css = ".s-header-sub-list-item__link--logout")
    private Link logOut;

    @StepGroup
    public ProfilePageLogged clickOnProfile() {
        profile.click();
        return onOpened(ProfilePageLogged.class);
    }

    @StepGroup
    public StatisticsMainPage clickOnStatistics() {
        statistics.click();
        return onOpened(StatisticsMainPage.class);
    }

    @StepGroup
    public ScrapBookMainPage clickOnScrapbook() {
        scrapbook.click();
        return onOpened(ScrapBookMainPage.class);
    }

    @StepGroup
    public VideoAlbumMainPage clickOnVideo() {
        video.click();
        return onOpened(VideoAlbumMainPage.class);
    }

    @StepGroup
    public InboxMainPage clickOnMessagesInMenu() {
        messages.click();
        return onOpened(InboxMainPage.class);
    }

    @StepGroup
    public SheduledEntriesPage clickOnSheduledEntries() {
        sheduledEntries.click();
        return onOpened(SheduledEntriesPage.class);
    }

    @StepGroup
    public RecentCommentsPage clickOnRecentComments() {
        recentComments.click();
        return onOpened(RecentCommentsPage.class);
    }

    @StepGroup
    public ManageCommunitiesPage clickOnManageCommunities() {
        manageCommunities.click();
        return onOpened(ManageCommunitiesPage.class);
    }

    @StepGroup
    public SettingsMainPage clickOnSettings() {
        settings.click();
        return onOpened(SettingsMainPage.class);
    }

    @StepGroup
    public SupportMainPageLogged clickOnSupport() {
        support.click();
        return onOpened(SupportMainPageLogged.class);
    }

    @StepGroup
    public ServicePageUnlogged clickOnLogOut() {
        logOut.click();
        return onOpened(ServicePageUnlogged.class);
    }
}
