package com.livejournal.uitests.pages.service_pages.unified_scheme.header.MenuBlocks;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.inbox_pages.InboxMainPage;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePage;
import com.livejournal.uitests.pages.service_pages.scrapbook.ScrapBookMainPage;
import com.livejournal.uitests.pages.service_pages.settings.CustomizeJournalPage;
import com.livejournal.uitests.pages.service_pages.settings.EditPicsPage;
import com.livejournal.uitests.pages.service_pages.settings.EditProfilePage;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import com.livejournal.uitests.pages.service_pages.settings.TagsPage;
import com.livejournal.uitests.pages.service_pages.tools.MemoriesPage;
import com.livejournal.uitests.pages.service_pages.tools.RecentCommentsPage;
import com.livejournal.uitests.pages.service_pages.tools.StatisticsMainPage;
import com.livejournal.uitests.pages.service_pages.update.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".s-nav-item-user .s-drop"))
public class MyJournalMenu extends UIBlock {

    @FindBy(css = ".s-nav-item-you")
    public Link authorizedAs;

    @FindBy(css = ".s-nav-item-post")
    public Link newPost;

    @FindBy(css = ".s-nav-item-profile")
    public Link profile;

    @FindBy(css = ".s-nav-item-prodile-edit")
    public Link editProfile;

    @FindBy(css = ".s-nav-item-edit-pics")
    public Link editPics;

    @FindBy(css = ".s-nav-item-counter")
    public Link messagesInMenu;

    @FindBy(css = ".s-nav-item-scheduled")
    public Link sheduledEntries;

    @FindBy(css = ".s-nav-item-comments")
    public Link recentComments;

    @FindBy(css = ".s-nav-item-statistics")
    public Link statistics;

    @FindBy(css = ".s-nav-item-scrapbook")
    public Link scrapbook;

    @FindBy(css = ".s-nav-item-tags")
    public Link tags;

    @FindBy(css = ".s-nav-item-memorie")
    public Link memories;

    @FindBy(css = ".s-nav-item-customize")
    public Link journalStyle;

    @FindBy(css = ".s-nav-item-settings")
    public Link settings;

    @FindBy(css = ".s-nav-item-logout")
    public Link logOut;

    @StepGroup
    public MyJournalPage clickOnAuthotizedAs() {
        authorizedAs.click();
        return on(MyJournalPage.class);
    }

    @StepGroup
    public UpdateBmlPageLogged clickOnNewPost() {
        newPost.click();
        return on(UpdateBmlPageLogged.class);
    }

    @StepGroup
    public ProfilePage clickOnProfile() {
        profile.click();
        return on(ProfilePage.class);
    }

    @StepGroup
    public EditProfilePage clickOnEditProfie() {
        editProfile.click();
        return on(EditProfilePage.class);
    }

    @StepGroup
    public EditPicsPage clickOnEditPics() {
        editPics.click();
        return on(EditPicsPage.class);
    }

    @StepGroup
    public InboxMainPage clickOnMessagesInMenu() {
        messagesInMenu.click();
        return on(InboxMainPage.class);
    }

    @StepGroup
    public SheduledEntriesPage clickOnSheduledEntries() {
        sheduledEntries.click();
        return on(SheduledEntriesPage.class);
    }

    @StepGroup
    public RecentCommentsPage clickOnRecentComments() {
        recentComments.click();
        return on(RecentCommentsPage.class);
    }

    @StepGroup
    public StatisticsMainPage clickOnStatistics() {
        statistics.click();
        return on(StatisticsMainPage.class);
    }

    @StepGroup
    public ScrapBookMainPage clickOnScrapbook() {
        scrapbook.click();
        return on(ScrapBookMainPage.class);
    }

    @StepGroup
    public TagsPage clickOnTags() {
        tags.click();
        return on(TagsPage.class);
    }

    @StepGroup
    public MemoriesPage clickOnMemories() {
        memories.click();
        return on(MemoriesPage.class);
    }

    @StepGroup
    public CustomizeJournalPage clickOnJournalStyle() {
        journalStyle.click();
        return on(CustomizeJournalPage.class);
    }

    @StepGroup
    public SettingsMainPage clickOnSettings() {
        settings.click();
        return on(SettingsMainPage.class);
    }

    @StepGroup
    public ServicePageUnlogged clickOnLogOut() {
        logOut.click();
        return on(ServicePageUnlogged.class);
    }
}
