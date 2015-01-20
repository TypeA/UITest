package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks;

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
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
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

    @FindBy(css = ".s-nav-item-you a")
    public Link authorizedAs;

    @FindBy(css = ".s-nav-item-post a")
    public Link newPost;

    @FindBy(css = ".s-nav-item-profile a")
    public Link profile;

    @FindBy(css = ".s-nav-item-prodile-edit a")
    public Link editProfile;

    @FindBy(css = ".s-nav-item-edit-pics a")
    public Link editPics;

    @FindBy(css = ".s-nav-item-counter a")
    public Link messagesInMenu;

    @FindBy(css = ".s-nav-item-scheduled a")
    public Link sheduledEntries;

    @FindBy(css = ".s-nav-item-comments a")
    public Link recentComments;

    @FindBy(css = ".s-nav-item-statistics a")
    public Link statistics;

    @FindBy(css = ".s-nav-item-scrapbook a")
    public Link scrapbook;

    @FindBy(css = ".s-nav-item-tags a")
    public Link tags;

    @FindBy(css = ".s-nav-item-memories a")
    public Link memories;

    @FindBy(css = ".s-nav-item-customize a")
    public Link journalStyle;

    @FindBy(css = ".s-nav-item-settings a")
    public Link settings;

    @FindBy(css = ".s-nav-item-logout a")
    public Link logOut;

    @StepGroup
    public MyJournalPage clickOnAuthotizedAs() {
        authorizedAs.click();
        /* String pageSource = getDriver().getPageSource();
         Pattern pattern = Pattern.compile("lj:user=\"(.*)\" >.*");
         Matcher matcher = pattern.matcher(pageSource);
         String name = "";     
         if (matcher.find()) {
         name = matcher.group(0);
         }*/
        return onOpened(MyJournalPage.class);//, new Url().setPrefix(name + "."));
    }

    @StepGroup
    public UpdateBmlPageLogged clickOnNewPost() {
        newPost.click();
        return onOpened(UpdateBmlPageLogged.class);
    }

    @StepGroup
    public ProfilePage clickOnProfile() {
        profile.click();
         return onOpened(ProfilePage.class);//, new Url().setPrefix(name + "."));
    }

    @StepGroup
    public EditProfilePage clickOnEditProfie() {
        editProfile.click();
        return onOpened(EditProfilePage.class);
    }

    @StepGroup
    public EditPicsPage clickOnEditPics() {
        editPics.click();
        return onOpened(EditPicsPage.class);
    }

    @StepGroup
    public InboxMainPage clickOnMessagesInMenu() {
        messagesInMenu.click();
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
    public StatisticsMainPage clickOnStatistics() {
        statistics.click();
        return onOpened(StatisticsMainPage.class);
    }

    @StepGroup
    public ScrapBookMainPage clickOnScrapbook() {
        scrapbook.click();
         return onOpened(ScrapBookMainPage.class);//, new Url().setPrefix(name + "."));
    }

    @StepGroup
    public TagsPage clickOnTags() {
        tags.click();
        return onOpened(TagsPage.class);
    }

    @StepGroup
    public MemoriesPage clickOnMemories() {
        memories.click();
        return onOpened(MemoriesPage.class);
    }

    @StepGroup
    public CustomizeJournalPage clickOnJournalStyle() {
        journalStyle.click();
        return onOpened(CustomizeJournalPage.class);
    }

    @StepGroup
    public SettingsMainPage clickOnSettings() {
        settings.click();
        return onOpened(SettingsMainPage.class);
    }

    @StepGroup
    public ServicePageUnlogged clickOnLogOut() {
        logOut.click();
        return onOpened(ServicePageUnlogged.class);
    }
}
